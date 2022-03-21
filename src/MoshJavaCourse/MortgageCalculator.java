package MoshJavaCourse;

public class MortgageCalculator {

    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    int principal;
    float annualInterest;
    byte years;
    short numberOfPaymentsMaid;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }


    protected double calculateMortgage(int principal, float annualInterest, byte years){
        float monthlyInterest = getMonthlyInterest(annualInterest);
        short numberOfPayments = getNumberOfPayments();

        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                    / (Math.pow( 1 + monthlyInterest, numberOfPayments) - 1);
        }

    protected double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMaid){
        float monthlyInterest = getMonthlyInterest(annualInterest);
        short numberOfPayments = getNumberOfPayments();

        return principal
                    * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMaid))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        }

    public short getNumberOfPayments( ) {
        return (short) (years * MONTHS_IN_YEAR);
    }

    public float getMonthlyInterest(float annualInterest) {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }
}
