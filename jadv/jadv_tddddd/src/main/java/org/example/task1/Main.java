package org.example.task1;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        CreditCalc creditCalc = new CreditCalc();

        // https://www.banki.ru/products/credits/vtb/calculator/?amount=100000&credit_id=4331&currency=RUB&period=365

        BigDecimal creditAmount = new BigDecimal(100_000);
        BigDecimal annualInterestRate = new BigDecimal("6.4");
        int creditTermInMonths = 12;

        System.out.println("Сумма кредита: " + creditAmount);
        System.out.println("Ставка: " + annualInterestRate);
        System.out.println("Срок: " + creditTermInMonths);

        BigDecimal annuityPayment = creditCalc.getAnnuityPayment(creditAmount, annualInterestRate, creditTermInMonths);
        System.out.println("Ежемесячный платеж: " + annuityPayment);

        BigDecimal totalOverpayment = creditCalc.getOverpayment(creditAmount, annualInterestRate, creditTermInMonths);
        System.out.println("Переплата по кредиту: " + totalOverpayment);

        BigDecimal totalPayment = creditCalc.getTotalCost(creditAmount, annualInterestRate, creditTermInMonths);
        System.out.println("Общая выплата: " + totalPayment);
    }
}
