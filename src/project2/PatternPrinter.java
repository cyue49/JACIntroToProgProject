package project2;

import java.util.Scanner;

public class PatternPrinter {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("- - - Welcome to Chen's Triangle/Diamond Printer - - -");
        System.out.println();

        int choice = 0;
        int row = 0;
        while (true){ // loop program until user wants to quit
            // asking for pattern number
            displayMenu();
            while (true){
                try{
                    choice = kb.nextInt();
                    while (!(choice >=1 && choice <=5)){ // keep asking until a valid pattern number is entered or the user wants to quit
                        System.out.println("You have entered an invalid pattern number. Please make sure that your pattern number is between 1 and 4 (inclusive), or enter 5 to quit. Please enter your choice again: ");
                        choice = kb.nextInt();
                    }
                    break;
                }catch (Exception e){ // invalid user input
                    kb.nextLine();
                    System.out.println("You have entered an invalid input. Please make sure that your pattern number is an integer between 1 and 4 (inclusive), or enter 5 to quit. Please enter your choice again: ");
                }
            }

            // if user's choice is 5, display closing message and quit
            if (choice == 5){
                System.out.println("Thank you for using Chen's Triangle/Diamond Printer! See you next time!");
                break;
            }

            // asking for row number
            System.out.println("How many rows would you like to print? Enter a number between 1 and 10 (inclusive): ");
            while(true){
                try{
                    row = kb.nextInt();
                    while (!(row >=1 && row<=9)){ // keep asking until a valid row number is entered
                        System.out.println("You have entered an invalid number of rows. Please make sure that your row number is between 1 and 9 (inclusive). Please enter a row number again: ");
                        row = kb.nextInt();
                    }
                    break;
                }catch (Exception e){
                    kb.nextLine();
                    System.out.println("You have entered an invalid input. Please make sure that your row number is an integer between 1 and 9 (inclusive). Please enter a row number again: ");
                }
            }

            // printing the pattern
            switch (choice){
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

    /** Display the menu for the Pattern Printer, and ask the user to make a choice. */
    public static void displayMenu(){
        System.out.println("Which pattern do you want to print?");
        System.out.println(" 1) 54321   2)     1   3) 12345   4)   1  ");
        System.out.println("    5432          12       2345       123 ");
        System.out.println("    543          123        345      12345");
        System.out.println("    54          1234         45       123 ");
        System.out.println("    5          12345          5        1  ");
        System.out.println("Enter your choice (5 to Quit): ");
    }

    /** Print pattern type 1 (forming a triangle), with numbers in descending order and a decreasing number of elements for each row */
    public static void printPattern1(int row){
        for (int i=row; i>0; i--){
            for (int j=0; j<i; j++){
                System.out.print(i-j+(row-i));
            }
            System.out.println();
        }
    }

    /** Print pattern type 2 (forming a triangle), with numbers in ascending order and an increasing number of elements for each row */
    public static void printPattern2(int row){
        for (int i=1; i<row+1; i++){
            for (int j=row+1; j>i; j--){ // print the leading spaces
                System.out.print(" ");
            }
            for (int j=0; j<i; j++){ // print the numbers
                System.out.print(j+1);
            }
            System.out.println();
        }
    }

    /** Print pattern type 3 (forming a triangle), with numbers in ascending order and a decreasing number of elements for each row */
    public static void printPattern3(int row){
        for (int i=1; i<row+1; i++){
            for (int j=1; j<i; j++){ // print the leading spaces
                System.out.print(" ");
            }
            for (int j=row; j>i-1; j--){ // print the numbers
                System.out.print(i+row-j);
            }
            System.out.println();
        }
    }

    /** Print pattern type 3 (forming a diamond), with numbers in ascending order, and an increasing number of elements for each row until the middle point, then a decreasing number of elements for each row until the end */
    public static void printPattern4(int row){
        // printing the upper part of the diamond, which is the same for the case of an even or odd number of rows
        for (int i=1; i<row+1; i++){
            if (i%2 == 0)   continue; // skip each row that ends in an even number
            for (int j=row; j>i; j-=2){ // print the leading spaces
                System.out.print(" ");
            }
            for (int j=0; j<i; j++){ // print the numbers
                System.out.print(j+1);
            }
            System.out.println();
        }
        // printing the lower part of the diamond, which varies depending on whether the number of rows is even or old
        if (row%2 == 0){ // even number of rows
            for (int i=row; i>0; i--){ // the last row of the upper part is duplicated, so starts at row
                if (i%2 == 0)   continue; // skip each row that ends in an even number
                for (int j=row; j>i; j-=2){ // print the leading spaces
                    System.out.print(" ");
                }
                for (int j=0; j<i; j++){ // print the numbers
                    System.out.print(j+1);
                }
                System.out.println();
            }
        }else{ // odd number of rows
            for (int i=row-2; i>0; i--){ // the last row of the upper part is not duplicated, so starts at row-2
                if (i%2 == 0)   continue; // skip each row that ends in an even number
                for (int j=row; j>i; j-=2){ // print the leading spaces
                    System.out.print(" ");
                }
                for (int j=0; j<i; j++){ // print the numbers
                    System.out.print(j+1);
                }
                System.out.println();
            }
        }
    }
}
