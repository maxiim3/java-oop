package com.maxdjk;

import java.util.Scanner;

public class FinancialOrganization {

    //    ........       F I E L D S      ........


    private int incomeSalary;
    private int incomeSocialHelps;
    private String month = "";

    final private int EVERYDAY_NEEDS = 550;
    final private int RENT = 720;
    final private int ENERGY = 100;
    final private int TELECOM_SUBSCRIPTIONS = 36;
    final private int INSURANCE = 37;
    final private int HEALTH_CARE = 44;
    final private int INTERNET_SUBSCRIPTION = 62;

    final private float FUNCTION_HARD_FACTOR = 1/5F;
    final private float FUNCTION_SOFT_FACTOR = 1/10F;

    final private int PERCENT = 100;

    //  ---------------------------------------------------------------
    //                     C O N S T R U C T O R
    //  ---------------------------------------------------------------

    //We directly pass parameters in the new Objects
    public FinancialOrganization(String text, int incomeSalary, int incomeSocialHelps){
        setMonth(text);
        setIncomeSalary(incomeSalary);
        setIncomeSocialHelps(incomeSocialHelps);
    }

    //We have created new variables from Console class, and pass them as parameters,
    // or directly pass them in the declaration
    // We will be asked for the name of the month
    public FinancialOrganization(int incomeSalary, int incomeSocialHelps){
        Scanner scanInput = new Scanner(System.in);

        System.out.print("Which MONTH: ");
        String text = scanInput.nextLine();
        setMonth(text);

        setIncomeSalary(incomeSalary);
        setIncomeSocialHelps(incomeSocialHelps);
    }

    //We don't declare parameters, they will be asked
    public FinancialOrganization(){
        Scanner scanInput = new Scanner(System.in);

        System.out.print("Which MONTH: ");
        String text = scanInput.nextLine();
        setMonth(text);

        System.out.print("Salary: ");
        incomeSalary = scanInput.nextInt();
        setIncomeSalary(incomeSalary);

        System.out.print("Social Helps: ");
        incomeSocialHelps = scanInput.nextInt();
        setIncomeSocialHelps(incomeSocialHelps);
    }


    //  ---------------------------------------------------------------
    //                         S P E N D I N G S
    //  ---------------------------------------------------------------

     protected int calculateTotalSpending() {
        return  EVERYDAY_NEEDS + HEALTH_CARE + RENT + ENERGY + TELECOM_SUBSCRIPTIONS + INSURANCE + INTERNET_SUBSCRIPTION;
    }


    //  ---------------------------------------------------------------
    //   C A L C U L A T E   A M O U N T   O F   M O N E Y   L E F T
    //  ---------------------------------------------------------------

    protected double calculateMoneyLeft(){
        return calculateTotalIncome() - calculateTotalSpending();
    }


    //  ---------------------------------------------------------------
    //                  T R A N S F E R  S A V I N G S
    //  ---------------------------------------------------------------

    //    if   0 <  balance < 300         Savings y = x + 100
    //    if 300 <  balance < 500         Savings y = -1/5x + 160
    //    if 500 <  balance < 600         Savings y = -1/10x + 110
    //    if 600 <  balance               Savings y = x + 50

    //    ........       C A L C U L A T E  F O R M U L A      ........

    private double calculateSavingRate(){
        if (calculateMoneyLeft() <= 300)
            return 100F / PERCENT;
        else if ((calculateMoneyLeft() > 300) && (calculateMoneyLeft() <= 500))
            return (-(FUNCTION_HARD_FACTOR) * calculateMoneyLeft() + 160) / PERCENT;
        else if ((calculateMoneyLeft() > 500) && (calculateMoneyLeft() <= 600))
            return (-(FUNCTION_SOFT_FACTOR) * calculateMoneyLeft() + 110) / PERCENT;
        else
            return 50F / PERCENT;
    }

    //    ........       C A L C U L A T E  V A R I A B L E S      ........

    private double calculateTotalAmountForSaving(){
        return calculateMoneyLeft() * calculateSavingRate();
    }

    protected double calculateAmountToTransferToLDDS(){
        return calculateTotalAmountForSaving() * 0.83;
    }

