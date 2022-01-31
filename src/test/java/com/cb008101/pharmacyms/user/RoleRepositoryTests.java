package com.cb008101.pharmacyms.user;

import com.cb008101.pharmacyms.users.role.Role;
import com.cb008101.pharmacyms.users.role.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests
{

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole()
    {
        Role roleAdmin = new Role("Admin", "Do everything");
        Role savedRole = repo.save(roleAdmin);

        assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles()
    {
        Role roleSalesperson = new Role("Sales Manager", "Manage product prices, "
                + "Customers, Reports, Shipping, Orders,  ");

        Role roleEditor = new Role("Web Site Editor", "Manage categories, brands, "
                + "Products");

        Role roleShipper = new Role("Shipper", "View orders, View products,  "
                + " Update order status");

        //Role roleAssistant = new Role("Assistant", "Manage Q & A");

        Role rolePharmacists = new Role("Pharmacists", "Manage pharmaceutical items, Sell products,"
                + " Dispense Medications, Counsel patients, Advise patients about general health topics   ");

        repo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, rolePharmacists));
    }
}

