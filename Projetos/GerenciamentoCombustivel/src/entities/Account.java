package entities;

public abstract class Account {
    private Integer idAccount;
    private double balance = 0;

    public Account() {
    }

    public Account(Integer idAccount) {
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

    public abstract void deposit();
    public abstract void sake();
    public abstract  void transfer();
}
