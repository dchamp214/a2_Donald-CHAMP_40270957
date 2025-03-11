package Deductions;

import Employee.Employee;

public class EmploymentInsurance extends Deductions{


    EmploymentInsurance(double grossSalary) {
        super(grossSalary);
    }

    public double calculateTax(double grossSalary) {
        if(grossSalary >= 65700){
            return 1077.48;
        }
        else {
            return (grossSalary / 100) * 1.64;
        }
    }
}
