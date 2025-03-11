package Deductions;

import Employee.Employee;

public class ProvincialIncomeTax extends Deductions{


    ProvincialIncomeTax(double grossSalary) {
        super(grossSalary);
    }

    public double calculateTax(double grossSalary) {
        double tax = 0;

        if (grossSalary > 18571 && grossSalary <= 53255) {
            // 14% rate
            tax = (grossSalary - 18571) * 0.14;
        } else if (grossSalary > 53255 && grossSalary <= 106495) {
            // 19% rate
            tax = (grossSalary - 53255) * 0.19 + (53255 - 18571) * 0.14;
        } else if (grossSalary > 106495 && grossSalary <= 129590) {
            // 24% rate
            tax = (grossSalary - 106495) * 0.24 + (106495 - 53255) * 0.19 + (53255 - 18571) * 0.14;
        } else if (grossSalary > 129590) {
            // 25.75% rate
            tax = (grossSalary - 129590) * 0.2575 + (129590 - 106495) * 0.24 + (106495 - 53255) * 0.19 + (53255 - 18571) * 0.14;
        } else {
            // If the grossSalary is less than or equal to $18,571, there is no tax
            tax = 0;
        }

        return tax;
    }
}
