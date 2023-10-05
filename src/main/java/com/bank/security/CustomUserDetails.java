package com.bank.security;

import com.bank.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userInfoRepository.findByUserName(username).get();
//        UserInfo u = new UserInfo();
//        u.setEmail("revan@gmail.com");
//        u.setPassword(passwordEncoder().encode("revan"));
//        return u;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return  new BCryptPasswordEncoder();
//    }
}
