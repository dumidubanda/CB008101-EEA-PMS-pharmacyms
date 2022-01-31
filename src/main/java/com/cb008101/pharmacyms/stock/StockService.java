package com.cb008101.pharmacyms.stock;


import com.cb008101.pharmacyms.dto.StockItemDTO;

import java.util.List;
import java.util.Optional;

public interface StockService
{
    void addStock(Stock stock);

    List<Stock> getAllStocks();

    Optional<Stock> updateStock(Integer id, Stock stock);


    Stock getStockByID(Integer id);


    void deleteStock(Integer id);

    List<StockItemDTO> getAllDetailsOfStock();

    Optional<Stock> reduceStockQty(Integer id, int stockQuantity);

}
