package com.cb008101.pharmacyms.dto;

public class BrandCategoryDTO
{
    private Integer brandID;
    private String brandName;
    private Integer categoryID;
    private String categoryName;

    public BrandCategoryDTO(Integer brandID, String brandName, Integer categoryID, String categoryName)
    {
        this.brandID = brandID;
        this.brandName = brandName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Integer getBrandID()
    {
        return brandID;
    }

    public void setBrandID(Integer brandID)
    {
        this.brandID = brandID;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public Integer getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID)
    {
        this.categoryID = categoryID;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
}
