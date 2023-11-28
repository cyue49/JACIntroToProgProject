package project2;

import java.util.Scanner;

public class PatternPrinter {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("- - - Welcome to Chen's Triangle/Diamond Printer - - -");
        System.out.println();

        int choice = 0;
        while (true){ // loop program until quit
            // asking for pattern number
            displayMenu();
            choice = kb.nextInt();
            while (!(choice >=1 && choice <=5)){ // loop until valid pattern number or quit
                System.out.println("You have entered an invalid pattern number. Please make sure that your pattern number is between 1 and 4 (inclusive), or enter 5 to quit. Please enter your choice again: ");
                choice = kb.nextInt();
            }
            if (choice == 5)    break;

            // asking for row number
            System.out.println("How many rows would you like to print? Enter a number between 1 and 10 (inclusive): ");
            int row = kb.nextInt();
            while (!(row >=1 && row<=10)){ // loop until valid row number
                System.out.println("You have entered an invalid number of rows. Please make sure that your row number is between 1 and 10 (inclusive). Please enter a row number again: ");
                row = kb.nextInt();
            }

            // printing the pattern
            switch (row){
                case 1:
                    printPattern1(row);
                    break;
                case 2:
                    printPattern2(row);
                    break;
                case 3:
                    printPattern3(row);
                    break;
                case 4:
                    printPattern4(row);
                    break;
            }
            System.out.println();
        }
    }

    /** Display the menu for the Pattern Printer */
    public static void displayMenu(){
        System.out.println("Which pattern do you want to print?");
        System.out.println(" 1) 54321   2)     1   3) 12345   4)   1  ");
        System.out.println("    5432          12       2345       123 ");
        System.out.println("    543          123        345      12345");
        System.out.println("    54          1234         45       123 ");
        System.out.println("    5          12345          5        1  ");
        System.out.println("Enter your choice (5 to Quit): ");
    }

    public static void printPattern1(int row){
        System.out.println("printing 1");
    }

    public static void printPattern2(int row){
        System.out.println("printing 2");
    }

    public static void printPattern3(int row){
        System.out.println("printing 3");
    }

    public static void printPattern4(int row){
        System.out.println("printing 4");
    }
}
