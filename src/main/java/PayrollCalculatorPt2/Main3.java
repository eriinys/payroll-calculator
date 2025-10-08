package PayrollCalculatorPt2;
import java.io.*;
import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            BufferedReader br = null;
            BufferedWriter bw = null;

            while (br == null) {
                System.out.println("Enter the name of the employee file to process: ");
                String processFile = scanner.nextLine();
                if (processFile.equalsIgnoreCase("employees.csv")) {
                    br = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
                } else {
                    System.err.println("Unsupported file: " + processFile + ". Please enter employees.csv.");
                }
            }

            System.out.println("Enter the name of the payroll file to create: ");
            String createFile = scanner.nextLine();
            bw = new BufferedWriter(new FileWriter("src/main/resources/" + createFile));

            boolean isJson = createFile.endsWith(".json");
            boolean commaNeeded = false;
            if (isJson){
                bw.write("[");
                bw.newLine();
            }

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                String id = parts[0];
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);
                double grossPay = hoursWorked * payRate;

                if (createFile.endsWith(".csv")) {
                    bw.write(id + "|" + name + "|" + grossPay);
                    bw.newLine();
                } else if (createFile.endsWith(".json")) {
                    if (commaNeeded) {
                        bw.write(",");
                        bw .newLine();
                    }
                    bw.write(" {\"id\": " + id + ", \"name\" : \"" + name + "\", \"grossPay\" : " + grossPay + " }");
                    commaNeeded = true;
                }
            }
            if (isJson) {
                bw.newLine();
                bw.write("]");
            }
            bw.close();
            br.close();
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Error: " +e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
