//package com.bank.services;
//
//import com.bank.dto.TransactionRequest;
//import com.bank.dto.TransactionsDto;
//import com.bank.entity.Transaction;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//class TransactionServiceTest {
//
//    @InjectMocks
//    private TransactionService transactionService;
//
//    @Mock
//    private AccountService accountService;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void xmlToString() {
//        String soapResponse = "<ns2:message>Transaction Successful</ns2:message>";
//        String result = transactionService.xmlToString(soapResponse);
//        assertEquals("Transaction Successful", result);
//    }
//
//    @Test
//    public void testXmlToString_Failure() {
//        String soapResponse = "Invalid SOAP Response";
//        String result = transactionService.xmlToString(soapResponse);
//        assertEquals("Transaction Failed, Please check details", result);
//    }
//
//    @Test
//    void getAllTransactions() {
//        // Arrange
//        long accountNumber = 12345L;
//        List<Transaction> mockTransactions = new ArrayList<>();
//        // Add mock transactions to the list...
//
//        // Mock the behavior of the accountService
//        when(accountService.getAllTransactions(accountNumber)).thenReturn(mockTransactions);
//
//        // Act
//        List<TransactionsDto> result = transactionService.getAllTransactions(accountNumber);
//
//        // Assert
//        assertEquals(mockTransactions.size(), result.size());
//        // Add further assertions based on the behavior you expect.
//    }
//
//}