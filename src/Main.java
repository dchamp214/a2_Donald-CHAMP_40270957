// ----------------------------------------------------
// Assignment 2
// Question: 1/1
// Written by: Donald Champ (40270957)
// ----------------------------------------------------
// This program is used to read a payroll text file, storing each employee's information,
// checks for errors which are written to a payrollError text file. The correct information
// is used to calculate the employees deductions based on the taxes applied. These taxes
// are individually calculated using child classes of an abstract Deductions class.
//  All the information is then written in tabular format to a payrollReport text file, which
// as employee number, first name, last name, gross salary, total taxes and net salary.
// ----------------------------------------------------

// Import Employee Package
import Employee.*;

// Import other important classes
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Initialize reader to null
        Scanner reader = null;

        // Create and initialize all employee variables to default
        long employeeNumber = 0;
        String firstName = null;
        String lastName = null;
        double hoursWorked = 0;
        double hourlyWage = 0;

        // Create employee array as well as employee object used to hold the new employee
        Employee[] employees = new Employee[0];
        Employee heldEmployee;

        // Create variables associated with errors in the payroll.txt file
        String errorHold = null;
        String[] payrolErrors = new String[0];

        // Boolean for any errors found set to false
        boolean errorFound = false;

        System.out.print("Welcome to Donald Champ's (40270957) iDroid Solutions Payroll Calculator\n\n");

        try{
            // Informs user of attempt to open payroll file
            System.out.print("> Opening Payroll File...\n\n");
            // Uses scanner to open payroll file for reading
            reader = new Scanner(new FileInputStream("payroll.txt"));

            // Inform user of payroll file being read
            System.out.print("> Reading file payroll...\n\n");

            while(reader.hasNextLine()){
            // while loop continually hit if the payroll file has more text to read
                try {
                    // Hold current line in a String
                    String heldString = reader.nextLine();

                    // Hold current line in a separate String in case of error
                    errorHold = heldString;

                    // Initialize new scanner to the heldString
                    Scanner heldScan = new Scanner(heldString);

                    // Take the employees information, stored in associated variables
                    employeeNumber = heldScan.nextLong();
                    firstName = heldScan.next();
                    lastName = heldScan.next();
                    hoursWorked = heldScan.nextDouble();
                    hourlyWage = heldScan.nextDouble();

                    // Throws Exception if wage is below legal minimum

                    MinimumWageException.testWage(hourlyWage);

                    // If no exceptions are thrown new employee object is created with current line info
                    heldEmployee = new Employee(employeeNumber, firstName, lastName, hoursWorked, hourlyWage);


                    // Array is extended by one, copied, then new employee is added
                    Employee[] tempEmployees = new Employee[employees.length + 1];

                    for(int i = 0; i < employees.length; i++){
                        tempEmployees[i] = new Employee(employees[i]);
                    }
                    tempEmployees[employees.length] = new Employee(heldEmployee);

                    employees = tempEmployees;
                }
                // If exceptions such as IncorrectType or a MinimumWage are thrown they are caught here
                catch(Exception e){
                    // Checks if previous errors had been found to inform user of error in payroll
                    if(!errorFound){
                        System.out.print("> Error lines found in file payroll\n\n");
                        errorFound = true;
                    }
                    // Displays error line to user
                    System.out.print(errorHold + "\n");

                    // Error line string is added to array by extending and copying
                    String[] tempErrors = new String[payrolErrors.length + 1];

                    for (int i = 0; i < payrolErrors.length; i++) {
                        tempErrors[i] = payrolErrors[i];
                    }

                    tempErrors[payrolErrors.length] = errorHold;

                    payrolErrors = tempErrors;

                }
            }
        // Catching any possible IOExceptions
        }catch (IOException e){
            System.out.print("Error IO");
        }


        // Displays to user how many lines were read
        System.out.print("\n> " + (employees.length + payrolErrors.length) + " lines read from file payroll\n");

        // Create writer that will write error lines
        BufferedWriter errorWriter = null;

        // Try block for writing errors to associated txt file
        try{
            // Writer is initialized to associated txt file
            errorWriter = new BufferedWriter(new FileWriter("payrollError.txt"));

            // Writer writes each error line to file
            for(int i = 0; i < payrolErrors.length; i++){
                errorWriter.write(payrolErrors[i] + "\n");
            }

            // Writer is flushed then closed
            errorWriter.flush();
            errorWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Informs user to number of lines written to error file
        System.out.print("\n> " + payrolErrors.length + " lines written to error file \n\n");

        // Creates new writer to write to the report file
        BufferedWriter payrollwriter = null;

        try{
            // Initializes writer to the payrollReport file
            payrollwriter = new BufferedWriter(new FileWriter("payrollReport.txt"));

            // Utilizes String format to display payroll data in tabular format
            payrollwriter.write("\t\t\tiDroidSolutions Payroll\n");
            payrollwriter.write("\t\t-------------------------------\n");
            payrollwriter.write(String.format("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                    "Emp Number", "First Name", "Last Name",
                    "Gross Salary", "Deductions", "Net Salary"));
            payrollwriter.write("-------------------------------------" +
                    "------------------------------------------------------\n");

            System.out.print("> Calculating Deductions\n\n");

            // Calculates all employee deductions and writes same employee details to report using toString
            for(int i = 0; i < employees.length; i++){
                employees[i].getDeductions();
                payrollwriter.write(employees[i].toString() + "\n");
            }

            // Flushes and closes the writer
            System.out.print("> Writing report file");
            payrollwriter.flush();
            payrollwriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}