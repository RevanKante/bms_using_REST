package com.bank.services;

import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    public List<Transaction> getAllTransactions(long accountNumber) {
        Account account = repository.findById(accountNumber).get();
        return account.getTransactions();
    }
}
