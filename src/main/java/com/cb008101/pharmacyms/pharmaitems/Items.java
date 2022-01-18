package com.cb008101.pharmacyms.pharmaitems;

import com.cb008101.pharmacyms.brand.Brand;
import com.cb008101.pharmacyms.category.Category;
//import com.cb008101.pharmacyms.racks.Rack;
//import com.cb008101.pharmacyms.suppliers.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "drugs_items")
public class Items implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "drug_id")
    private Integer drugID;

    @OneToOne(targetEntity = Brand.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "itm_brand_id", referencedColumnName = "itm_brand_id")
    private Brand brand;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id ", referencedColumnName = "category_id ")
    private Category category;

//    @OneToOne(targetEntity = Rack.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "rack_no", referencedColumnName = "rack_no")
//    private Rack rack;
//
//    @OneToOne(targetEntity = Supplier.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "sup_id", referencedColumnName = "sup_id")
//    private Supplier supplier;

    @Column(name = "drug_name", nullable = false)
    private String drugName;

    @Column(name = "full_quantity", nullable = false)
    private  Integer fullQty;

    @Column(name = "price", nullable = false)
    private Float itmPrice;

//    public Supplier getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Supplier supplier) {
//        this.supplier = supplier;
//    }


    public Integer getDrugID()
    {
        return drugID;
    }

    public void setDrugID(Integer drugID)
    {
        this.drugID = drugID;
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

    public String getDrugName()
    {
        return drugName;
    }

    public void setDrugName(String drugName)
    {
        this.drugName = drugName;
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
