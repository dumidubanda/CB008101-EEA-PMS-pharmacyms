package com.cb008101.pharmacyms.web;


//import com.cb008101.pharmacyms.invoice.InvoiceService;
import com.cb008101.pharmacyms.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InvoiceWebController {

//    @Autowired
//    private InvoiceService invoiceService;

    @Autowired
    private StockService stockService;
}
