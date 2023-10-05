//package com.bank.services;
//
//import com.bank.dto.ProfileDto;
//import com.bank.entity.Account;
//import com.bank.entity.UserInfo;
//import com.bank.repository.UserInfoRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.Date;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//class UserServiceTest {
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserInfoRepository userInfoRepository;
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
//    void testRegister() {
//        String userName = "aditya@gmail.com";
//        UserInfo userInfo = new UserInfo();
//        Account account = new Account();
//        account.setAccountNumber(1);
//        account.setAccountType("Saving");
//        account.setBalance(500);
//        account.setTransactions(null);
//
//        userInfo.setUserId(1);
//        userInfo.setUserName(userName);
//        userInfo.setName("aditya");
//        userInfo.setPassword("aditya");
//        userInfo.setDateOfBirth(new Date());
//        userInfo.setGender("Male");
//        userInfo.setAddress("Mumbai");
//        userInfo.setMobileNumber("9090897867");
//        userInfo.setEmailAddress("aditya@gmail.com");
//        userInfo.setAccount(account);
//
//        when(userInfoRepository.save(userInfo)).thenReturn(userInfo);
//        when(passwordEncoder.encode(userInfo.getPassword())).thenReturn("hashedPassword");
//
//        String result = userService.register(userInfo);
//        assertEquals("User registration successful", result);
//    }
//
//    @Test
//    void testViewProfile() {
//        String userName = "aditya@gmail.com";
//        UserInfo userInfo = new UserInfo();
//        Account account = new Account();
//        account.setAccountNumber(1);
//        account.setAccountType("Saving");
//        account.setBalance(500);
//        account.setTransactions(null);
//
//        userInfo.setUserId(1);
//        userInfo.setUserName(userName);
//        userInfo.setName("aditya");
//        userInfo.setPassword("aditya");
//        userInfo.setGender("Male");
//        userInfo.setAddress("Mumbai");
//        userInfo.setMobileNumber("9090897867");
//        userInfo.setEmailAddress("aditya@gmail.com");
//        userInfo.setAccount(account);
//
//        when(userInfoRepository.findByUserName(userName)).thenReturn(Optional.of(userInfo));
//        ProfileDto profile = userService.viewProfile(userName);
//        assertNotNull(profile);
//        assertEquals(1,profile.getAccountNumber());
//        assertEquals("aditya",profile.getName());
//        assertEquals(500,profile.getBalance());
//        assertEquals("Mumbai",profile.getAddress());
//        assertEquals("aditya@gmail.com",profile.getUserName());
//        assertEquals("aditya@gmail.com",profile.getEmail());
//        assertEquals("Saving",profile.getAccountType());
//        assertEquals("9090897867",profile.getMobileNumber());
//    }
//
//    @Test
//    void getUserByUserName() {
//        String userName = "aditya@gmail.com";
//        UserInfo userInfo = new UserInfo();
//        Account account = new Account();
//        account.setAccountNumber(1);
//        account.setAccountType("Saving");
//        account.setBalance(500);
//        account.setTransactions(null);
//
//        userInfo.setUserId(1);
//        userInfo.setUserName(userName);
//        userInfo.setName("aditya");
//        userInfo.setPassword("aditya");
//        userInfo.setDateOfBirth(new Date());
//        userInfo.setGender("Male");
//        userInfo.setAddress("Mumbai");
//        userInfo.setMobileNumber("9090897867");
//        userInfo.setEmailAddress("aditya@gmail.com");
//        userInfo.setAccount(account);
//
//        when(userInfoRepository.findByUserName(userName)).thenReturn(Optional.of(userInfo));
//
//        UserInfo result = userService.getUserByUserName(userName);
//
//        assertNotNull(result);
//        assertEquals("aditya@gmail.com", result.getUsername());
//        assertNotNull(result.getAccount());
//    }
//}