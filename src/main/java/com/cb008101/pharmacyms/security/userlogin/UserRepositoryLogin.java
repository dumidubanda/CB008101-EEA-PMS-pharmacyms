package com.cb008101.pharmacyms.security.userlogin;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositoryLogin extends JpaRepository<UserLogin, Integer>
{
    Optional<UserLogin> findUserLoginByUserName(String userName);

}
