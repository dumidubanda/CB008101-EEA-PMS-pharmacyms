package com.cb008101.pharmacyms.security.userpharmacist;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepositoryLogin extends JpaRepository<UserLogin, Integer>
{
    Optional<UserLogin> findUserLoginByUserName(String userName);

}
