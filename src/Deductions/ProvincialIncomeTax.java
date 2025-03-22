package Deductions;

import Employee.Employee;

public class ProvincialIncomeTax extends Deductions{


    // Parameterized constructor
    ProvincialIncomeTax(double grossSalary) {
        super(grossSalary);
    }

    // Calculates this tax by a progressive tax bracket
    public double calculateTax(double grossSalary) {
        // Creates tax variable set to 0
        double tax = 0;

        // 14% rate
        if (grossSalary > 18571 && grossSalary <= 53255) {
            tax = (grossSalary - 18571) * 0.14;
        }
        // 19% rate
        else if (grossSalary > 53255 && grossSalary <= 106495) {
            tax = (grossSalary - 53255) * 0.19 + (53255 - 18571) * 0.14;
        }
        // 24% rate
        else if (grossSalary > 106495 && grossSalary <= 129590) {
            tax = (grossSalary - 106495) * 0.24 + (106495 - 53255) * 0.19 + (53255 - 18571) * 0.14;
        }
        // 25.75% rate
        else if (grossSalary > 129590) {
            tax = (grossSalary - 129590) * 0.2575 + (129590 - 106495) * 0.24 + (106495 - 53255) * 0.19 + (53255 - 18571) * 0.14;
        }
        // No tax for salary under $18571
        else {
            tax = 0;
        }

        // Returns calculated tax
        return tax;
    }
}
