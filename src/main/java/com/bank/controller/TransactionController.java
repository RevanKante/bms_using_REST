package com.bank.controller;

import com.bank.dto.TransactionRequest;
import com.bank.dto.TransactionsDto;
import com.bank.entity.UserInfo;
import com.bank.services.TransactionService;
import com.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Autowired
    private UserService userService;

    @PostMapping("/performTransaction")
    public String performTransaction(@RequestBody TransactionRequest request) throws IOException {
        return service.performTransaction(request);
    }

    @GetMapping("/getAllTransactions")
    public List<TransactionsDto> getAllTransactions() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserInfo userInfo = userService.getUserByUserName(username);
        long accountNumber = userInfo.getAccount().getAccountNumber();
        return service.getAllTransactions(accountNumber);
    }
}





