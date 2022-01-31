package com.cb008101.pharmacyms.users.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController
{
//
//	@Autowired private CategoryService categoryService;
//
//	@GetMapping("")
//	public String viewHomePage(Model model) {
//		List<Category> listCategories = categoryService.listNoChildrenCategories();
//		model.addAttribute("listCategories", listCategories);
//
//		return "index";
//	}

//	@GetMapping("/login")
//	public String viewLoginPage() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//			return "login";
//		}
//
//		return "redirect:/";
//	}

    @GetMapping("/login")
    public String viewLoginPage()
    {

        return "login";

    }
}
