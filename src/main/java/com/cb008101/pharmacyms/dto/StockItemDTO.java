package com.cb008101.pharmacyms.dto;



public class StockItemDTO
{
    private Integer stockID;
    private Integer phItemID;
    private String itemName;
    private String manuFacDate;
    private String expireDate;
    private Integer stockQuantity;
    private String stockRecievedDate;
    private Float itmPrice;

    public StockItemDTO(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public StockItemDTO(Integer stockID, Integer phItemID, String itemName, String manuFacDate, String expireDate, Integer stockQuantity, String stockRecievedDate, Float itmPrice) {
        this.stockID = stockID;
        this.phItemID = phItemID;
        this.itemName = itemName;
        this.manuFacDate = manuFacDate;
        this.expireDate = expireDate;
        this.stockQuantity = stockQuantity;
        this.stockRecievedDate = stockRecievedDate;
        this.itmPrice = itmPrice;
    }

    public Integer getStockID()
    {
        return stockID;
    }

    public void setStockID(Integer stockID)
    {
        this.stockID = stockID;
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

    public String getManuFacDate()
    {
        return manuFacDate;
    }

    public void setManuFacDate(String manuFacDate)
    {
        this.manuFacDate = manuFacDate;
    }

    public String getExpireDate()
    {
        return expireDate;
    }

    public void setExpireDate(String expireDate)
    {
        this.expireDate = expireDate;
    }

    public Integer getStockQuantity()
    {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }

    public String getStockRecievedDate()
    {
        return stockRecievedDate;
    }

    public void setStockRecievedDate(String stockRecievedDate)
    {
        this.stockRecievedDate = stockRecievedDate;
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
