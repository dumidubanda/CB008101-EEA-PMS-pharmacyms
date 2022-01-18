package com.cb008101.pharmacyms.web;


//import com.cb008101.pharmacyms.invoice.Invoice;
import com.cb008101.pharmacyms.stock.Stock;
import com.cb008101.pharmacyms.pharmaitems.DrugItemsService;
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
    private DrugItemsService drugItemsService;

//    @Autowired
//    private InvoiceService invoiceService;

    @GetMapping("/viewStock")
    public String viewStock(Stock stock, Model model){
        model.addAttribute("stock", stockService.getAllDetailsOfStock());
        return "viewstock";
    }

    @GetMapping("/showAddStockForm")
    public String showAddStockForm(Stock stock, Model model){
        model.addAttribute("drugs", drugItemsService.getAllDrugs());
        return "addstock";
    }

    @PostMapping("/addNewStock")
    public String addNewStock(@Valid Stock stock, BindingResult result, Model model){
        if(result.hasErrors()){
            return  "addstock";
        }
        stockService.addStock(stock);
        return "redirect:/viewStock";
    }

    @GetMapping("/showUpdateStock/{id}")
    public String showEditStockForm(@PathVariable("id") Integer id, Model model){
        model.addAttribute("stock", stockService.getStockByID(id));
        return "editstock";
    }

    @PostMapping("/updateStock/{id}")
    public String updateStock(@PathVariable ("id") Integer id, @Valid Stock stock, BindingResult result, Model model){
        if(result.hasErrors()){
            stock.setStockID(id);
            model.addAttribute("stock", stock);
            return "editstock";
        }
        Optional<Stock> stock1 = stockService.updateStock(id, stock);
        return "redirect:/viewCategories";
    }


    @GetMapping("/deleteStock/{id}")
    public String deleteCategory(@PathVariable ("id") Integer id, Model model) {
        stockService.deleteStock(id);
        return "redirect:/viewCategories";
    }

    @GetMapping("/viewStockDetailsByDrug")
    public String getAllDetailsOfStock(Model model, Stock stock){
        //model.addAttribute("brand", brandService.getAllBrands());
        model.addAttribute("stock", stockService.getAllDetailsOfStock());
        return "sales";
    }

    @GetMapping("/GetStockQty/{id}")
    public void getStockQty(Model model, @PathVariable("id") Integer id){
        model.addAttribute("stocks", stockService.getStockByID(id));
    }

    @PostMapping("/updateStockQty/id")
    public String updateStockQty(@PathVariable ("id") Integer id, @Valid Stock stock, BindingResult result, Model model){
        if(result.hasErrors()){
            stock.setStockID(id);
            model.addAttribute("stock",stock);
            return  "sales";
        }
        Optional<Stock> stock1 = stockService.reduceStockQty(id, stock.getQty());
        return "redirect:/viewStockDetailsByDrug";
    }

//    @PostMapping("/addNewInvoice")
//    public String addNewInvoice(@Valid Invoice invoice, BindingResult result, Model model){
//        //model.addAttribute("invoice", invoice);
//        if(result.hasErrors()){
//           // model.addAttribute("invoice", invoice);
//            return  "sales";
//        }
//        invoiceService.addInvoice(invoice);
//        return "redirect:/viewStockDetailsByDrug";
//    }

}
