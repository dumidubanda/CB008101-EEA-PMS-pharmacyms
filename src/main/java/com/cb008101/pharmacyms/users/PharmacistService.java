package com.cb008101.pharmacyms.users;


import java.util.List;
import java.util.Optional;

public interface PharmacistService
{

    void savePharmacist(UserPharmacist userPharmacist);

    List<UserPharmacist> getAllPharmacists();

    UserPharmacist getPharmacistByID(Integer id);

    Optional<UserPharmacist> updatePharmacist(Integer id, UserPharmacist userPharmacist);

    void deletePharmacist(Integer id);

}
