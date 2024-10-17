package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

//Here, I will parse the transaction file.
public class transaction {
    private LocalTime date;
    private LocalDate time;
    private String description;
    private String vendor;
    private float price;
    //alt + insert (click constructor, select all
    // Get only payments (negative amounts)
//    public List<Transaction> getPayments() {
//        List<Transaction> payments = new ArrayList<>();
//        for (Transaction transaction : loadTransactions()) {
//            if (transaction.getAmount() < 0) {
//                payments.add(transaction);
//            }
//        }// Get only deposits (positive amounts)
//        public List<Transaction> getDeposits() {
//            List<Transaction> deposits = new ArrayList<>();
//            for (Transaction transaction : loadTransactions()) {
//                if (transaction.getAmount() > 0) {
//                    deposits.add(transaction);
//                }
//            }
//            return deposits;
//        }
//        return payments;
//    }
    public transaction(String date, String time, String description, String vendor, String type) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.price = price;
    }
//empty
    public transaction() {

    }
    //getting and setting variables
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("")
    }
}
