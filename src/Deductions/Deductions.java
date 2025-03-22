package Deductions;


import Employee.Employee;

// Class is abstract as it has an abstract calculateTax method
public abstract class Deductions {

    // Creates associated variable
    private double grossSalary;

    // Parameterized constructor
    public Deductions(double grossSalary){
        this.grossSalary = grossSalary;
    }

    // Abstract method inherited by specific tax classes
    public abstract double calculateTax(double grossSalary);

    // Method used to call all child tax classes and calculates totalDeductions
    public double totalDeductions(double grossSalary){
        // Creates object of each tax
        ProvincialIncomeTax provincialIncomeTax = new ProvincialIncomeTax(grossSalary);
        EmploymentInsurance employmentInsurance = new EmploymentInsurance(grossSalary);
        FederalIncomeTax federalIncomeTax = new FederalIncomeTax(grossSalary);
        QuebecPensionPlan quebecPensionPlan = new QuebecPensionPlan(grossSalary);
        QuebecParentalInsurancePlan quebecParentalInsurancePlan = new QuebecParentalInsurancePlan(grossSalary);

        // Returns the sum of each tax using the employees grossSalary
        return provincialIncomeTax.calculateTax(grossSalary) + employmentInsurance.calculateTax(grossSalary)
                + federalIncomeTax.calculateTax(grossSalary) + quebecPensionPlan.calculateTax(grossSalary)
                + quebecParentalInsurancePlan.calculateTax(grossSalary);
    }


}
