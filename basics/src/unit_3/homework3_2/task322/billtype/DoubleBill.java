package unit_3.homework3_2.task322.billtype;

import unit_3.homework3_2.task322.TaxService;
import unit_3.homework3_2.task322.taxtype.TaxType;

public class DoubleBill extends Bill {
    private double amount;

    public DoubleBill(double amount, TaxType taxType) {
        super(taxType, new TaxService());
        this.amount = amount;

    }

    @Override
    public void payTaxes() {
        double taxAmount = taxType.calculateTaxFor(amount);

        taxService.payOut(taxAmount);
    }
}
