package com.cb008101.pharmacyms.stock;


import com.cb008101.pharmacyms.dto.StockItemDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, Integer> {

    @Query(value = "SELECT new com.cb008101.pharmacyms.dto.StockItemDTO(s.stockID, d.phItemID, d.itemName, s.manuFacDate, s.expireDate, s.stockQuantity, s.stockRecievedDate, d.itmPrice) FROM Stock s" +
            " JOIN Items d ON s.items = d", nativeQuery = false)
    List<StockItemDTO> getAllStockDetails();

}
