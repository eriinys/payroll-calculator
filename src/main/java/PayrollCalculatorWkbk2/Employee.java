package PayrollCalculatorWkbk2;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee (int id, String name, double hoursWorked, double payRate) {
        this.employeeId = id;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    //region getters
    public int getId() {
        return this.employeeId;
    }

    public String getName() {
        return this.name;
    }

    public double getHoursWorked() {
        return this.hoursWorked;
    }

    public double getPayRate() {
        return this.payRate;
    }

    //endregion

    public double getGrossPay(){
        return hoursWorked * payRate;
    }
}