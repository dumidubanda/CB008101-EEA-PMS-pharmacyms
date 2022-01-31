package com.cb008101.pharmacyms.users.security;

import com.cb008101.pharmacyms.users.user.User;
import com.cb008101.pharmacyms.users.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class ShopmeUserDetailsService implements UserDetailsService
{

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = userRepo.getUserByEmail(email);
        if (user != null)
        {
            return new ShopmeUserDetails(user);
        }

        throw new UsernameNotFoundException("Could not find user with email: " + email);
    }

}
