package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcTransactionDao implements TransactionDao{




    @Override
    public List<Transaction> transactionList() {
        return null;
    }

    @Override
    public Transaction findTransactionById(int transactionId) {
        return null;
    }
}
