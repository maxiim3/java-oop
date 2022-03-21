package MoshJavaCourse;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    MortgageCalculator calculate;


    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 0; month <= calculate.getNumberOfPayments(); month++ ) {
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(calculate)) ;
        }
    }

    public void printMortgage() {
        String mortgageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(calculate);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly payments: " + mortgageFormatted);
    }
}
