package com.cb008101.pharmacyms.user;

import com.cb008101.pharmacyms.users.role.Role;
import com.cb008101.pharmacyms.users.user.User;
import com.cb008101.pharmacyms.users.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests
{
    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    //Testing with Admin Role
    @Test
    public void testCreateNewUserWithOneRole()
    {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User userDB = new User("dumidu@gmail.com", "pass", "Dumidu", "Bandara");
        userDB.addRole(roleAdmin);

        User savedUser = repo.save(userDB);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    //Testing Multiple roles for one user
    @Test
    public void testCreateNewUserWithTwoRoles()
    {
        User userBM = new User("db@gmail.com", "123", "db", "db");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);

        userBM.addRole(roleEditor);
        userBM.addRole(roleAssistant);

        User savedUser = repo.save(userBM);

        assertThat(savedUser.getId()).isGreaterThan(0);
    }


    @Test
    public void testListAllUsers()
    {
        Iterable<User> listUsers = repo.findAll();
        listUsers.forEach(user -> System.out.println(user));
    }

    //Test get user by ID
    @Test
    public void testGetUserById()
    {
        User userDB = repo.findById(1).get();
        System.out.println(userDB);
        assertThat(userDB).isNotNull();
    }

    //Test update user details
    @Test
    public void testUpdateUserDetails()
    {
        User userDB = repo.findById(1).get();
        userDB.setEnabled(false);
        userDB.setEmail("badanbanda@gmail.com");

        repo.save(userDB);
    }


    @Test
    public void testUpdateUserRoles()
    {
        User userBM = repo.findById(2).get();
        Role roleEditor = new Role(3);
        Role roleSalesperson = new Role(2);

        userBM.getRoles().remove(roleEditor);
        userBM.addRole(roleSalesperson);

        repo.save(userBM);
    }


    @Test
    public void testDeleteUser()
    {
        Integer userId = 2;
        repo.deleteById(userId);

    }


//	@Test
//	public void testGetUserByEmail() {
//		String email = "ravi@gmail.com";
//		User user = repo.getUserByEmail(email);
//
//		assertThat(user).isNotNull();
//	}
//
//	@Test
//	public void testCountById() {
//		Integer id = 1;
//		Long countById = repo.countById(id);
//
//		assertThat(countById).isNotNull().isGreaterThan(0);
//	}
//
//	@Test
//	public void testDisableUser() {
//		Integer id = 1;
//		repo.updateEnabledStatus(id, false);
//
//	}
//
//	@Test
//	public void testEnableUser() {
//		Integer id = 3;
//		repo.updateEnabledStatus(id, true);
//
//	}
//
//	@Test
//	public void testListFirstPage() {
//		int pageNumber = 0;
//		int pageSize = 4;
//
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		Page<User> page = repo.findAll(pageable);
//
//		List<User> listUsers = page.getContent();
//
//		listUsers.forEach(user -> System.out.println(user));
//
//		assertThat(listUsers.size()).isEqualTo(pageSize);
//	}
//
//	@Test
//	public void testSearchUsers() {
//		String keyword = "bruce";
//
//		int pageNumber = 0;
//		int pageSize = 4;
//
//		Pageable pageable = PageRequest.of(pageNumber, pageSize);
//		Page<User> page = repo.findAll(keyword, pageable);
//
//		List<User> listUsers = page.getContent();
//
//		listUsers.forEach(user -> System.out.println(user));
//
//		assertThat(listUsers.size()).isGreaterThan(0);
//	}
}
