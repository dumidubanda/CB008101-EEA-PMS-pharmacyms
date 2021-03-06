package com.cb008101.pharmacyms.web;


import com.cb008101.pharmacyms.stock.Stock;
import com.cb008101.pharmacyms.pharmaitems.ItemsService;
//import com.cb008101.pharmacyms.invoice.InvoiceService;
import com.cb008101.pharmacyms.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StockWebController {
    @Autowired
    private StockService stockService;

    @Autowired
    private ItemsService itemsService;


    @GetMapping("/viewItemStocks")
    public String viewItemStocks(Stock stock, Model model){
        model.addAttribute("stock", stockService.getAllDetailsOfStock());
        return "stock/view_stock";
    }

    @GetMapping("/showAddStockForm")
    public String showAddStockForm(Stock stock, Model model){
        model.addAttribute("drugs", itemsService.getAllDrugs());
        return "stock/add_stock";
    }

    @PostMapping("/addNewStock")
    public String addNewStock(@Valid Stock stock, BindingResult result, Model model){
        if(result.hasErrors()){
            return  "stock/add_stock";
        }
        stockService.addStock(stock);
        return "redirect:/viewItemStocks";
    }

    @GetMapping("/showUpdateStockForm/{id}")
    public String showEditStockForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("stock", stockService.getStockByID(id));
        return "stock/edit_stock";
    }

    @PostMapping("/updateStock/{id}")
    public String updateStock(@PathVariable ("id") Integer id, @Valid Stock stock, BindingResult result, Model model){
        if(result.hasErrors()){
            stock.setStockID(id);
            model.addAttribute("stock", stock);
            return "stock/edit_stock";
        }
        Optional<Stock> stock1 = stockService.updateStock(id, stock);
        return "redirect:/viewItemStocks";
    }


    @GetMapping("/deleteStock/{id}")
    public String deleteCategory(@PathVariable ("id") Integer id, Model model) {
        stockService.deleteStock(id);
        return "redirect:/viewItemStocks";
    }

}
