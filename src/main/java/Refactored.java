import java.util.Scanner;

public class Refactored {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        double hours;
        double payRate;

        name = readInputString("Please enter your name:");
        hours = readInputDouble("Please enter the number of hours you've worked:");
        payRate = readInputDouble("Please enter your pay rate: ");

        double grossPay;

        if (hours > 40) {
            double normPay = 40 * payRate;
            double overPay = (hours - 40) * payRate * 1.5;
            grossPay = normPay + overPay;
        } else {
            grossPay = hours * payRate;
        }
        System.out.printf("%s, your gross pay is: $%.2f%n", name, grossPay);
    }

    public static String readInputString(String askName) {
        Scanner input = new Scanner(System.in);
        System.out.println(askName);

        String answer = input.nextLine();
        return answer;
    }

    public static double readInputDouble(String ask) {
        Scanner input = new Scanner(System.in);
        System.out.println(ask);

        String answer2 = input.nextLine();
        double hours = Double.parseDouble(answer2);
        return hours;
    }

}