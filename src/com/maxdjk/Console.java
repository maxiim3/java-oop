package com.maxdjk;

import java.util.Scanner;

public class Console {

    //    ........       F I E L D S      ........

    private static final Scanner SCANNER = new Scanner(System.in);

    //    ........       M E T H O D S      ........

    public static double readNumber(String prompt){
        return SCANNER.nextDouble();
    }
    public static double readNumber(String prompt, double min, double max){
        while (true){
            System.out.print(prompt + ": ");
            double value = SCANNER.nextDouble();
            if ((value > min) && (value < max))
                return value;
            System.out.println("Please return a number between " + min + " and " + max);
        }
    }
    //END
}
