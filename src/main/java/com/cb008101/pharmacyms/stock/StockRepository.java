package com.cb008101.pharmacyms.stock;


import com.cb008101.pharmacyms.dto.StockDrugDTO;
import com.cb008101.pharmacyms.stock.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Integer> {

    @Query(value = "SELECT new com.cb008101.pharmacyms.dto.StockDrugDTO(s.stockID, d.drugID, d.drugName, s.mfDate, s.expDate, s.qty, s.rcvdDate, d.itmPrice) FROM Stock s" +
            " JOIN Items d ON s.items = d", nativeQuery = false)
    List<StockDrugDTO> getAllStockDetails();

}
