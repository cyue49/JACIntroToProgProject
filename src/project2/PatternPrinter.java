package project2;

import java.util.Scanner;

public class PatternPrinter {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int choice = 0;
        while (choice != 5){ // loop program until quit
            displayMenu();
            choice = kb.nextInt();
            while (!(choice >=1 && choice <=5)){ // loop until valid pattern number or quit
                System.out.println("You have entered an invalid pattern number. Please make sure that your pattern number is between 1 and 4 (inclusive), or enter 5 to quit. ");
                choice = kb.nextInt();
            }
        }
    }

    /** Display the menu for the Pattern Printer */
    public static void displayMenu(){
        System.out.println("- - - Welcome to Chen's Triangle/Diamond Printer - - -");
        System.out.println();
        System.out.println("Which pattern do you want to print?");
        System.out.println(" 1) 54321   2)     1   3) 12345        1  ");
        System.out.println("    5432          12       2345       123 ");
        System.out.println("    543          123        345      12345");
        System.out.println("    54          1234         45       123 ");
        System.out.println("    5          12345          5        1  ");
        System.out.println("Enter your choice (5 to Quit): ");
    }
}
