package com.cb008101.pharmacyms.customers;

import javax.persistence.*;

@Entity
@Table(name = "tbl_customer_login")
public class CustomerLogin
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_login_id", nullable = false)
    private Integer id;

    @Column(name = "customer_login_name")
    private String username;

    @Column(name = "customer_login_passowrd")
    private String password;

    @Column(name = "customer_login_status")
    private int status;



    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}
