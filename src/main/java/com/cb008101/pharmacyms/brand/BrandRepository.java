package com.cb008101.pharmacyms.brand;


import com.cb008101.pharmacyms.dto.BrandCatDTO;
import com.cb008101.pharmacyms.brand.Brand;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BrandRepository extends  CrudRepository<Brand, Integer>{
    @Query(value = "SELECT new com.cb008101.pharmacyms.dto.BrandCatDTO(b.brandID, b.brandName, c.category_id , c.category_name) FROM Brand b JOIN Category c ON b.category = c", nativeQuery = false)
    List<BrandCatDTO> getAllBrandByCategory();
}
