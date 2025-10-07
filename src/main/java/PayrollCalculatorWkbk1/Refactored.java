package PayrollCalculatorWkbk1;

import java.util.Scanner;

public class Refactored {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = readInputString(input,"Please enter your name:");
        double hours = readInputDouble(input,"Please enter the number of hours you've worked:");
        double payRate = readInputDouble(input,"Please enter your pay rate: ");

        double grossPay = calculateGrossPay(hours, payRate);

        System.out.printf("%s, your gross pay is: $%.2f%n", name, grossPay);

    }

    public static String readInputString(Scanner in, String ask) {
        System.out.println(ask);
        return in.nextLine();
    }

    public static double readInputDouble(Scanner in, String ask) {
        System.out.println(ask);
        double value = in.nextDouble();
        in.nextLine();
        return value;
    }
    public static double calculateGrossPay(double hours, double payRate) {
        if (hours > 40) {
            double normPay = 40 * payRate;
            double overPay = (hours - 40) * payRate * 1.5;
            return normPay + overPay;
        } else {
            return hours * payRate;
        }
    }

}