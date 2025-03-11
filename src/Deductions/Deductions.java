package Deductions;


import Employee.Employee;

public abstract class Deductions {

    private double grossSalary;

    public Deductions(double grossSalary){
        this.grossSalary = grossSalary;
    }

    public abstract double calculateTax(double grossSalary);

    public double totalDeductions(double grossSalary){
        ProvincialIncomeTax provincialIncomeTax = new ProvincialIncomeTax(grossSalary);
        EmploymentInsurance employmentInsurance = new EmploymentInsurance(grossSalary);
        FederalIncomeTax federalIncomeTax = new FederalIncomeTax(grossSalary);
        QuebecPensionPlan quebecPensionPlan = new QuebecPensionPlan(grossSalary);
        QuebecParentalInsurancePlan quebecParentalInsurancePlan = new QuebecParentalInsurancePlan(grossSalary);

        return provincialIncomeTax.calculateTax(grossSalary) + employmentInsurance.calculateTax(grossSalary)
                + federalIncomeTax.calculateTax(grossSalary) + quebecPensionPlan.calculateTax(grossSalary)
                + quebecParentalInsurancePlan.calculateTax(grossSalary);
    }


}
