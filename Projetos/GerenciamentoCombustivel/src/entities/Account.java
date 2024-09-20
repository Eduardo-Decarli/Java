package entities;

public abstract class Account {
    private Integer idAccount;
    private double balance;

    public Account() {
    }

    public Account(Integer idAccount, double balance) {
        this.idAccount = idAccount;
        this.balance = balance;
    }

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract void deposit();
    public abstract void sake();
    public abstract  void transfer();
}
