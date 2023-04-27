package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class AccountController {

    private final TokenProvider tokenProvider;
    private AccountDao accountDao;

    public AccountController(TokenProvider tokenProvider, AccountDao accountDao) {
        this.tokenProvider = tokenProvider;
        this.accountDao = accountDao;
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public double getBalance() {
        double accountDaoBalance = accountDao.getBalance();
        return accountDao.getBalance();
    }


}
