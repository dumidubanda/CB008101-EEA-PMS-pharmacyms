package com.cb008101.pharmacyms.users.user;


import com.cb008101.pharmacyms.users.role.Role;
import com.cb008101.pharmacyms.users.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class UserService
{
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> listAll()
    {
        return (List<User>) userRepo.findAll();
    }

    //List role for New user form
    public List<Role> listRoles()
    {
        return (List<Role>) roleRepo.findAll();
    }


    //Encode password
    private void encodePassword(User user)
    {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }


    //Save new user details
    public User save(User user)
    {
        boolean isUpdatingUser = (user.getId() != null);

        if (isUpdatingUser)
        {
            User existingUser = userRepo.findById(user.getId()).get();

            if (user.getPassword().isEmpty())
            {
                user.setPassword(existingUser.getPassword());
            } else
            {
                encodePassword(user);
            }

        } else
        {
            encodePassword(user);
        }

        return userRepo.save(user);
    }


    //Checking duplicate emails
    public boolean isEmailUnique(Integer id, String email)
    {
        User userByEmail = userRepo.getUserByEmail(email);

        if (userByEmail == null) return true;
        boolean isCreatingNew = (id == null);

        if (isCreatingNew)
        {
            if (userByEmail != null) return false;
        }
        else
        {
            if (userByEmail.getId() != id)
            {
                return false;
            }
        }

        return true;
    }

    //Edit User
    public User get(Integer id) throws UserNotFoundException
    {
        try
        {
            return userRepo.findById(id).get();
        }
        catch (NoSuchElementException ex)
        {
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }
    }

    public void delete(Integer id) throws UserNotFoundException
    {
        Long countById = userRepo.countById(id);
        if (countById == null || countById == 0)
        {
            throw new UserNotFoundException("Could not find any user with ID " + id);
        }

        userRepo.deleteById(id);
    }

    public void updateUserEnabledStatus(Integer id, boolean enabled)
    {
        userRepo.updateEnabledStatus(id, enabled);
    }

}
