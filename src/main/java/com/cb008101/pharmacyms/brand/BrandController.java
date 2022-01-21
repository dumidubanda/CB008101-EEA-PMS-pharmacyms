package com.cb008101.pharmacyms.brand;


import com.cb008101.pharmacyms.dto.BrandCatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController
{
    @Autowired
    BrandService brandService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveBrand")
    public void saveBand(@RequestBody Brand brand)
    {
        brandService.saveBrand(brand);
    }

    @RequestMapping("/getAllBrands")
    public List<Brand> getAllBrands()
    {
        return brandService.getAllBrands();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateBrand/{id}")
    public void updateBrand(@RequestBody Brand brand, @PathVariable Integer id)
    {
        brandService.updateBrand(brand, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBrand/{id}")
    public void deleteBrand(@PathVariable Integer id)
    {
        brandService.deleteBrand(id);
    }

    @GetMapping("/getAllByName")
    public List<BrandCatDTO> getAllCategory_names()
    {
        return brandService.getAllCategoryNames();
    }
}