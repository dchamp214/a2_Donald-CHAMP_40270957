package Deductions;

import Employee.Employee;

public class EmploymentInsurance extends Deductions{

    // Parameterized constructor
    EmploymentInsurance(double grossSalary) {
        super(grossSalary);
    }

    // Calculates this tax which has a maximum but is otherwise is a flat 1.64 for each $100
    public double calculateTax(double grossSalary) {
        if(grossSalary >= 65700){
            return 1077.48;
        }
        else {
            return (grossSalary / 100) * 1.64;
        }
    }
}
