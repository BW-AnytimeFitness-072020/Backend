package com.anywhere.fitness.controllers;

import com.anywhere.fitness.FitnessApplication;
import com.anywhere.fitness.services.CourseService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitnessApplication.class)
@WithMockUser(username = "admin", roles = {"ADMIN", "DATA"})
public class CourseControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Before
    public void setUp() throws
            Exception {
        /*****
         * The following is needed due to security being in place!
         */
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();


    }

    @After
    public void tearDown() throws
            Exception
    {
    }

//    @Test
//    public void
}
