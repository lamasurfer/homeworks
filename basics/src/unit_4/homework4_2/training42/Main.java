package unit_4.homework4_2.training42;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {

        Deque<Transaction> transactions = new ArrayDeque<>();

        Account account1 = new Account("77777777777777", "Mike Ross", BigDecimal.valueOf(10_000));
        Account account2 = new Account("11111111111111", "Bill Short", BigDecimal.valueOf(5_000_000));
        Account account3 = new Account("33333333333333", "John Vot", BigDecimal.valueOf(1000));

        Transaction transaction1 = new Transaction(account1, account2, BigDecimal.valueOf(9_000));
        Transaction transaction2 = new Transaction(account3, account2, BigDecimal.valueOf(1_000));
        Transaction transaction3 = new Transaction(account1, account2, BigDecimal.valueOf(1_000));
        Transaction transaction4 = new Transaction(account1, account2, BigDecimal.valueOf(1_000));

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        System.out.println("Начальное состояние счетов");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        while (true) {
            Transaction t = transactions.poll();
            if (t == null) {
                break;
            }
            boolean transactionStatus = t.make();
            if (!transactionStatus) {
                System.out.printf("Ошибка обработки транзакции: %s\n\n", t.toString());
            }

        }

        System.out.println("Конечное состояние счетов");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

    }
}


