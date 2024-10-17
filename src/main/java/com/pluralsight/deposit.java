package com.pluralsight;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class deposit {
    static Scanner scanner = new Scanner(System.in);
    public static void makeDeposit(String[] args) {

        public static void  getdeposit() {
            return deposit;
        }
        public static void setdeposit(class deposit) {
            this.deposit = deposit;
        }
        //getting date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        date = now.format(dateFormatter);
        time = now.format(timeFormatter);
        FileWriter writer = new FileWriter("transaction.csv", true);
        writer.write(now.format(formatter) + "|Deposit amount|" + "Vendor Name" + "| " + amountOfTransaction + "\n");
        writer.close(); // Close the file writer
        //asking for details



}

