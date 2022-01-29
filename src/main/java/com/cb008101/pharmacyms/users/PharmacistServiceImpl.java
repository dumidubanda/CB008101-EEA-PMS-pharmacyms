package com.cb008101.pharmacyms.users;

import com.cb008101.pharmacyms.security.userpharmacist.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PharmacistServiceImpl implements PharmacistService
{
    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void savePharmacist(UserPharmacist userPharmacist)
    {

        UserLogin pharmacistLogin = new UserLogin();
        pharmacistLogin.setPassword(passwordEncoder.encode("123456"));
        pharmacistLogin.setRoles("ROLE_PHARMACIST");
        pharmacistLogin.setUserName(userPharmacist.getpEmail());
        pharmacistLogin.setStatus(true);
        userPharmacist.setPharmacistLogin(pharmacistLogin);
        pharmacistRepository.save(userPharmacist);
    }

    @Override
    public List<UserPharmacist> getAllPharmacists()
    {
        List<UserPharmacist> userPharmacistList = new ArrayList<>();
        pharmacistRepository.findAll().forEach(userPharmacistList::add);
        return userPharmacistList;
    }

    @Override
    public UserPharmacist getPharmacistByID(Integer id)
    {
        Optional<UserPharmacist> phrmacist = Optional.ofNullable(pharmacistRepository.
                findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID")));
        UserPharmacist userPharmacist = phrmacist.get();
        return userPharmacist;
    }

    @Override
    @Transactional
    public Optional<UserPharmacist> updatePharmacist(Integer id, UserPharmacist userPharmacist)
    {
        return pharmacistRepository.findById(id).map(e ->
        {
            e.setpName(userPharmacist.getpName());
            e.setpEmail(userPharmacist.getpEmail());
            return e;
        });
    }

    @Override
    public void deletePharmacist(Integer id)
    {
        pharmacistRepository.deleteById(id);
    }


}
