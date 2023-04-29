package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



import java.security.Principal;
import java.util.List;

@Component
public class JdbcTransactionDao implements TransactionDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void transfer(double amountTransferred, int senderId, int receiverId) {

        String sql = "INSERT INTO transaction (sender_id, receiver_id, amount_transferred, status)" +
                " VALUES (?, ?, ?, 'Approved') RETURNING transaction_id";
        int newTransactionId;
        try {
             newTransactionId = jdbcTemplate.queryForObject(sql, Integer.class, senderId, receiverId, amountTransferred);
        } catch (EmptyResultDataAccessException e){
            System.out.println("Error transaction not found");
        }

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