    protected double calculateAmountToTransferToKids(){
        return calculateTotalAmountForSaving() * 0.17;
    }


    //  ---------------------------------------------------------------
    //                     T R A N S F E R  I N V E S T
    //  ---------------------------------------------------------------

    //    if   0 <  balance < 300         Invest y = 0
    //    if 300 <  balance < 500         Invest y = 1/5x - 60 - 5       => 5% for Gifts
    //    if 500 <  balance < 600         Invest y = 1/10x - 10 - 10    ==> - 10% for Gifts
    //    if 600 <  balance               Invest y = 50 - 10            ==> 10% for Gifts

    //    ........       C A L C U L A T E  F O R M U L A      ........

    private double calculateInvestRate(){
        if (calculateMoneyLeft() <= 300)
            return 0;
        else if ((calculateMoneyLeft() > 300) && (calculateMoneyLeft() <= 500))
            return ((FUNCTION_HARD_FACTOR) * calculateMoneyLeft() - 65) / PERCENT;
        else if ((calculateMoneyLeft() > 500) && (calculateMoneyLeft() <= 600))
            return ((FUNCTION_SOFT_FACTOR) * calculateMoneyLeft() - 20) / PERCENT;
        else
            return 45F / PERCENT;
    }

    //    ........       C A L C U L A T E  V A R I A B L E S      ........

    private double calculateTotalAmountForInvesting(){
        return calculateMoneyLeft() * calculateInvestRate();
    }

    protected double calculateAmountToInvestInBTC(){
        return calculateTotalAmountForInvesting() * 0.27;
    }

    protected double calculateAmountToInvestInETH(){
        return calculateTotalAmountForInvesting() * 0.26;
        }

    protected double calculateAmountToInvestInBNB(){
        return calculateTotalAmountForInvesting() * 0.25;
        }

    protected double calculateAmountToInvestInGold() {
        return calculateTotalAmountForInvesting() * 0.22;
    }


    //  ---------------------------------------------------------------
    //                         T R A N S F E R  G I F T S
    //  ---------------------------------------------------------------

    //    % Gifts == 100% - % Saves - % Invest

    private double calculateGiftRate(){ return 1 - calculateInvestRate() - calculateSavingRate();}

    protected double calculateTotalAmountForGifts(){ return calculateMoneyLeft() * calculateGiftRate();}


    //  ---------------------------------------------------------------
    //                  T R A N S F E R  B A N K  A C C O U N T
    //  ---------------------------------------------------------------

    protected double transferToN26(){
        final byte BANK_N26 = 16;
        return EVERYDAY_NEEDS + BANK_N26 + INTERNET_SUBSCRIPTION + calculateTotalAmountForInvesting() + calculateTotalAmountForGifts();
    }

    protected double transferToEKO(){
        final  byte EKO = 2;
        return ENERGY + calculateTotalAmountForSaving() + EKO + TELECOM_SUBSCRIPTIONS + INSURANCE + HEALTH_CARE;
    }

    //  ---------------------------------------------------------------
    //                          M O N T H S
    //  ---------------------------------------------------------------

    private void setMonth(String text) {
        this.month = text;
    }

    protected String getMonth() {
        return month;
    }


    //  ---------------------------------------------------------------
    //                          I N C O M E S
    //  ---------------------------------------------------------------

    //    ........       S E T T E R  I N C O M E S      ........

    private void setIncomeSalary(int incomeSalary) {
        if (incomeSalary < 0)
            throw new IllegalArgumentException("Salary must be a positive number");
        this.incomeSalary = incomeSalary;
    }

    private void setIncomeSocialHelps(int incomeSocialHelps) {
        if (incomeSocialHelps < 0)
            throw new IllegalArgumentException("value must be a positive number");
        this.incomeSocialHelps = incomeSocialHelps;
    }

    //    ........       G E T T E R   I N C O M E S      ........

    private int getIncomeSalary() {
        return incomeSalary;
    }

    private int getIncomeSocialHelps() {
        return incomeSocialHelps;
    }

    protected int calculateTotalIncome(){
        return getIncomeSalary() + getIncomeSocialHelps();
    }

}
    //    ........       E N D  O F   P R O G R A M      ........
