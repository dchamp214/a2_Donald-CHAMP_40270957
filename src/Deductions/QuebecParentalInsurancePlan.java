package Deductions;

import Employee.Employee;

public class QuebecParentalInsurancePlan extends Deductions{

    // Parameterized constructor
    QuebecParentalInsurancePlan(double grossSalary) {
        super(grossSalary);
    }

    // Calculates tax, has a maximum based on salary but otherwise a flat 0.494%
    public double calculateTax(double grossSalary) {
        if(grossSalary >= 98000){
            return 484.12;
        }
        else{
            return grossSalary *  0.00494;
        }
    }
}
