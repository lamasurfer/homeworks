package org.example.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CreditCalcTest {

    // https://www.banki.ru/products/credits/sberbank/calculator/?amount=100000&credit_id=1&currency=RUB&period=365

    private final CreditCalc creditCalc = new CreditCalc();
    private final BigDecimal creditAmount = new BigDecimal(100_000);
    private final BigDecimal annualInterestRate = new BigDecimal("12.9");
    private final int creditLengthInMonths = 12;


    @Test
    void test_getAnnuityPayment_expectedBehaviour() {
        BigDecimal expected = new BigDecimal("8927");
        BigDecimal actual = creditCalc.getAnnuityPayment(creditAmount, annualInterestRate, creditLengthInMonths);
        Assertions.assertEquals(expected.compareTo(actual), 0);
    }

    @Test
    void test_getOverpayment_expectedBehaviour() {
        BigDecimal expected = new BigDecimal("7124");
        BigDecimal actual = creditCalc.getOverpayment(creditAmount, annualInterestRate, creditLengthInMonths);
        Assertions.assertEquals(expected.compareTo(actual), 0);
    }

    @Test
    void test_getTotalCost_expectedBehaviour() {
        BigDecimal expected = new BigDecimal("107124");
        BigDecimal actual = creditCalc.getTotalCost(creditAmount, annualInterestRate, creditLengthInMonths);
        Assertions.assertEquals(expected.compareTo(actual), 0);
    }
}

//    3 tests completed, 3 failed
//    FAILURE: Build failed with an exception.
//    * What went wrong:
//    Execution failed for task ':test'.