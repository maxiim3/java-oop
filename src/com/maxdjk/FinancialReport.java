package com.maxdjk;

public class FinancialReport {


    FinancialOrganization finance ;

    //  ---------------------------------------------------------------
    //                         P R I N T  O U T  R E P O R T
    //  ---------------------------------------------------------------

    public static void reportFinanceOrganization(FinancialOrganization finance){
        System.out.println("\t------ S U M  U P ------");
        System.out.println("In " + finance.getMonth() + ", ");
        System.out.println("\tYou earned: " + finance.calculateTotalIncome() + "€");
        System.out.println("\tYou will spend: " + finance.calculateTotalSpending() + "€");
        System.out.println("\tYou've got: " + finance.calculateMoneyLeft() + "€ left");

        System.out.println("\n\t------ M O N E Y  T R A N S F E R ------");
        System.out.println("- From ING to N26: " + finance.transferToN26() + "€");
        System.out.println("- From ING to EKO: " + finance.transferToEKO() + "€");

        System.out.println("\n\t------ I N V E S T ------");
        System.out.println("- N26 to Binance: BTC/BUSD, buy " + finance.calculateAmountToInvestInBTC() + "€");
        System.out.println("- N26 to Binance: ETH/BUSD, buy " + finance.calculateAmountToInvestInETH() + "€");
        System.out.println("- N26 to Binance: BNB/BUSD, buy " + finance.calculateAmountToInvestInBNB() + "€");
        System.out.println("- Save to Invest in GOLD: " + finance.calculateAmountToInvestInGold() + "€");

        System.out.println("\n\t------ S A V I N G S ------");
        System.out.println("- Transfer from EKO to LDDS : " + finance.calculateAmountToTransferToLDDS() + "€");
        System.out.println("- Transfer from EKO to KIDS' Livret : " + finance.calculateAmountToTransferToKids() + "€");

        System.out.println("\n\t------ G I F T S ------");
        System.out.println("- Saved for Gifts in N26: " + finance.calculateTotalAmountForGifts() + "€");

        System.out.println("\n\t=================\n");


    }
}
