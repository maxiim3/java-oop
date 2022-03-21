package com.maxdjk;


public class Main {

    public static void main(String[] args) {

        //        ----- I n s t a n c i a t i o n
        var calculator = new TaxCalculator2018(100_000);
        //        ----- C o n s t r u c t o r   I n j e c t i o n
        var report = new TaxReport(calculator);
        //        ----- S e t t e r    I n j e c t i o n
        report.setCalculator(new TaxCalculator2019());
        //        ----- M e t h o d   I n j e c t i o n
        report.show(calculator);

        report.show();
        report.show(new TaxCalculator2018(10_000));
        report.show();
        report.setCalculator(new TaxCalculator2018(50000));
        report.show();
        report.show(new TaxCalculator2019());

    }
}//END Main Class
