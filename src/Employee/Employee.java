package Employee;

import Deductions.Deductions;

public class Employee {

    // Create employee variables
    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double hourlyWage;
    private double calculatedGrossSalary;
    private double employeeDeductions;

    // Default constructor sets all values to null or 0
    Employee(){
        this.employeeNumber = 0;
        this.firstName = null;
        this.lastName = null;
        this.hoursWorked = 0;
        this.hourlyWage = 0;
        this.calculatedGrossSalary = 0;
    }

    // Parameterized constructor sets all values to those provided
    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage){
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        this.calculatedGrossSalary = hourlyWage * hoursWorked * 52;
    }

    // Copy constructor sets this. variables to same as copied object
    public Employee(Employee other) {
        this.employeeNumber = other.employeeNumber;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.hoursWorked = other.hoursWorked;
        this.hourlyWage = other.hourlyWage;
        this.calculatedGrossSalary = other.calculatedGrossSalary;
    }

    // Accessor method for gross salary
    public double getCalculatedGrossSalary() {
        return calculatedGrossSalary;
    }

    // Method for calculating employess taxes
    public void getDeductions(){

        // Creates deduction object for this employee
        Deductions deductions = new Deductions(this.calculatedGrossSalary) {
            @Override
            public double calculateTax(double grossSalary) {
                return 0;
            }
        };

        // Calls method that calculates total tax and sets it to this employees deductions variable
        this.employeeDeductions = deductions.totalDeductions(calculatedGrossSalary);
    }

    @Override
    public String toString() {
        // Calculate net pay
        double roundedNetPay = calculatedGrossSalary - employeeDeductions;

        // Return formatted string
        return String.format("%-15d %-15s %-15s %-15.2f %-15.2f %-15.2f",
                employeeNumber,
                firstName.toUpperCase(),
                lastName.toUpperCase(),
                calculatedGrossSalary,  // Assuming this is a double value
                employeeDeductions,  // Assuming this is a double value
                roundedNetPay);  // Now roundedNetPay is a double and can be formatted correctly
    }

}
