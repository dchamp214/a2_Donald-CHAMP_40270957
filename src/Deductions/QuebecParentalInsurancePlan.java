package Deductions;

import Employee.Employee;

public class QuebecParentalInsurancePlan extends Deductions{

    QuebecParentalInsurancePlan(double grossSalary) {
        super(grossSalary);
    }

    public double calculateTax(double grossSalary) {
        if(grossSalary >= 98000){
            return 484.12;
        }
        else{
            return grossSalary *  0.00494;
        }
    }
}
