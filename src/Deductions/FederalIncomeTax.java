package Deductions;

import Employee.Employee;

public class FederalIncomeTax extends Deductions{


    // Parameterized constructor
    FederalIncomeTax(double grossSalary) {
        super(grossSalary);
    }

    // Calculates this tax by a progressive tax bracket
    public double calculateTax(double grossSalary) {
        double tax = 0;

        // 15% rate for grossSalary between $16129 and $57375
        if (grossSalary >= 16129 && grossSalary <= 57375) {
            tax = (grossSalary - 16129) * 0.15;
        }
        // 20.5% rate for grossSalary between $57376 and $114750
        else if (grossSalary > 57375 && grossSalary <= 114750) {
            tax = (grossSalary - 57375) * 0.205 + (57375 - 16129) * 0.15;
        }
        // 26% rate for grossSalary between $114,751 and $177,882
        else if (grossSalary > 114750 && grossSalary <= 177882) {
            tax = (grossSalary - 114750) * 0.26 + (114750 - 57375) * 0.205 + (57375 - 16129) * 0.15;
        }

        // 29% rate for grossSalary between $177,883 and $253,414
        else if (grossSalary > 177882 && grossSalary <= 253414) {
            tax = (grossSalary - 177882) * 0.29 + (177882 - 114750) * 0.26 + (114750 - 57375) * 0.205 + (57375 - 16129) * 0.15;
        }

        // 33% rate for grossSalary greater than $253,414
        else if (grossSalary > 253414) {
            tax = (grossSalary - 253414) * 0.33 + (253414 - 177882) * 0.29 + (177882 - 114750) * 0.26 + (114750 - 57375) * 0.205 + (57375 - 16129) * 0.15;
        }
        else {
            tax = 0;
        }

        // Returns tax calculated
        return tax;
    }
}
