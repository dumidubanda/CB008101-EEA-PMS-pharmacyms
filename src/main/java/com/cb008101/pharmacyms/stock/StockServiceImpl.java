package com.cb008101.pharmacyms.stock;


import com.cb008101.pharmacyms.dto.StockItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService
{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public void addStock(Stock stock)
    {
        stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks()
    {
        List<Stock> stockList = new ArrayList<>();
        stockRepository.findAll().forEach(stockList::add);
        return stockList;
    }


    @Override
    @Transactional
    public Optional<Stock> updateStock(Integer id, Stock stock)
    {
        return stockRepository.findById(id).map(e ->
        {
            e.setItems(stock.getItems());
            e.setManuFacDate(stock.getManuFacDate());
            e.setExpireDate(stock.getExpireDate());
            e.setstockQuantity(stock.getstockQuantity());
            e.setStockRecievedDate(stock.getStockRecievedDate());
            return e;
        });
    }

    @Override
    public Stock getStockByID(Integer id)
    {
        Optional<Stock> stks = Optional.ofNullable(
                stockRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID not found"))
        );
        Stock stock = stks.get();
        return stock;
    }

    @Override
    public void deleteStock(Integer id)
    {
        stockRepository.deleteById(id);
    }

    @Override
    public List<StockItemDTO> getAllDetailsOfStock()
    {
        List<StockItemDTO> stockList = new ArrayList<StockItemDTO>();
        stockRepository.getAllStockDetails().forEach(stockList::add);
        return stockList;
    }

    @Override
    @Transactional
    public Optional<Stock> reduceStockQty(Integer id, int stockQuantity)
    {
        return stockRepository.findById(id).map(e ->
        {
            e.setstockQuantity(stockQuantity);
            return e;
        });
    }
}
