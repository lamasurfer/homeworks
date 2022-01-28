package unit_3.homework3_2.task322.taxtype;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class ProgressiveTaxType extends TaxType {

    final private double LOW_TAX_RATE = 0.10;
    final private double HIGH_TAX_RATE = 0.15;
    final private double TAX_BORDER = 100_000.00;

    @Override
    public double calculateTaxFor(double amount) {

        if (amount < TAX_BORDER) {
            return amount * LOW_TAX_RATE;
        } else {
            return amount * HIGH_TAX_RATE;
        }

    }

    @Override
    public BigDecimal calculateTaxFor(BigDecimal amount) {

        if (valueOf(TAX_BORDER).compareTo(amount) == 1) {
            return amount.multiply(valueOf(LOW_TAX_RATE));
        }
        return amount.multiply(valueOf(HIGH_TAX_RATE));
    }
}
