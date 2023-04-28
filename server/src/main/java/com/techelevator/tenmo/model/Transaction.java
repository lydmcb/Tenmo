package com.techelevator.tenmo.model;

public class Transaction {

    private int transactionId;
    private String sender;
    private String receiver;
    private double amountTransferred;
    private String status;

    public Transaction(int transactionId, String sender, String receiver, double amountTransferred, String status) {
        this.transactionId = transactionId;
        this.sender = sender;
        this.receiver = receiver;
        this.amountTransferred = amountTransferred;
        this.status = status;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;}

    public String getReceiverId() {
        return receiver;
    }

    public void setReceiverId(String receiver) {
        this.receiver = receiver;
    }

    public double getAmountTransferred() {
        return amountTransferred;
    }

    public void setAmountTransferred(double amountTransferred) {
        this.amountTransferred = amountTransferred;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
