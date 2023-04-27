package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean createAccount(int userId) {

        String sql = "INSERT INTO account (user_id, balance) " +
                "VALUES (?, 1000.00) RETURNING account_id";
        Integer newAccountId;

            jdbcTemplate.queryForObject(sql, Integer.class, userId);

        return true;
    }

    @Override
    public List<Account> listAccounts(int userId) {
        return null;
    }

    @Override
    public double getBalance() {
        String sql = "SELECT balance FROM account";
        return jdbcTemplate.queryForObject(sql, Double.class);

    }




    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }
}
