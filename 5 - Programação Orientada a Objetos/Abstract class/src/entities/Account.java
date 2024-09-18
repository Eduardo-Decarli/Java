package entities;

//Tornar uma classe abstrata faz com que ela não possa ser instanciada, mas poderá ser herdada
public abstract class Account {
    private Integer number;
    private String holder;
    protected Double balance;

    public Account(){

    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(double amount){
        balance -= amount + 5.0;
    }

    public void deposit(double amount){
        balance += amount;
    }
    //Aqui declaramos um método abstrato, eles são usados para se manter um código com delegação de suas funções e caracteristicas
    //As classes que utilizarem esse método irão fazer a implementação dele
    //Qualquer classe que extends uma classe abtrata, será obrigada a implementar os métodos abstratos
    public abstract String typeAccount();

}
