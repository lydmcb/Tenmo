package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transaction;
import com.techelevator.tenmo.security.jwt.TokenProvider;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

public class TransactionController {

    private final TokenProvider tokenProvider;
    private TransactionDao transactionDao;
    private UserDao userDao;
    private AccountDao accountDao;

    public TransactionController(TokenProvider tokenProvider, TransactionDao transactionDao, UserDao userDao, AccountDao accountDao) {
        this.tokenProvider = tokenProvider;
        this.transactionDao = transactionDao;
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @RequestMapping(value = "/transaction/payable-user", method = RequestMethod.GET)
    public List<String> payableUsers() {
            return userDao.payableUser();
        }

    @RequestMapping(value ="/transaction/balance", method = RequestMethod.GET)
    public double updateSenderBalance(double amountTransferred){
         double senderBalance = accountDao.updateSenderBalance(amountTransferred);
         return  senderBalance;
        } // put into variable then post
        public double updateReceiverBalance(double amountTransferred, String username){
        double receiverBalance = accountDao.updateReceiverBalance(amountTransferred, username);
        return receiverBalance;
        } // put into variable then post

        @RequestMapping(value = "/transaction", method = RequestMethod.POST)
    public void transfer (@RequestBody Transaction body, Principal principal){
                //(double senderBalance, double receiverBalance, double amountTransferred, String senderUserName, String receiverUsername){
       // transactionDao.transfer(senderBalance,receiverBalance,amountTransferred, senderUserName, receiverUsername);
        }
   //use Principal
    
}
