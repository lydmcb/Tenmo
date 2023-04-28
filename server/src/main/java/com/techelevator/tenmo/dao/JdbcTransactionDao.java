package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Component
public class JdbcTransactionDao implements TransactionDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void transfer(double senderBalance, double receiverBalance, double amountTransferred, String senderUserName, String receiverUsername) {

        String sqlSender = "START TRANSACTION; INSERT INTO account (balance)" +
                " VALUES (?) ";
        jdbcTemplate.update(sqlSender, Double.class, senderBalance);

        String sqlReceiver = "INSERT INTO account (balance)" +
                " a JOIN tenmo_user t" +
                " ON a.user_id = t.user_id  WHERE username = ?" +
                " VALUES (?) ";
        jdbcTemplate.update(sqlReceiver, Double.class, receiverBalance);


        String sql = "INSERT INTO transaction (sender, receiver, amountTransferred, status)" +
                " VALUES (?, ?, ?, Approved) RETURNING transaction_id";
            Integer newTransactionId;

            jdbcTemplate.queryForObject(sql, Integer.class, senderUserName, receiverUsername, amountTransferred);

    }

    @Override
    public List<Transaction> transactionList() {
        return null;
    }

    @Override
    public Transaction findTransactionById(int transactionId) {
        return null;
    }
}
