package MoshJavaCourse;


public class Main {

    public static void main(String[] args) {

            int principal = (int) PromptReader.readNumber("Principal", 1000, 1000_000);
            float annualInterest = (float) PromptReader.readNumber("Annual Interest Rate", 0, 30);
            byte years = (byte) PromptReader.readNumber("Period (Years)", 1, 30);

            new MortgageReport().printMortgage();
            new MortgageReport().printPaymentSchedule();
        }

}//END Main Class


