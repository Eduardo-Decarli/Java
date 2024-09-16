package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    private String name;
    //Aqui temos uma enumeração do tipo WorkerLevel
    private WorkerLevel level;
    private double salary;
    //Aqui temos uma composição entre as classes Worker e HourContract
    private HourContract contract;

    //Aqui temos uma composição de um Worker para muitos HourContract
    List<HourContract> contracts = new ArrayList<>();

    public Worker(){

    }

    public Worker(String name, WorkerLevel level, double salary) {
        this.name = name;
        this.level = level;
        this.salary = salary;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int ano, int mes){
        double income = 0.0;
        for(HourContract x : contracts){
            if(x.getDate().getMonthValue() == mes && x.getDate().getYear() == ano){
                income += x.totalValue();
            }
        }
        return income;
    }
}
