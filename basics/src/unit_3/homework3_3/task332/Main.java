package unit_3.homework3_3.task332;

import unit_3.homework3_3.task332.accounts.Account;
import unit_3.homework3_3.task332.accounts.CheckingAccount;
import unit_3.homework3_3.task332.accounts.CreditAccount;
import unit_3.homework3_3.task332.accounts.SavingsAccount;

public class Main {
    public static void main(String[] args) {

        System.out.println();
        Account account1 = new SavingsAccount(0);
        Account account2 = new CheckingAccount(-500_000); // будет открыт с балансом 0
        Account account3 = new CreditAccount(-500_000);

        System.out.println();

        //Со сберегательного счета нельзя платить, только переводить и пополнять.
        account1.addMoney(1_000_000);
        account1.addMoney(-1_000_000); // не пройдет
        account1.pay(250_000); // не пройдет, т.к. платить нельзя
        account1.transfer(account2, 250_000);

        System.out.println();
        //Кредитный не может иметь положительный баланс – если платить с него,
        // то уходит в минус, чтобы вернуть в 0, надо пополнить его.

        account1.transfer(account3, 750_000); // не пройдет, т.к. станет плюс
        account1.transfer(account3, 250_000);
        account3.addMoney(500_000); // не пройдет, т.к. станет плюс
        account3.addMoney(250_000);
        account3.pay(1_000_000);
        System.out.println(account3);


        System.out.println();
        //Расчетный может выполнять все три операции, но не может уходить в минус.
        account2.transfer(account1, 1_000_000); // не пройдет, т.к. в минус
        account2.transfer(account1, 250_000);
        account2.addMoney(100_000);
        account2.pay(200_000); // не пройдет, т.к. в минус
        account2.pay(100_000);

        System.out.println();
        //ну и на сам себя и на null
        account1.transfer(account1, 250_000);
        account1.transfer(null, 250_000);

    }
}

