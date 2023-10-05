package com.bank.services;

import com.bank.dto.ProfileDto;
import com.bank.entity.Account;
import com.bank.entity.UserInfo;
import com.bank.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(UserInfo userInfo) {
        try {
            Account account = new Account();
            account.setUser(userInfo);
            account.setAccountType("Saving");
            account.setBalance(0);
            String userName = userInfo.getEmailAddress();
            String passWord = passwordEncoder.encode(userInfo.getPassword());

            userInfo.setUserName(userName);
            userInfo.setPassword(passWord);
            userInfo.setAccount(account);

            userInfoRepository.save(userInfo);
            return "User registration successful";
        }catch (Exception e) {
            return "Failed to register user";
        }
    }

    public ProfileDto viewProfile(String userName) {
        UserInfo userInfo = userInfoRepository.findByUserName(userName).get();
        ProfileDto profile = new ProfileDto();

        profile.setAccountNumber(userInfo.getAccount().getAccountNumber());
        profile.setEmail(userInfo.getEmailAddress());
        profile.setAddress(userInfo.getAddress());
        profile.setUserName(userInfo.getUsername());
        profile.setName(userInfo.getName());
        profile.setDateOfBirth(userInfo.getDateOfBirth());
        profile.setBalance(userInfo.getAccount().getBalance());
        profile.setAccountType(userInfo.getAccount().getAccountType());
        profile.setMobileNumber(userInfo.getMobileNumber());

        return profile;
    }

    public UserInfo getUserByUserName(String userName) {
        return userInfoRepository.findByUserName(userName).get();
    }
}
