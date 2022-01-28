package unit_3.homework3_2.task322.billtype;

import unit_3.homework3_2.task322.TaxService;
import unit_3.homework3_2.task322.taxtype.TaxType;

import java.math.BigDecimal;

public class BigDecimalBill extends Bill {
    private BigDecimal amount;

    public BigDecimalBill(BigDecimal amount, TaxType taxType) {
        super(taxType, new TaxService());
        this.amount = amount;

    }


    @Override
    public void payTaxes() {
        BigDecimal taxAmount = taxType.calculateTaxFor(amount);

        taxService.payOut(taxAmount);
    }
}
