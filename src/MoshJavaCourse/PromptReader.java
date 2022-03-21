package MoshJavaCourse;

import java.util.Scanner;

public class PromptReader {
    public static double readNumber(String prompt, double min, double max){
        Scanner scannerInput = new Scanner(System.in);
        while (true){
            System.out.print(prompt + ": ");
            double value = scannerInput.nextDouble();
            if ((value > min) && (value < max))
                return value;
            System.out.println("Please return a number between " + min + " and " + max);
        }
    }
}
