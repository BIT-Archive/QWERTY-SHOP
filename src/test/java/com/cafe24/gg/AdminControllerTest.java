package com.cafe24.gg;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cafe24.gg.Service.AdminService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

	private MockMvc mockMVC;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	public AdminService adminService;


	@Test
 	public void contextLoads() {
	}

	@Before
	public void setup(){
		mockMVC = MockMvcBuilders.webAppContextSetup(context)
								.build();
	}

	@Test
	public void 어드민_서비스(){
		assertNotNull(adminService);
	}

	@Test 
 	public void 어드민_상품_리스트_조회() throws Exception {
		mockMVC.perform(get("/api/admin/product/list"))
		.andExpect(status().isOk()).andDo(print());
	}

}
