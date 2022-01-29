//package com.cb008101.pharmacyms.web;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
//public class PharmacistWebController {
//
//    @Autowired
//    private PharmacistService pharmacistService;
//
//    @GetMapping("/")
//    public String showIndex(){
//        return "index";
//    }
//
//    @GetMapping("/viewPharmacist")
//    public String getAllPharmacists(Model model){
//        model.addAttribute("pharmacist", pharmacistService.getAllPharmacists());
//        return "pharmacists/view_pharmacist";
//    }
//
//    @GetMapping("/showAddPharmacistForm")
//    public String showAddPharmacistForm(UserPharmacist pharmacist){
//        return "pharmacists/add_pharmacist";
//    }
//
//    @PostMapping("/addNewPharmacist")
//    public String addNewPharmacist(@Valid UserPharmacist pharmacist, BindingResult result, Model model){
//        if(result.hasErrors()) {
//            return "pharmacists/add_pharmacist";
//        }
//
//        pharmacistService.savePharmacist(pharmacist);
//        return "redirect:/viewPharmacist";
//    }
//
//    @GetMapping("/showUpdatePharmacist/{id}")
//    public String showEdiPharmacistForm(@PathVariable ("id") Integer id, Model model){
//        model.addAttribute("pharmacist", pharmacistService.getPharmacistByID(id));
//        return "pharmacists/edit_pharmacist";
//    }
//
//    @PostMapping("/updatePharmacist/{id}")
//    public String updatePharmacist(@PathVariable ("id") Integer id, @Valid UserPharmacist pharmacist, BindingResult result, Model model){
//        if(result.hasErrors()){
//            pharmacist.setpID(id);
//            model.addAttribute("pharmacist", pharmacist);
//            return "pharmacists/edit_pharmacist";
//        }
//        Optional<UserPharmacist> pharm1 = pharmacistService.updatePharmacist(id, pharmacist);
//        return "redirect:/viewPharmacist";
//    }
//
//    @GetMapping("/deletePharmacist/{id}")
//    public String deletePharmacist(@PathVariable ("id") Integer id, Model model) {
//        pharmacistService.deletePharmacist(id);
//        return "redirect:/viewPharmacist";
//    }
//
//    @GetMapping("/403")
//    public String errorPage403() {
//        return "errors/403";
//    }
//
//}
