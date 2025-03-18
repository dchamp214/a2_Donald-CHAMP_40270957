package Employee;

import Deductions.Deductions;

public class Employee {
    private long employeeNumber;
    private String firstName;
    private String lastName;
    private double hoursWorked;
    private double hourlyWage;
    private double calculatedGrossSalary;
    private double employeeDeductions;

    Employee(){
        this.employeeNumber = 0;
        this.firstName = null;
        this.lastName = null;
        this.hoursWorked = 0;
        this.hourlyWage = 0;
        this.calculatedGrossSalary = 0;
    }

    public Employee(long employeeNumber, String firstName, String lastName, double hoursWorked, double hourlyWage){
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
        this.calculatedGrossSalary = hourlyWage * hoursWorked * 52;
    }

    public Employee(Employee other) {
        this.employeeNumber = other.employeeNumber;
        this.firstName = other.firstName;
        this.lastName = other.lastName;
        this.hoursWorked = other.hoursWorked;
        this.hourlyWage = other.hourlyWage;
        this.calculatedGrossSalary = other.calculatedGrossSalary;
    }

    public double getCalculatedGrossSalary() {
        return calculatedGrossSalary;
    }

    public void getDeductions(){
        Deductions deductions = new Deductions(this.calculatedGrossSalary) {
            @Override
            public double calculateTax(double grossSalary) {
                return 0;
            }
        };

        this.employeeDeductions = deductions.totalDeductions(calculatedGrossSalary);
    }

    @Override
    public String toString() {
        // Calculate net pay as a double value
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
