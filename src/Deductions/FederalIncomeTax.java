package Deductions;

import Employee.Employee;

public class FederalIncomeTax extends Deductions{


    FederalIncomeTax(double grossSalary) {
        super(grossSalary);
    }


    public double calculateTax(double grossSalary) {
        double tax = 0;

        if (grossSalary >= 16129 && grossSalary <= 57375) {
            // 15% rate for grossSalary between $16,129 and $57,375
            tax = (grossSalary - 16129) * 0.15;
        } else if (grossSalary > 57375 && grossSalary <= 114750) {
            // 20.5% rate for grossSalary between $57,376 and $114,750
            tax = (grossSalary - 57375) * 0.205 + (57375 - 16129) * 0.15;
        } else if (grossSalary > 114750 && grossSalary <= 177882) {
            // 26% rate for grossSalary between $114,751 and $177,882
            tax = (grossSalary - 114750) * 0.26 + (114750 - 57375) * 0.205 + (57375 - 16129) * 0.15;
        } else if (grossSalary > 177882 && grossSalary <= 253414) {
            // 29% rate for grossSalary between $177,883 and $253,414
            tax = (grossSalary - 177882) * 0.29 + (177882 - 114750) * 0.26 + (114750 - 57375) * 0.205 + (57375 - 16129) * 0.15;
        } else if (grossSalary > 253414) {
            // 33% rate for grossSalary greater than $253,414
            tax = (grossSalary - 253414) * 0.33 + (253414 - 177882) * 0.29 + (177882 - 114750) * 0.26 + (114750 - 57375) * 0.205 + (57375 - 16129) * 0.15;
        } else {
            // If grossSalary is less than $16,129, no tax
            tax = 0;
        }

        return tax;
    }
}
