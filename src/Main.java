import Employee.Employee;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner reader = null;

        long employeeNumber = 0;
        String firstName = null;
        String lastName = null;
        double hoursWorked = 0;
        double hourlyWage = 0;

        Employee[] employees = new Employee[0];
        Employee heldEmployee;

        String errorHold = null;
        String[] payrolErrors = new String[0];

        boolean errorFound = false;

        try{
            System.out.print("> Opening Payroll File...\n\n");
            reader = new Scanner(new FileInputStream("payroll.txt"));

            System.out.print("> Reading file payroll...\n\n");
            while(reader.hasNextLine()){
                try {

                    String heldString = reader.nextLine();
                    errorHold = heldString;
                    Scanner heldScan = new Scanner(heldString);

                    employeeNumber = heldScan.nextLong();
                    firstName = heldScan.next();
                    lastName = heldScan.next();
                    hoursWorked = heldScan.nextDouble();
                    hourlyWage = heldScan.nextDouble();

                    if (hourlyWage < 15.75){
                        throw new MinimumWageException();
                    }

                    heldEmployee = new Employee(employeeNumber, firstName, lastName, hoursWorked, hourlyWage);

                    Employee[] tempEmployees = new Employee[employees.length + 1];

                    for(int i = 0; i < employees.length; i++){
                        tempEmployees[i] = new Employee(employees[i]);
                    }
                    tempEmployees[employees.length] = new Employee(heldEmployee);

                    employees = tempEmployees;
                }
                catch(Exception e){
                    if(!errorFound){
                        System.out.print("> Error lines found in file payroll\n\n");
                        errorFound = true;
                    }
                    System.out.print(errorHold + "\n");

                    String[] tempErrors = new String[payrolErrors.length + 1];

                    for (int i = 0; i < payrolErrors.length; i++) {
                        tempErrors[i] = payrolErrors[i];
                    }

                    tempErrors[payrolErrors.length] = errorHold;

                    payrolErrors = tempErrors;

                }
            }
        }catch (IOException e){
            System.out.print("Error IO");
        }


        System.out.print("\n> " + (employees.length + payrolErrors.length) + " lines read from file payroll\n");

        BufferedWriter errorWriter = null;

        try{
            errorWriter = new BufferedWriter(new FileWriter("payrollError.txt"));

            for(int i = 0; i < payrolErrors.length; i++){
                errorWriter.write(payrolErrors[i] + "\n");
            }

            errorWriter.flush();
            errorWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("\n> " + payrolErrors.length + " lines written to error file \n\n");

        BufferedWriter payrollwriter = null;

        try{
            payrollwriter = new BufferedWriter(new FileWriter("payrollReport.txt"));

            payrollwriter.write("\t\t\tiDroidSolutions Payroll\n");
            payrollwriter.write("\t\t-------------------------------\n");
            payrollwriter.write(String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                    "Emp Number", "First Name", "Last Name",
                    "Gross Salary", "Deductions", "Net Salary"));
            payrollwriter.write("-------------------------------------" +
                    "------------------------------------------------------\n");

            System.out.print("> Calculating Deductions\n\n");

            for(int i = 0; i < employees.length; i++){
                employees[i].getDeductions();
                payrollwriter.write(employees[i].toString() + "\n");
            }

            System.out.print("> Writing report file");
            payrollwriter.flush();
            payrollwriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}