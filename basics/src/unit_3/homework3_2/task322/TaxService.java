package unit_3.homework3_2.task322;

import java.math.BigDecimal;

public class TaxService {
    public void payOut(double taxAmount) {
        System.out.format("Уплачен налог в размере %.2f%n", taxAmount);
    }

    public void payOut(BigDecimal taxAmount) {
        System.out.format("Уплачен налог в размере %.2f%n", taxAmount);
    }
}
