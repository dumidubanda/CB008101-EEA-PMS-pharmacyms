package com.cb008101.pharmacyms.dto;

public class DrugDTO
{
    private Integer drugID;
    private String drugName;
    private Integer brandID;
    private String brandName;
    private Integer category_id;
    private String category_name;
    //    private Integer rackNo;
    private Integer fullQty;
    private Float itmPrice;

    public DrugDTO(Integer drugID, String drugName, Integer brandID, String brandName, Integer category_id, String category_name, Integer fullQty, Float itmPrice)
    {
        this.drugID = drugID;
        this.drugName = drugName;
        this.brandID = brandID;
        this.brandName = brandName;
        this.category_id = category_id;
        this.category_name = category_name;
//        this.rackNo = rackNo;
        this.fullQty = fullQty;
        this.itmPrice = itmPrice;
    }


//    public Integer getRackNo() {
//        return rackNo;
//    }
//
//    public void setRackNo(Integer rackNo) {
//        this.rackNo = rackNo;
//    }

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

