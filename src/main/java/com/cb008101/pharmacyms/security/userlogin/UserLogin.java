package com.cb008101.pharmacyms.security.userlogin;

import javax.persistence.*;

@Entity
@Table(name = "login_table")
public class UserLogin
{
        @Id
        @Column(name = "login_id", nullable = false)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(name = "login_name", nullable = false)
        private String userName;

        @Column(name = "login_pass", nullable = false)
        private String password;

        @Column(name = "login_status", nullable = false)
        private boolean status;

        @Column(name = "login_roles", nullable = false)
        private String roles;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean isStatus()
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public String getRoles()
    {
        return roles;
    }

    public void setRoles(String roles)
    {
        this.roles = roles;
    }
}
