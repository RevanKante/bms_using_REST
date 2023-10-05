package com.bank.services;

import com.bank.dto.TransactionRequest;
import com.bank.dto.TransactionsDto;
import com.bank.entity.Transaction;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String xmlToString(String soapResponse) {
        int startIndex = soapResponse.indexOf("<ns2:message>");
        int endIndex = soapResponse.indexOf("</ns2:message>");

        if (startIndex != -1 && endIndex != -1) {
            return soapResponse.substring(startIndex + 13, endIndex);
        } else {
            return "Transaction Failed, Please check details";
        }
    }

    public List<TransactionsDto> getAllTransactions(long accountNumber) {
        List<TransactionsDto> transactionsList = new ArrayList<>();
        List<Transaction> transactions = accountService.getAllTransactions(accountNumber);
        transactions.forEach(transaction -> {
            TransactionsDto transactionsDto = new TransactionsDto();
            transactionsDto.setTransactionId(transaction.getTransactionId());
            transactionsDto.setTransactionType(transaction.getTransactionType());
            transactionsDto.setAmount(transaction.getAmount());
            transactionsDto.setTransactionDate(transaction.getTransactionDate());

            transactionsList.add(transactionsDto);
        });
        return transactionsList;
    }

    public String performTransaction(TransactionRequest transactionRequest) throws IOException {
        String xmlTemplate = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://www.bms.com/transaction-management\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tran:PerformTransactionRequest>\n" +
                "         <tran:userName>%s</tran:userName>\n" +
                "         <tran:transactionType>%s</tran:transactionType>\n" +
                "         <tran:amount>%s</tran:amount>\n" +
                "         <tran:accountNumber>%s</tran:accountNumber>\n" +
                "      </tran:PerformTransactionRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        String xmlRequest = String.format(xmlTemplate, transactionRequest.getUserName(), transactionRequest.getTransactionType(), transactionRequest.getAmount(), transactionRequest.getAccountNumber());

        String url = "docker-transaction-1";
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("text/xml;charset=UTF-8");
        RequestBody body = RequestBody.create(mediaType, xmlRequest);
        String credentials = Credentials.basic(transactionRequest.getUserName(), transactionRequest.getPassword());

        Request request = new Request.Builder()
//                .url("http://localhost:9090/ws")
                .url("http://"+url+":9090/ws")
                .method("POST", body)
                .addHeader("Content-Type", "text/xml;charset=UTF-8")
                .addHeader("Authorization", credentials)
                .build();
        Response response = client.newCall(request).execute();
//        System.out.println("==========================================="+response);
        if (response.isSuccessful()) {
//            System.out.println("***************************************"+response.body().string());
            String responseBodyString = response.body().string();
            return xmlToString(responseBodyString);
        } else {
            return "Transaction failed";
        }
    }
}
