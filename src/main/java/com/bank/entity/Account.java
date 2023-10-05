package com.bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
//@Table(name = "Account")
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long accountNumber;

    private String accountType;

    private double balance;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private UserInfo user;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", user=" + user +
                ", transactions=" + transactions +
                '}';
    }
}
