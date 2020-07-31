package com.anywhere.fitness.controllers;

import com.anywhere.fitness.models.*;
import com.anywhere.fitness.services.SecurityUserServiceImpl;
import com.anywhere.fitness.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.annotation.SecurityTestExecutionListeners;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserControllerTest.class)
@WithMockUser(username = "admin", roles = {"ADMIN","USER"})
public class UserControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @MockBean
    private List<User> userList;

    @MockBean
    private SecurityUserServiceImpl context;


    @Before
    public void setUp()
            throws
            Exception
    {
        MockitoAnnotations.initMocks(this);

        userList = userService.findAllUsers();
        for(User u : userList){
            System.out.println("*User ID: "+u.getUserid()+" Username: "+u.getUsername()+" *");
        }
    }

    @After
    public void tearDown()
            throws
            Exception
    {
    }

    @Test
    public void updateUser()
    {
    }

    @Test
    public void listAllUsers() throws
            Exception
    {
        String apiURL = "/users/users";
        Mockito.when(userService.findAllUsers()).thenReturn(userList);

        RequestBuilder request = MockMvcRequestBuilders.get(apiURL).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();
        String actualResult = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String expectedResult = mapper.writeValueAsString(userList);

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void deleteUser()
            throws
            Exception
    {
        String apiurl = "/users/user/{id}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(apiurl, 7)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void patchUser()
    {
    }
    @Test
    public void addCourse()
    {
    }
}