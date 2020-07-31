package com.anywhere.fitness.services;

import com.anywhere.fitness.FitnessApplication;
import com.anywhere.fitness.exceptions.ResourceNotFoundException;
import com.anywhere.fitness.models.Course;
import com.anywhere.fitness.models.User;
import com.anywhere.fitness.models.UserCourse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitnessApplication.class)
@WithMockUser(username = "admin", roles = {"ADMIN","USER"})
//@ContextConfiguration(classes=FitnessApplication.class, loader= AnnotationConfigContextLoader.class)
public class UserServiceImplTest
{
    @Autowired
    private UserService userService;


    @Before
    public void setUp()
            throws
            Exception
    {
        MockitoAnnotations.initMocks(this);

        List<User> userList = userService.findAllUsers();
        for(User u : userList){
            System.out.println("*User ID: "+u.getUserid()+" Username: "+u.getUsername()+" *");
        }
    }

    @After
    public void tearDown()
            throws
            Exception
    {
        System.out.println("***** AFTER *****");
        List<User> userList = userService.findAllUsers();
        for(User u : userList){
            System.out.println("*User ID: "+u.getUserid()+" Username: "+u.getUsername()+" *");
        }
    }

    @Test
    public void aa_save()
    {
        User u = new User("test_user","email@address1.com","password");
        userService.save(u);
        assertEquals(6, userService.findAllUsers().size());
    }
    @Test(expected = ResourceNotFoundException.class)
    public void ab_save_fail()
    {
        User u = new User("test_user","email@address1.com","password");
        u.setUserid(888);
        userService.save(u);
        assertEquals(6, userService.findAllUsers().size());
    }

    @Test
    public void ba_update()
    {
        User u = new User("test_userupdate","email@address1.com","password");
        userService.update(u,7);
        assertEquals("test_userupdate", userService.findById(7).getUsername());

    }
    @Test(expected = ResourceNotFoundException.class)
    public void bb_update_fail()
    {
        User u = new User("test_userupdate","email@address1.com","password");
        userService.update(u,777);
        assertEquals("test_userupdate", userService.findById(7).getUsername());

    }

    @Test
    public void ca_delete()
    {
        userService.delete(5);
        assertEquals(5, userService.findAllUsers().size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void cb_delete_fail()
    {
        userService.delete(777);
        assertEquals(5, userService.findAllUsers().size());
    }


    @Test
    public void da_findUserByName()
    {
        User u = userService.findUserByName("test_puttat");

        assertEquals("test_puttat",u.getUsername());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void db_findUserByName_fail()
    {
        User u = userService.findUserByName("test_potato");

        assertEquals("test_potato",u.getUsername());
    }

    @Test
    public void z_findAllUsers()
    {
        List<User> ul = userService.findAllUsers();
        assertEquals(5, ul.size());
    }

    @Test
    public void addUserCourse()
    {
    }

    @Test
    public void z_deleteAll()
    {
    }
}