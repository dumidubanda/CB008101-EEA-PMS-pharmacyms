package com.cb008101.pharmacyms.dto;



public class StockDrugDTO {
    private Integer stockID;
    private Integer drugID;
    private String drugName;
    private String mfDate;
    private String expDate;
    private Integer qty;
    private String rcvdDate;
    private Float itmPrice;

    public StockDrugDTO(Integer qty) {
        this.qty = qty;
    }

    public StockDrugDTO(Integer stockID, Integer drugID, String drugName, String mfDate, String expDate, Integer qty, String rcvdDate, Float itmPrice) {
        this.stockID = stockID;
        this.drugID = drugID;
        this.drugName = drugName;
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

    public Integer getDrugID()
    {
        return drugID;
    }

    public void setDrugID(Integer drugID)
    {
        this.drugID = drugID;
    }

    public String getDrugName()
    {
        return drugName;
    }

    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
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
