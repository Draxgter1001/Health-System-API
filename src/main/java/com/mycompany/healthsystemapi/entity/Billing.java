/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.healthsystemapi.entity;

/**
 *
 * @author uthsh
 */
public class Billing {

    private int id;
    private double amount;
    private String paymentStatus;
    private String issueDate;
    private String dueDate;
    private double outStandingBalance;
    
    public Billing(){
        
    }

    public Billing(int id, double amount, String paymentStatus, String issueDate, String dueDate, double outStandingBalance) {
        this.id = id;
        this.amount = amount;
        this.paymentStatus = "Pending";
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.outStandingBalance = outStandingBalance;
    }
    
    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
    
    public String getIssueDate() {
        return issueDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public double getOutStandingBalance() {
        return outStandingBalance;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    public void setOutStandingBalance(double outStandingBalance) {
        this.outStandingBalance = outStandingBalance;
    }
}