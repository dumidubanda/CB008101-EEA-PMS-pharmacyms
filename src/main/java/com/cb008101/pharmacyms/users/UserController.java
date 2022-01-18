package com.cb008101.pharmacyms.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private PharmacistService pharmacistService;

    @RequestMapping(method = RequestMethod.POST, value = "/savePharmacist")
    public void savePharmacist(@RequestBody UserPharmacist userPharmacist)
    {
        pharmacistService.savePharmacist(userPharmacist);
    }

    @RequestMapping("/getAllPharmacists")
    public List<UserPharmacist> getAllPharmacists()
    {
        return pharmacistService.getAllPharmacists();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatePharmacist/{id}")
    public void updatePharmacist(@PathVariable Integer id, @RequestBody UserPharmacist userPharmacist)
    {
        pharmacistService.updatePharmacist(id, userPharmacist);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletePharmacist/{id}")
    public void deleteStudent(@PathVariable Integer id)
    {
        pharmacistService.deletePharmacist(id);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/getPharmacistById/{id}")
//    private Customer getPharmacistById(@PathVariable Integer id)
//    {
//        return UserLogin.(id);
//    }
}
