//package com.bank.services;
//
//import com.bank.entity.Account;
//import com.bank.entity.Transaction;
//import com.bank.repository.AccountRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class AccountServiceTest {
//
//    @InjectMocks
//    private AccountService accountService;
//
//    @Mock
//    private AccountRepository accountRepository;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testGetAllTransactions() {
//        long accountNumber = 12345L;
//        Account account = new Account();
//        account.setAccountNumber(accountNumber);
//
//        Transaction transaction1 = new Transaction();
//        transaction1.setTransactionId(1L);
//        Transaction transaction2 = new Transaction();
//        transaction2.setTransactionId(2L);
//
//        List<Transaction> transactions = Arrays.asList(transaction1, transaction2);
//
//        account.setTransactions(transactions);
//
//        when(accountRepository.findById(accountNumber)).thenReturn(Optional.of(account));
//
//        List<Transaction> result = accountService.getAllTransactions(accountNumber);
//
//        assertNotNull(result);
//        assertEquals(transactions.size(), result.size());
//        assertEquals(transactions, result);
//
//        verify(accountRepository).findById(accountNumber);
//    }
//}