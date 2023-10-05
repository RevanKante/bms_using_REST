package com.bank.dto;

import com.bank.encrypt.MaskData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    @MaskData
    private long accountNumber;
    private String email;
    private String address;
    private String userName;
    private String name;
    private Date DateOfBirth;
    private double balance;
    private String accountType;
    @MaskData
    private String mobileNumber;
}
