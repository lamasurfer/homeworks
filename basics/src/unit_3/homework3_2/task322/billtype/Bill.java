package unit_3.homework3_2.task322.billtype;

import unit_3.homework3_2.task322.TaxService;
import unit_3.homework3_2.task322.taxtype.TaxType;

public abstract class Bill {
    protected TaxType taxType;
    protected TaxService taxService;

    public Bill(TaxType taxType, TaxService taxService) {
        this.taxType = taxType;
        this.taxService = taxService;
    }

    public abstract void payTaxes();

}