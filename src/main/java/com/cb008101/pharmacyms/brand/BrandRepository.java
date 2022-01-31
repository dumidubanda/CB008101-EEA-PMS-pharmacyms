package com.cb008101.pharmacyms.brand;


import com.cb008101.pharmacyms.dto.BrandCategoryDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BrandRepository extends  CrudRepository<Brand, Integer>{
    @Query(value = "SELECT new com.cb008101.pharmacyms.dto.BrandCategoryDTO(b.brandID, b.brandName, c.categoryID , c.categoryName) FROM Brand b JOIN Category c ON b.category = c", nativeQuery = false)
    List<BrandCategoryDTO> getAllBrandByCategory();
}
