package Deductions;

import Employee.Employee;

public class QuebecPensionPlan extends Deductions{

    // Parameterized constructor
    QuebecPensionPlan(double grossSalary) {
        super(grossSalary);
    }


    // Calculates tax with a maximum and an otherwise flat 10.8%
    public double calculateTax(double grossSalary) {
        if(grossSalary >= 71300){
            return 7700.40;
        }
        else{
            return grossSalary * 0.108;
        }
    }
}
