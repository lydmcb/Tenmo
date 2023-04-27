package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.security.jwt.TokenProvider;

public class TransactionController {

    private final TokenProvider tokenProvider;
    private TransactionDao transactionDao;

    public TransactionController(TokenProvider tokenProvider, TransactionDao transactionDao) {
        this.tokenProvider = tokenProvider;
        this.transactionDao = transactionDao;
    }


    
}
