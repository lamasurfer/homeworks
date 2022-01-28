package unit_3.homework3_2.task322.taxtype;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class IncomeTaxType extends TaxType {
    final private double TAX_RATE = 0.13;

    @Override
    public double calculateTaxFor(double amount) {
        return amount * TAX_RATE;
    }

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {
        return amount.multiply(valueOf(TAX_RATE));
    }

}
