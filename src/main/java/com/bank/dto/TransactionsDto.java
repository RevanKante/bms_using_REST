package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionsDto {
    private long transactionId;
    private String transactionType;
    private double amount;
    private Date transactionDate;
}
