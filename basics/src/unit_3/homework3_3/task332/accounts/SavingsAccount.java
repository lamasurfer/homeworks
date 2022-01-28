package unit_3.homework3_3.task332.accounts;

public class SavingsAccount extends Account {

    private static int counter = 1;
    private final int MIN_BALANCE = 0;
    private int balance;
    private int id;
    private String name = "Сберегательный";

    public SavingsAccount(int balance) {
        super(balance);
        if (balance >= MIN_BALANCE) {
            this.balance = balance;
        } else {
            System.out.println("Баланс сберегательного счета не может быть отрицательным.");
            this.balance = MIN_BALANCE;
        }
        this.id = counter++;
        System.out.println("Открыт счет " + getDescription() + " с балансом " + this.balance + ".");
    }

    @Override
    public void pay(int amount) {
        System.out.println("Невозможно провести оплату со сберегательного счета. Выберите другой счет.");
    }

    @Override
    public void transfer(Account account, int amount) {
        if (checkAccount(account, amount)) {
            this.balance -= amount;
            System.out.println("Со счета " + getDescription() + " произведен перевод " + amount + " на счет "
                    + account.getDescription() + ". Остаток: " + this.balance + ".");
            account.addMoney(amount);
        }
    }

    @Override
    public void addMoney(int amount) {
        if (amount < 0) {
            System.out.println("Некорректная операция. Введено отрицательное число.");
        } else {
            this.balance += amount;
            System.out.println("На счет " + getDescription() + " внесено " + amount + ". Баланс: "
                    + this.balance + ".");
        }
    }

    @Override
    protected boolean checkAccount(Account account, int amount) {
        CreditAccount creditAccount = new CreditAccount();
        if (this == account || account == null) {
            System.out.println("Некорректная операция. Выберите другой счет.");
            return false;
        } else if (amount < 0) {
            System.out.println("Некорректная операция. Введено отрицательное число.");
            return false;
        } else if ((account.getClass() == creditAccount.getClass()) && ((account.balance + amount) > 0)) {
            System.out.println("Некорректная операция. На запрашиваемый кредитный счет можно перевести неболее: "
                    + Math.abs(account.balance) + ".");
            return false;
        } else if (amount > this.balance) {
            System.out.println("На счете " + getDescription() + " недостаточно средств.");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getDescription() {
        return name + " #" + id;
    }

    @Override
    public String toString() {
        return this.name + " #" + id + ", баланс: " + this.balance + ".";
    }
}
