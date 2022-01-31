package com.cb008101.pharmacyms.pharmaitems;


import com.cb008101.pharmacyms.dto.ItemDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemsRepository extends CrudRepository<Items, Integer> {
    @Query(value = "SELECT new com.cb008101.pharmacyms.dto.ItemDTO(d.phItemID, d.drugName, b.brandID, b.brandName, c.categoryID , c.categoryName, d.fullQty, d.itmPrice) FROM Items d " +
            "JOIN Brand b ON d.brand = b " +
            "JOIN Category c ON d.category = c ", nativeQuery = false)
    List<ItemDTO> getAllDrugDetails();
}
