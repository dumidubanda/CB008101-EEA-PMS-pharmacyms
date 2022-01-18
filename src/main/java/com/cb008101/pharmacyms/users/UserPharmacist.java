package com.cb008101.pharmacyms.users;

import com.cb008101.pharmacyms.security.userlogin.UserLogin;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pharmacist")
public class UserPharmacist
{
    @Id
    @Column(name = "pID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pID;

    @NotBlank(message = "Name cannot be empty")
    @Column(name = "p_name", length = 100, nullable = false)
    private String pName;

    @Column(name = "p_username", length = 50, nullable = false)
    private String pEmail;

    @OneToOne(targetEntity = UserLogin.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pID", referencedColumnName = "user_log_id")
    private UserLogin userLogin;

    public UserPharmacist() {
    }

    public UserPharmacist(@NotBlank(message = "Name cannot be empty") String pName, String pEmail, UserLogin userLogin) {
        this.pName = pName;
        this.pEmail = pEmail;
        this.userLogin = userLogin;
    }

    public Integer getpID() {
        return pID;
    }

    public void setpID(Integer pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public UserLogin getPharmacistLogin() {
        return userLogin;
    }

    public void setPharmacistLogin(UserLogin pharmacistLogin) {
        this.userLogin = pharmacistLogin;
    }
}
