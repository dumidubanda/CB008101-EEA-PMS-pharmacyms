package com.cb008101.pharmacyms.users.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{


    @GetMapping("/login")
    public String viewLoginPage()
    {

        return "login";

    }
}
