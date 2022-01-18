package com.cb008101.pharmacyms.category;

import javax.persistence.*;

@Entity
@Table(name = "tbl_pms_category")
public class Category implements java.io.Serializable {

    @Id
    @Column(name = "category_id ")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer category_id ;

    @Column(name = "category_name", length = 60, nullable = false)
    private String category_name;


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
}
