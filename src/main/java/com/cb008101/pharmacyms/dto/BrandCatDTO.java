package com.cb008101.pharmacyms.dto;

public class BrandCatDTO {
    private Integer brandID;
    private String brandName;
    private Integer category_id;
    private String category_name;

    public BrandCatDTO(Integer brandID, String brandName, Integer category_id, String category_name) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.category_id = category_id;
        this.category_name = category_name;
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

    public Integer getCategory_id()
    {
        return category_id;
    }

    public void setCategory_id(Integer category_id)
    {
        this.category_id = category_id;
    }

    public String getCategory_name()
    {
        return category_name;
    }

    public void setCategory_name(String category_name)
    {
        this.category_name = category_name;
    }
}
