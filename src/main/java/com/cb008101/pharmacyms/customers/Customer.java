package com.cb008101.pharmacyms.customers;

import javax.persistence.*;

@Entity
@Table(name = "tbl_customer")
public class Customer implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "customer_name", nullable = false)
    private String name;

    @Column(name = "customer_phone", nullable = false)
    private String mobile;

    @Column(name = "customer_email", nullable = false)
    private String email;

//        @OneToOne(targetEntity = CustomerLogin.class, cascade = CascadeType.ALL)
//        @JoinColumn(name="customer_id", referencedColumnName = "customer_login_id")
//        private CustomerLogin customerLogin;

    @OneToOne(targetEntity = CustomerLogin.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_login_id")
    private CustomerLogin customerLogin;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public CustomerLogin getCustomerLogin()
    {
        return customerLogin;
    }

    public void setCustomerLogin(CustomerLogin customerLogin)
    {
        this.customerLogin = customerLogin;
    }
}