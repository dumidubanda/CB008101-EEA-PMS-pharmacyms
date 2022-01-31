package com.cb008101.pharmacyms.dto;

public class ItemDTO
{
    private Integer phItemID;
    private String itemName;
    private Integer brandID;
    private String brandName;
    private Integer categoryID;
    private String categoryName;
    private Integer fullQty;
    private Float itmPrice;

    public ItemDTO(Integer phItemID, String itemName, Integer brandID, String brandName, Integer categoryID, String categoryName, Integer fullQty, Float itmPrice)
    {
        this.phItemID = phItemID;
        this.itemName = itemName;
        this.brandID = brandID;
        this.brandName = brandName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.fullQty = fullQty;
        this.itmPrice = itmPrice;
    }

    public Integer getPhItemID()
    {
        return phItemID;
    }

    public void setPhItemID(Integer phItemID)
    {
        this.phItemID = phItemID;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
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

    public Integer getFullQty()
    {
        return fullQty;
    }

    public void setFullQty(Integer fullQty)
    {
        this.fullQty = fullQty;
    }

    public Float getItmPrice()
    {
        return itmPrice;
    }

    public void setItmPrice(Float itmPrice)
    {
        this.itmPrice = itmPrice;
    }
}

