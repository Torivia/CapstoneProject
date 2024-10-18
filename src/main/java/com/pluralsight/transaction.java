package com.pluralsight;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class transaction {
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private float amount;
    //alt + insert (click constructor, select all

    public transaction(LocalDate date, LocalTime time, String description, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
//empty
    public transaction() {

    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

//    public transaction(date, time, description, vendor, amount) {
//    }

    //getting and setting variables
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return date + " | " + time + " | " + description + " | " + vendor + " | " + amount;
    }
    }

