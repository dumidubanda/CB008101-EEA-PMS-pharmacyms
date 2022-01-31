package com.cb008101.pharmacyms.dto;

public class ItemDTO
{
    private Integer phItemID;
    private String itemName;
    private Integer brandID;
    private String brandName;
    private Integer categoryID;
    private String categoryName;
    private Integer itemQuantity;
    private Float itmPrice;

    public ItemDTO(Integer phItemID, String itemName, Integer brandID, String brandName, Integer categoryID, String categoryName, Integer itemQuantity, Float itmPrice)
    {
        this.phItemID = phItemID;
        this.itemName = itemName;
        this.brandID = brandID;
        this.brandName = brandName;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.itemQuantity = itemQuantity;
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

    public Integer getItemQuantity()
    {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity)
    {
        this.itemQuantity = itemQuantity;
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

