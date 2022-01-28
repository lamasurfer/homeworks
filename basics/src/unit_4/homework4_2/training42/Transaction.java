package unit_4.homework4_2.training42;

import java.math.BigDecimal;

public class Transaction {

    private Account accountFrom;
    private Account accountTo;
    private BigDecimal amount;

    public Transaction(Account accountFrom, Account accountTo, BigDecimal amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("со счета: %s, на счет: %s, сумма: %s", accountFrom.getNumber(), accountTo.getNumber(), amount);
    }

    public boolean make() {
        accountFrom.setAmount(accountFrom.getAmount().subtract(amount));
        if (accountFrom.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            accountFrom.setAmount(accountFrom.getAmount().add(amount));
            return false;
        }
        accountTo.setAmount(accountTo.getAmount().add(amount));
        return true;

    }
}
