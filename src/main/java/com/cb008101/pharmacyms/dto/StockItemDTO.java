package com.cb008101.pharmacyms.dto;



public class StockItemDTO
{
    private Integer stockID;
    private Integer phItemID;
    private String itemName;
    private String mfDate;
    private String expDate;
    private Integer qty;
    private String rcvdDate;
    private Float itmPrice;

    public StockItemDTO(Integer qty) {
        this.qty = qty;
    }

    public StockItemDTO(Integer stockID, Integer phItemID, String itemName, String mfDate, String expDate, Integer qty, String rcvdDate, Float itmPrice) {
        this.stockID = stockID;
        this.phItemID = phItemID;
        this.itemName = itemName;
        this.mfDate = mfDate;
        this.expDate = expDate;
        this.qty = qty;
        this.rcvdDate = rcvdDate;
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

    public String getMfDate()
    {
        return mfDate;
    }

    public void setMfDate(String mfDate)
    {
        this.mfDate = mfDate;
    }

    public String getExpDate()
    {
        return expDate;
    }

    public void setExpDate(String expDate)
    {
        this.expDate = expDate;
    }

    public Integer getQty()
    {
        return qty;
    }

    public void setQty(Integer qty)
    {
        this.qty = qty;
    }

    public String getRcvdDate()
    {
        return rcvdDate;
    }

    public void setRcvdDate(String rcvdDate)
    {
        this.rcvdDate = rcvdDate;
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
