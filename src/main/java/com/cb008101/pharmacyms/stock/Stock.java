package com.cb008101.pharmacyms.stock;

import com.cb008101.pharmacyms.pharmaitems.Items;

import javax.persistence.*;

@Entity
@Table(name = "tbl_pms_stock")
public class Stock implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stock_id")
    private Integer stockID;

    @OneToOne(targetEntity = Items.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharma_item_id", referencedColumnName = "pharma_item_id")
    private Items items;

    @Column(name = "manu_fac_date", nullable = false)
    private String manuFacDate;

    @Column(name = "exp_date", nullable = false)
    private String expireDate;

    @Column(name = "stock_quantity", nullable = false)
    private  Integer stockQuantity;

    @Column(name =  "stock_recieved_date", nullable = false)
    private String stockRecievedDate;


    public Integer getStockID() {
        return stockID;
    }

    public void setStockID(Integer stockID) {
        this.stockID = stockID;
    }

    public Integer getStockQuantity()
    {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }

//    public Items getDrugs() {
//        return items;
//    }
//
//    public void setDrugs(Items items) {
//        this.items = items;
//    }

    public Items getItems()
    {
        return items;
    }

    public void setItems(Items items)
    {
        this.items = items;
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

    public Integer getstockQuantity()
    {
        return stockQuantity;
    }

    public void setstockQuantity(Integer stockQuantity)
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
}
