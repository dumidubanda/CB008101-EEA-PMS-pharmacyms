package com.cb008101.pharmacyms.brand;


import com.cb008101.pharmacyms.dto.BrandCategoryDTO;

import java.util.List;
import java.util.Optional;

public interface BrandService
{
    void saveBrand(Brand brand);

    List<Brand> getAllBrands();

    Optional<Brand> updateBrand(Brand brand, Integer id);

    void deleteBrand(Integer id);

    Brand getBrandById(Integer id);

    List<BrandCategoryDTO> getAllCategoryNames();
}
