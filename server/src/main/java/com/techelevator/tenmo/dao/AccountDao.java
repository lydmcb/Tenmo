package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.util.List;

public interface AccountDao {

    boolean create(int userId);

    List<Account> listAccounts(int userId);

    double getBalance(int accountId);

}
