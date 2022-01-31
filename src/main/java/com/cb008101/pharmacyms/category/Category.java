package com.cb008101.pharmacyms.category;

import javax.persistence.*;

@Entity
@Table(name = "tbl_pms_category")
public class Category implements java.io.Serializable {

    @Id
    @Column(name = "category_id ")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryID ;

    @Column(name = "category_name", length = 60, nullable = false)
    private String categoryName;

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
}
