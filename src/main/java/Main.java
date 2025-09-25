import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String name = input.nextLine();
        System.out.println("Please enter the number of hours you've worked:");
        double hours = input.nextDouble();
        System.out.println("Please enter your pay rate: ");
        double payRate = input.nextDouble();

        double grossPay = hours * payRate;
        System.out.printf("%s, your gross pay is: $%.2f%n", name, grossPay);
    }
}