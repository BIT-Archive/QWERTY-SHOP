package com.cafe24.gg;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cafe24.gg.Service.AdminService;
import com.cafe24.gg.Vo.Product;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Test
	public void 어드민_상품_추가() throws Exception {
		Product mockVO = new Product( 1L , "물품타이틀제목1", true, 1L, 100000L );

		ResultActions action = mockMVC.perform(post("/api/admin/product/add")
												.contentType(MediaType.APPLICATION_JSON)
												.content(new Gson().toJson(mockVO)))
												.andExpect(status().isOk()).andDo(print());
		
		action.andExpect(status().isOk()).andDo(print());

		assertNotNull(mockMVC);
	}

}
