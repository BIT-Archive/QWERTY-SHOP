package com.cafe24.gg.Controller;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cafe24.gg.Service.UserService;
import com.cafe24.gg.Vo.Product;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserControllerTest{
    
    private MockMvc mockMVC;

    @Autowired
    private WebApplicationContext context;
    
    @Autowired
    public UserService userService;

    @Before
    public void setup(){
        mockMVC = MockMvcBuilders.webAppContextSetup(context)
                                .build();
    }

    @Test
    public void _0contextLoads(){
    }

    @Test
    public void _1유저_서비스(){
        assertNotNull(userService);
    }

    @Test
    public void _2유저_로그인() throws Exception {
        ResultActions action = mockMVC.perform(get("/api/user/login"))
								.andExpect(status().isOk()).andDo(print());
    }

    


}