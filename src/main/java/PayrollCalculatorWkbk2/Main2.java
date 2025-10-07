package PayrollCalculatorWkbk2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("src/main/resources/employees.csv");
            BufferedReader br = new BufferedReader((fileReader));

            br.readLine();

            String input;
            while((input = br.readLine()) != null) {
                String[] parts = input.split("\\|");
                String name = parts[1];

                int id = Integer.parseInt(parts[0]);
                System.out.println("\nID#: " + id);
                System.out.println("Name: " + name);
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                System.out.println("Hours worked: " + hoursWorked);
                System.out.println("Pay rate: " + payRate);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                System.out.printf("Employee %s's gross pay is: $%.2f\n", employee.getName(), employee.getGrossPay());

            }
            br.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }


    }
}
