package entities;

//Usar o atributo final em classe, torna a classe impossivel de ser herdada
public final class SavingsAccount extends Account{
    private Double interestrate;

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestrate) {
        super(number, holder, balance);
        this.interestrate = interestrate;
    }

    public Double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(Double interestrate) {
        this.interestrate = interestrate;
    }

    public void updateBalance(){
        balance += balance * interestrate;
    }

    //Aqui temos um Override entre o método withdraw() de Account.
    //Agora a classe SavingsAccount passa a utilizar essa implementação alterada do withdraw()
    @Override
    //Usar final em métodos, torna o método impossivel de ser sobreescrito/sofrer override
    public final void withdraw(double amount){
        balance -= amount;
    }
}
