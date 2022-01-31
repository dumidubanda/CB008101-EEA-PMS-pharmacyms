package com.cb008101.pharmacyms.users.user;

import com.cb008101.pharmacyms.users.role.Role;
import com.cb008101.pharmacyms.users.user.imageupload.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService service;

    //All user List
    @GetMapping("/users")
    public String listAll(Model model)
    {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "pharmacists/view_pharmacist";
    }

    //Add new user Form
    @GetMapping("/users/new")
    public String newUser(Model model)
    {
        List<Role> listRoles = service.listRoles();


        User user = new User();
        user.setEnabled(true);
        model.addAttribute("user", user);
        model.addAttribute("listRoles", listRoles);

        return "pharmacists/add_pharmacist";
    }


    //Saving filled form
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirectAttributes,
                           @RequestParam("image") MultipartFile multipartFile) throws IOException
    {
        if (!multipartFile.isEmpty())
        {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            user.setPhotos(fileName);
            User savedUser = service.save(user);

            String uploadDir = "user-photos/" + savedUser.getId();

            FileUploadUtil.cleanDir(uploadDir);
            FileUploadUtil.saveFile(uploadDir,fileName,multipartFile);

        }
        else
        {
            if (user.getPhotos().isEmpty()) user.setPhotos(null);
            service.save(user);
        }


        redirectAttributes.addFlashAttribute("message", "The user has been saved successfully.");

        return "redirect:/users";
    }




    //Edit user
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable(name = "id") Integer id,
                           Model model,
                           RedirectAttributes redirectAttributes)
    {
        try
        {

            User user = service.get(id);
            List<Role> listRoles = service.listRoles();

            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
            model.addAttribute("listRoles", listRoles);

            return "pharmacists/edit_pharmacist";

        } catch (UserNotFoundException ex)
        {
            redirectAttributes.addFlashAttribute("message", ex.getMessage());

            return "redirect:/users";
        }


    }

    //Delete User
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id,
                             Model model,
                             RedirectAttributes redirectAttributes)
    {
        try
        {
            service.delete(id);
            redirectAttributes.addFlashAttribute("message",
                    "The user ID " + id + " has been deleted successfully");

        } catch (UserNotFoundException ex)
        {
            redirectAttributes.addFlashAttribute("message", ex.getMessage());


        }
        return "redirect:/users";
    }

    //Enable status
    @GetMapping("/users/{id}/enabled/{status}")
    public String updateUserEnabledStatus(@PathVariable("id") Integer id,
                                          @PathVariable("status") boolean enabled, RedirectAttributes redirectAttributes)
    {
        service.updateUserEnabledStatus(id, enabled);
        String status = enabled ? "enabled" : "disabled";
        String message = "The user ID " + id + " has been " + status;
        redirectAttributes.addFlashAttribute("message", message);

        return "redirect:/users";
    }
}
