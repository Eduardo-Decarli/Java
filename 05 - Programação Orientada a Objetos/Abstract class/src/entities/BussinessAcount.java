package entities;

//A palavra extends declara que a classe herda os atributos de Account
public class BussinessAcount extends Account{
    private Double loanLimit;

    public BussinessAcount(){
    }

    public BussinessAcount(Integer number, String holder, Double balance, Double loanLimit) {
        //A palabra super recupera os atributos da superclasse
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount){
        if(amount <= loanLimit) {
            //classe criada em Account pode ser puxada sem problemas
            deposit(amount);
        }
    }

    //Usando a palavra Super em métodos
    @Override
    public void withdraw(double amount){
        //Aqui chamamos o método withdraw e reaproveitamos a lógica dele, diminuindo 5 reais e mais 2.
        super.withdraw(amount);
        balance -= 2.0;
    }

    @Override
    public String typeAccount(){
        return "BussinessAccount";
    }
}
