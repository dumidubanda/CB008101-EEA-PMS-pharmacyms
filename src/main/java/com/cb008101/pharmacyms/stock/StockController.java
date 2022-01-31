package com.cb008101.pharmacyms.stock;


import com.cb008101.pharmacyms.dto.StockItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController
{

    @Autowired
    private StockService stockService;

    @RequestMapping(method = RequestMethod.POST, value = "/addStock")
    public void addStock(@RequestBody Stock stock)
    {
        stockService.addStock(stock);
    }

    @RequestMapping("/getAllStocks")
    public List<Stock> getAllStock()
    {
        return stockService.getAllStocks();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateStock/{id}")
    public void updateStock(@PathVariable Integer id, @RequestBody Stock stock)
    {
        stockService.updateStock(id, stock);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteStock/{id}")
    public void deleteStock(@PathVariable Integer id)
    {
        stockService.deleteStock(id);
    }

    @GetMapping("/getAllStockDetails")
    public List<StockItemDTO> getAllStockDetails()
    {
        return stockService.getAllDetailsOfStock();
    }


}
