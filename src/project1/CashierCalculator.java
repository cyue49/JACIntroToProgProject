package project1;

import java.util.Scanner;

public class CashierCalculator {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int invalidInputs = 0; // keeps track of the total number of invalid inputs

        // getting the number of items
        int itemNum = 0; // number of items bought
        while (!(itemNum >=1 && itemNum<=10)){
            invalidInputs++; // add one invalid input count for each loop
            try{
                System.out.printf("Please enter the number of items bought [%d...%d]: ", 1, 10);
                itemNum = kb.nextInt();
            }catch (Exception e){
                kb.nextLine();
            }
        }
        invalidInputs--; // remove count for the correct input

        // getting the prices of each item
        double[] itemPrices = new double[itemNum]; // price of each item bought
        for (int i=0; i<itemNum; i++){
            double itmPrice = 0; // price of current item
            while (!(itmPrice>=1 && itmPrice<=1000)){
                invalidInputs ++;
                try{
                    System.out.printf("Please enter the price of item %d [%d...%d]: ", i+1, 1, 1000);
                    itmPrice = kb.nextDouble();
                }catch (Exception e){
                    kb.nextLine();
                }
            }
            invalidInputs --;
            itemPrices[i] = itmPrice;
        }

        // getting the GST rate
        double gstRate = -1;
        while (!(gstRate>=0 && gstRate<=14)){
            invalidInputs++;
            try{
                System.out.printf("Please enter the tax rate of GST in %% [%d...%d]", 0, 14);
                gstRate = kb.nextDouble();
            }catch (Exception e){
                kb.nextLine();
            }
        }
        invalidInputs--;
        gstRate /= 100; // get percentage of gstRate

        // getting the QST rate
        double qstRate = -1;
        while (!(qstRate>=0 && qstRate<=17)){
            invalidInputs++;
            try{
                System.out.printf("Please enter the tax rate of QST in %% [%d...%d]", 0, 17);
                qstRate = kb.nextDouble();
            }catch (Exception e){
                kb.nextLine();
            }
        }
        invalidInputs--;
        qstRate /= 100; // get percentage of qstRate

        // calculations
        double subtotal = calculateSubtotal(itemPrices);
        double gst = subtotal * gstRate;
        double qst = (subtotal + gst) * qstRate;
        double total = subtotal + gst + qst;

        // print results to user
        System.out.printf("You have entered %d invalid inputs.\n", invalidInputs);
        System.out.printf("%10s: $ %10.2f\n", "Sub Total", subtotal);
        System.out.printf("%10s: $ %10.2f\n", "GST", gst);
        System.out.printf("%10s: $ %10.2f\n", "QST", qst);
        System.out.printf("%10s: $ %10.2f\n", "Total", total);
    }

    /** Given a doubles array of the prices of all items,
     *  calculates the subtotal before taxes and returns the subtotal as a double*/
    public static double calculateSubtotal(double[] itmPrices){
        double subtotal = 0;
        for (double price: itmPrices){
            subtotal+=price;
        }
        return subtotal;
    }
}
