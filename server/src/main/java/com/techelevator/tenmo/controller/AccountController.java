package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AccountController {

    private final TokenProvider tokenProvider;
    private AccountDao accountDao;

    public AccountController(TokenProvider tokenProvider, AccountDao accountDao) {
        this.tokenProvider = tokenProvider;
        this.accountDao = accountDao;
    }

    @RequestMapping(value = "/{id}/balance", method = RequestMethod.GET)
    public double getBalance(@PathVariable int id) {
        double accountDaoBalance = accountDao.getBalance(id);
        return accountDao.getBalance(id);
    }

}
