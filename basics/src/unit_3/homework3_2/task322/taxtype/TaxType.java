package unit_3.homework3_2.task322.taxtype;

import java.math.BigDecimal;

public abstract class TaxType {

    public abstract double calculateTaxFor(double amount);

    public abstract BigDecimal calculateTaxFor(BigDecimal amount);
}
