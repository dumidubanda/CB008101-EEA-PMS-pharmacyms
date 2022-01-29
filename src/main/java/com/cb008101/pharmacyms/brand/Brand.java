package com.cb008101.pharmacyms.brand;

import com.cb008101.pharmacyms.category.Category;

import javax.persistence.*;

@Entity
@Table(name = "tbl_pms_item_brand")
public class Brand implements java.io.Serializable {

    @Id
    @Column(name = "itm_brand_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer brandID;

    @Column(name = "itm_brand_name", length = 100, nullable = false)
    private String brandName;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id ", referencedColumnName = "category_id ")
    private Category category;

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

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }
}
