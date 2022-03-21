package com.maxdjk;

import java.text.NumberFormat;
import java.util.Locale;


public class MortgageReport {

    //    ........       F I E L D S      ........
    private final MortgageCalculator calculator;
    private final NumberFormat currency;


    //    ........       C O N S T R U C T O R      ........

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance(Locale.US);
    }


    //    ........       M E T H O D S      ........

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        getNewLine();
        System.out.println("MORTGAGE");
        getUnderscoreSeparation();
        System.out.println("Monthly payments: " + mortgageFormatted);
    }

    public void printPaymentSchedule() {
        getNewLine();
        System.out.println("PAYMENT SCHEDULE");
        getUnderscoreSeparation();
        for (double balance : calculator.getRemainingBalance()) {
            System.out.println(currency.format(balance));
        }
    }


    //    ........       G E T T E R S      ........

    private void getUnderscoreSeparation() {
        System.out.println("--------");
    }

    private void getNewLine() {
        System.out.println();
    }


    //END
}
