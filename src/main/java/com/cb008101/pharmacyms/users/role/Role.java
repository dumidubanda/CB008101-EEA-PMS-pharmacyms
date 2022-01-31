package com.cb008101.pharmacyms.users.role;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "roles")
@Data
public class Role
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 40, nullable = false, unique = true)
    private  String name;

    @Column(length = 150, nullable = false)
    private String description;

    //Constructors
    public Role()
    {

    }

    public Role(Integer id)
    {
        this.id = id;
    }

    public Role(String name)
    {
        this.name = name;
    }

    public Role(String name, String description)
    {
        this.name = name;
        this.description = description;
    }


    @Override
    public String toString()
    {
        return this.name;
    }



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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
