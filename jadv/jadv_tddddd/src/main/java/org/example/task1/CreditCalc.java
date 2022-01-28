package org.example.task1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class CreditCalc {

    private static final MathContext CONTEXT = MathContext.DECIMAL32;
    private static final RoundingMode BANKERS = RoundingMode.HALF_EVEN;
    private static final int SCALE = 0;

    private static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    private static final BigDecimal MONTHS_IN_YEAR = BigDecimal.valueOf(12);


    // https://www.raiffeisen.ru/wiki/kak-rasschitat-annuitetnyj-platezh/
    private BigDecimal getMonthlyInterestRate(BigDecimal annualInterestRate) {

        return annualInterestRate.divide(HUNDRED, CONTEXT)
                .divide(MONTHS_IN_YEAR, CONTEXT);
    }

    private BigDecimal getAnnuityFactor(BigDecimal annualInterestRate, int creditTermInMonths) {
        BigDecimal monthlyInterestRate = getMonthlyInterestRate(annualInterestRate);

        BigDecimal poweredPart = BigDecimal.ONE.add(monthlyInterestRate)
                .pow(creditTermInMonths, CONTEXT);

        BigDecimal dividend = monthlyInterestRate.multiply(poweredPart, CONTEXT);
        BigDecimal divisor = poweredPart.subtract(BigDecimal.ONE);

        return dividend.divide(divisor, CONTEXT);
    }

    public BigDecimal getAnnuityPayment(BigDecimal creditAmount, BigDecimal annualInterestRate, int creditTermInMonths) {
        BigDecimal annuityFactor = getAnnuityFactor(annualInterestRate, creditTermInMonths);

        BigDecimal result = creditAmount.multiply(annuityFactor, CONTEXT);

        return getRounded(result);
    }

    public BigDecimal getOverpayment(BigDecimal creditAmount, BigDecimal annualInterestRate, int creditTermInMonths) {
        BigDecimal annuityPayment = getAnnuityPayment(creditAmount, annualInterestRate, creditTermInMonths);
        BigDecimal term = BigDecimal.valueOf(creditTermInMonths);

        BigDecimal result = annuityPayment.multiply(term, CONTEXT)
                .subtract(creditAmount);

        return getRounded(result);
    }

    public BigDecimal getTotalCost(BigDecimal creditAmount, BigDecimal annualInterestRate, int creditTermInMonths) {
        BigDecimal totalOverpayment = getOverpayment(creditAmount, annualInterestRate, creditTermInMonths);

        BigDecimal result = creditAmount.add(totalOverpayment);

        return getRounded(result);
    }

    private BigDecimal getRounded(BigDecimal value) {
        return value.setScale(SCALE, BANKERS);
    }
}


