package Deductions;

import Employee.Employee;

public class QuebecPensionPlan extends Deductions{

    QuebecPensionPlan(double grossSalary) {
        super(grossSalary);
    }


    public double calculateTax(double grossSalary) {
        if(grossSalary >= 71300){
            return 7700.40;
        }
        else{
            return grossSalary * 0.108;
        }
    }
}
