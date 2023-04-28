package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;

import java.util.List;

public interface TransactionDao {

    void transfer (double senderBalance, double receiverBalance, double amountTransferred, String senderUserName, String receiverUsername);

    List<Transaction> transactionList();

    Transaction findTransactionById(int transactionId);

}
