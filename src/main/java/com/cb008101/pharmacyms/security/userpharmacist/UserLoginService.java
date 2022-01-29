package com.cb008101.pharmacyms.security.userpharmacist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserLoginService implements UserDetailsService
{

    @Autowired
    UserRepositoryLogin  userRepositoryLogin;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<UserLogin> userLogin = userRepositoryLogin.findUserLoginByUserName(username);
        userLogin.orElseThrow(() -> new IllegalArgumentException("User Not Found: " + username));
        return userLogin.map(UserDetailsLogin::new).get();

    }
}
