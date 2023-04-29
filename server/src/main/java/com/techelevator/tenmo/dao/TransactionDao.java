package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;

import java.security.Principal;
import java.util.List;

public interface TransactionDao {

    void transfer (double amountTransferred, int senderId, int receiverId);

    List<Transaction> transactionList();

    Transaction findTransactionById(int transactionId);

}
