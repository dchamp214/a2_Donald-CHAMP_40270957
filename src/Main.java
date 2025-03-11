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

        try{
            reader = new Scanner(new FileInputStream("payroll.txt"));

            while(reader.hasNextLine()){
                try {
                    employeeNumber = reader.nextLong();
                    firstName = reader.next();
                    lastName = reader.next();
                    hoursWorked = reader.nextDouble();
                    hourlyWage = reader.nextDouble();

                    heldEmployee = new Employee(employeeNumber, firstName, lastName, hoursWorked, hourlyWage);

                    Employee[] tempEmployees = new Employee[employees.length + 1];

                    for(int i = 0; i < employees.length; i++){
                        tempEmployees[i] = new Employee(employees[i]);
                    }
                    tempEmployees[employees.length] = new Employee(heldEmployee);

                    employees = tempEmployees;
                }
                catch(InputMismatchException e){
                    System.out.print("This is added to error file");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("Error filenotfound");
        } catch (IOException e){
            System.out.print("Error IO");
        }


        BufferedWriter payrollwriter = null;

        try{
            payrollwriter = new BufferedWriter(new FileWriter("payrollReport.txt"));

            payrollwriter.write("\t\t\tiDroidSolutions Payroll\n\t\t-------------------------------");
            payrollwriter.write("\nEmp Number\tFirst Name\tLast Name\tGross Salary\tDeductions\tNet Salary\n");
            payrollwriter.write("--------------------------------------------------------------------------------\n");

            for(int i = 0; i < employees.length; i++){
                employees[i].getDeductions();
                payrollwriter.write(employees[i].toString() + "\n");
            }

            payrollwriter.flush();
            payrollwriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}