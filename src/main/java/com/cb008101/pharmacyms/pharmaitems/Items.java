package com.cb008101.pharmacyms.pharmaitems;

import com.cb008101.pharmacyms.brand.Brand;
import com.cb008101.pharmacyms.category.Category;


import javax.persistence.*;

@Entity
@Table(name = "pharma_items")
public class Items implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pharma_item_id")
    private Integer phItemID;

    @OneToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "itm_brand_id", referencedColumnName = "itm_brand_id")
    private Brand brand;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id ", referencedColumnName = "category_id ")
    private Category category;


    @Column(name = "pharma_item_name", nullable = false)
    private String itemName;

    @Column(name = "item_total_qty", nullable = false)
    private  Integer itemQuantity;

    @Column(name = "price", nullable = false)
    private Float itmPrice;


    public Integer getPhItemID()
    {
        return phItemID;
    }

    public void setPhItemID(Integer phItemID)
    {
        this.phItemID = phItemID;
    }

    public Brand getBrand()
    {
        return brand;
    }

    public void setBrand(Brand brand)
    {
        this.brand = brand;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public String getItemName()
    {
        return itemName;
    }

    public void setItemName(String itemName)
    {
        this.itemName = itemName;
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
