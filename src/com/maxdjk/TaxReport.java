package com.maxdjk;

public class TaxReport {

    private TaxCalculator calculator;


//  -------  C o n s t r u c t o r
    public TaxReport(TaxCalculator calculator) {
       this.calculator = calculator;
    }

    public TaxReport() {
      }

//  ------- S h o w   m e t h o d s
    public void show(TaxCalculator calculator) {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

// ------- S e t t e r
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }
}
