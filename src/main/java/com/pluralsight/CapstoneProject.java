package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CapstoneProject {
    static ArrayList<transaction> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

//        deposit.makeDeposit();
//        String filename = "src/employees.csv";
        String option;
        //homescreen
        do {
            System.out.println("Welcome to the Accounting Ledger Application!\n" +
                    "────── ⋆⋅☆⋅⋆ ──────\n" +
                    "Please choose an option:\n" +
                    "D) Add Deposit (Sell)\n" +//ask for deposit information, how much they want to deposit, invoice/description, name, and save to csv file
                    "P) Make Payment (Buy)\n" +//prompt for debit info and save to csv file
                    "L) Ledger (Display Ledger Screen\n" +
                    "X) Exit - exit the application");
            //make uppercase:
            option = scanner.nextLine().toUpperCase();
            //switch statement:
            switch (option) {
                case "D":
                    deposit.makeDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    displayLedger();
                case "X":
                    System.out.println("Bye bye :)!");
                    break;
                default:
                    System.out.println("This option is not available. Please choose again.");
            }

        } while (!option.equals("X")); //keeps looping until x pressed
    }

    public static void displayLedger() {

        System.out.println("Displaying all transactions:");
        for (transaction t : transactions) {
            System.out.println(t);
        }
    }
        public static void loadTransactions() {
            String filename = "transactions.csv";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd|HH:mm:ss");

            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 5) {
                        LocalDate date = LocalDate.parse(parts[0], dateTimeFormatter);
                        LocalTime time = LocalTime.parse(parts[1], dateTimeFormatter);
                        String description = parts[2];
                        String vendor = parts[3];
                        float amount = Float.parseFloat(parts[4]);/////////////////////////////////////

                        transaction t = new transaction(date, time, description, vendor, amount);
                        transactions.add(t);
                    } else {
                        System.out.println("Invalid line format: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file O.o;;");
                e.printStackTrace(); //////////////////////////////////////////////
            }
        }


        String filename = "src/transaction.csv";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                // Check if the first part contains both date and time
                if (parts.length != 4) {
                    System.out.println("Invalid line format: " + line);
                    continue; // Skip invalid lines
                }
            }
        }

        //Get only payments (negative amounts)
        public ArrayList<transaction> getPayments() {
            List<transaction> payments = new ArrayList<>();
            for (transaction t : transactions) {
                if (transaction.getAmount() < 0) {
                    payments.add(t);
                }
            }// Get only deposits (positive amounts)
            public ArrayList<transaction> getDeposits() {
                ArrayList<transaction> deposits = new ArrayList<>();
                for (transaction t : transactions()) {
                    if (transaction.getAmount() > 0) {
                        deposits.add(t);
                    }
                }
                return deposits;
            }
            return payments;
        }

        public static void deposit() {
        String description, vendor;
        float amount;

        //1. asking for how much it costs
        System.out.println("How much did you sell this item for?");
        amount = scanner.nextFloat();
        scanner.nextLine();
        //2. asking for a description
        System.out.println("What is this item?");
        description = scanner.nextLine();
        //3.asking for buyer's name
        System.out.println("Name of buyer?");
        vendor = scanner.nextLine();
        // Writing to the CSV file (transactions.csv)
// add transactiondetails to an array of transactions
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Add the transaction to the list (you need to have a proper transaction class defined)
        transaction t = new transaction(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
        transactions.add(t);
        //saving it to file!!
        try(FileWriter writer = new FileWriter("transaction.csv", true)) {
            writer.write(date + "|" + time + "|" + description + "|" + vendor + "|" + amount);
            System.out.println("Okey Dokey deposit saved! yyayyyyyy");
        }catch (IOException e) {
            System.out.println("an error occurred :c");
            e.printStackTrace();
        }

    }
    public static void makePayment() {
        String description, vendor;
        float amount;

        //1. asking for how much it costs
        System.out.println("How much did you sell this item for?");
        amount = scanner.nextFloat();
        scanner.nextLine();
        //2. asking for a description
        System.out.println("What is this item?");
        description = scanner.nextLine();
        //3.asking for buyer's name
        System.out.println("Name of seller?");
        vendor = scanner.nextLine();
        // Writing to the CSV file (transactions.csv)
// add transactiondetails to an array of transactions
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        // Add the transaction to the list (you need to have a proper transaction class defined)
        transaction t = new transaction(date, time, description, vendor, float amount);
        transactions.add(t);
        //saving it to file!!
        transactions.add(new transaction(date + "|" + time + "|" + description + "|" + vendor + "|" + amount));

        System.out.println("okey dokey artichoke :3 payment has been saved");
    }
    public static void showReports

    }
}



        //payments
       /*import java.time.LocalDateTime; import java.time.format.DateTimeFormatter; public class Program { public static void main(String[] args) { LocalDateTime today = LocalDateTime.now(); System.out.println("Today is: " + today); // Specify the date/time format you will want to use DateTimeFormatter fmt = DateTimeFormatter.ofPattern("E, MMM dd, yyyy HH:mm:ss"); String formattedDate = today.format(fmt); System.out.println("Today is: " + formattedDate); } }
        }
        }
        ArrayList<Product> products = new ArrayList<Product>();

        Product p1 = new Product(1,"Iphone 15", 999);
        products.add(p1);

        Task: Create a new Java project and a class for managing transactions.

        Hint: Create a class named TransactionApp with a main method.

        Consider: Think about what kind of data you'll be storing for each transaction (e.g., date, amount, vendor).
        String filename = "src/employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(("\\|"));

                //mapping parts
                int employeeId = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]); //converts it to double
                double payRate = Double.parseDouble(parts[3]);

                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.println("Gross pay for " + employee.getName() + ": $" + employee.getGrossPay());
            }
        }catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }


        public class TransactionApp {

            public static void main(String[] args) {

                // TODO: Implement the main logic here.

            }

        }







        Step 2: Design a Class to Represent a Transaction

        Task: Create a class that will store details for each transaction.

        Hint: Define fields for date, time, description, vendor, type (e.g., Deposit or Payment), and amount.

                Tip: Consider using Java's LocalDate and LocalTime classes for handling date and time.



        public class FinancialTransactionsCLI {

            // Fields for type, date, time, description, vendor, and amount.



            // Constructor here.

            public FinancialTransactionsCLI(" parameters:p ") {

                // Initialize fields.

            }



            // Getters and setters here.

    }







        Step 3: Display the Home Screen Menu

        Task: Write a method to display a menu with options like "Add Deposit," "Make Payment," "View Ledger," etc.

                Hint: Use System.out.println for each option and Scanner to read user input.

        Question: How can you keep showing the menu until the user decides to exit?



        public static void displayMenu() {

            System.out.println("1) Add Deposit");

            System.out.println("2) Make Payment");

            System.out.println("3) View Ledger");

            // Add more options here.

            System.out.print("Enter your choice: ");

        }









        Step 4: Implement Input Loop

        Task: Set up a loop that keeps displaying the menu until the user selects "Exit."

        Hint: Use a while loop to keep the program running.

        Question: How will you handle different user choices, like adding a deposit or viewing the ledger?



                Scanner scanner = new Scanner(System.in);

        String choice = "";



        while (!choice.equals("X")) {

            displayMenu();

            choice = scanner.nextLine().trim();



            // Switch or if-else statement to handle choices.

            // TODO: Add logic for each menu option.

        }







        Step 5: Add Functionality for Deposits

        Task: Write a method to add a new deposit.

                Hint: Prompt the user for information such as description, vendor, and amount.

                Consider: What happens if the user enters a negative amount? How will you handle that?

                Example Guidance: Think about how you would store this data in a format that can be easily saved to a file.



        public static void addDeposit() {

            // Prompt for description.

            System.out.print("Enter description: ");

            // Prompt for vendor.

            // Prompt for amount.



            // Create a transaction object.

            // TODO: Save the transaction to the list or file.

        }







        Step 6: Add Functionality for Payments

        Task: Write a method to add a new payment.

                Hint: This method will be similar to the deposit method but will record the amount as a negative value.

        Consider: How will you ensure that payments are correctly saved as negative values?



        public static void writeToCsv(String record) {

            // Open the file in append mode.

            // Write the record and a newline.

            // TODO: Handle exceptions for file operations.

        }







        Step 7: Write a Method to Save to CSV

        Task: Create a method that saves transaction details to a CSV file.

                Hint: Think about which classes and methods in Java can help write data to files.

        Consider: How can you ensure that each transaction is saved on a new line in the file?



                Step 8: Write a Method to Read from CSV

        Task: Write a method that reads transaction data from the CSV file into a list.

        Hint: Use Java's file reading methods to get all lines from the CSV file.

        Consider: How will you handle situations where the file does not exist yet?



        public static List<String> readFromCsv()

        { // Read lines from the CSV.



// TODO: Parse each line into a transaction object.

// Return the list of transaction objects. }





            Step 9: Display the Ledger

            Task: Create a method to display all transactions in a readable format.

                Hint: Loop through each transaction and print its details.

            Question: How can you format the output to make it easy to read?



            Step 10: Sort Transactions by Date

            Task: Write a method to sort transactions by date.

            Hint: Use Java's List.sort() method with a custom comparator.

            Consider: Should the transactions be sorted from oldest to newest or the other way around?

            Example Guidance: Think about how you can use Java's compareTo() method for comparing dates.

            public static void sortTransactionsByDate(List<FinancialTransactionsCLI> transactions) {
            transactions.sort((line1, line2) -> line2.getDate().compareTo(line1.getDate()));
        }

            Step 11: Implement Reports

            Task: Create a method to generate different types of reports (e.g., Month to Date, Year to Date).

                Hint: Use Java's LocalDate and ChronoUnit classes for date calculations.

            Consider: How will you filter transactions to include only those within a certain date range?

            Example Guidance: Think about how to create a method that accepts a date range and returns only transactions within that range.



                Step 12: Search by Vendor

            Task: Write a method that allows users to search for transactions by vendor.

                Hint: Use a loop to find transactions that match the user's input for the vendor name.

            Consider: How can you make the search case-insensitive?

                                                              Example Guidance: Think about using String methods that can help match user input to vendor names.



            Step 13: Validate User Input

            Task: Ensure that user input is validated throughout the application.

                    Hint: Check for valid amounts, dates, and other data.

            Consider: How will you handle input errors gracefully without crashing the program?

                    Question: What kind of error messages would be helpful to users?



                    Step 14: Final Testing and Debugging

            Task: Test the entire application, focusing on edge cases like an empty CSV file or invalid user input.

            Hint: Add print statements to trace where things might be going wrong during testing.

                    Consider: How will you ensure the application handles unexpected scenarios?

*/