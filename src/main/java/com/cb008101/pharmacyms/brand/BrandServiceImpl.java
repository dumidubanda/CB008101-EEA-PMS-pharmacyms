package com.cb008101.pharmacyms.brand;


import com.cb008101.pharmacyms.dto.CategoryBrandDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService
{
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void saveBrand(Brand brand)
    {
        brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands()
    {
        List brandList = new ArrayList();
        brandRepository.findAll().forEach(brandList::add);
        return brandList;
    }


    @Override
    public void deleteBrand(Integer id)
    {
        brandRepository.deleteById(id);
    }

    @Override
    public Brand getBrandById(Integer id)
    {
        Optional<Brand> brd = Optional.ofNullable(
                brandRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid ID"))
        );
        Brand brand = brd.get();
        return brand;
    }

    @Override
    @Transactional
    public Optional<Brand> updateBrand(Brand brand, Integer id)
    {
        return brandRepository.findById(id).map(e ->
        {
            e.setBrandName(brand.getBrandName());
            return e;
        });
    }

    @Override
    public List<CategoryBrandDTO> getAllCategoryNames()
    {
        List<CategoryBrandDTO> brandList = new ArrayList<CategoryBrandDTO>();
        brandRepository.getAllBrandByCategory().forEach(brandList::add);
        return brandList;
    }
}
