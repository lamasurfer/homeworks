package unit_4.homework4_2.training42;

import java.math.BigDecimal;

public class Account {

    String number;
    String owner;
    BigDecimal amount;

    public Account(String number, String owner, BigDecimal amount) {
        this.number = number;
        this.owner = owner;
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Счет номер: %s, владелец: %s, сумма: %s", number, owner, amount);
    }
}
