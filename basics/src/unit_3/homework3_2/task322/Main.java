package unit_3.homework3_2.task322;

import unit_3.homework3_2.task322.billtype.BigDecimalBill;
import unit_3.homework3_2.task322.billtype.Bill;
import unit_3.homework3_2.task322.billtype.DoubleBill;
import unit_3.homework3_2.task322.taxtype.IncomeTaxType;
import unit_3.homework3_2.task322.taxtype.ProgressiveTaxType;
import unit_3.homework3_2.task322.taxtype.VATaxType;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Bill[] payments = new Bill[]{
                new BigDecimalBill(new BigDecimal("1000000.4555"), new IncomeTaxType()),
                new DoubleBill(1_000_000.00, new VATaxType()),
                new BigDecimalBill(new BigDecimal(1_000_000), new ProgressiveTaxType()),
                new BigDecimalBill(new BigDecimal("99000"), new ProgressiveTaxType()),
                new DoubleBill(99_000.00, new ProgressiveTaxType()),
                new DoubleBill(100_000.00, new ProgressiveTaxType())
        };

        for (Bill bill : payments) {
            bill.payTaxes();
        }
    }
}
