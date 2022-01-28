package unit_3.homework3_3.task332.accounts;

public abstract class Account {

    protected int balance;

    public Account() {
    }

    public Account(int balance) {
        this.balance = balance;
    }

    public abstract void pay(int amount);

    public abstract void transfer(Account account, int amount);

    public abstract void addMoney(int amount);

    abstract boolean checkAccount(Account account, int amount);

    abstract String getDescription();

    @Override
    public abstract String toString();

}
