package com.cafe24.gg;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

		Product first = new Product( null , "더미데이터 삽입", true, 1234L, 1582937L );
		adminService.addItem(first);
		
		
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
		Product mockVO = new Product( null , "물품타이틀제목1", true, 1L, 100000L );

		ResultActions action = mockMVC.perform(post("/api/admin/product/add")
												.contentType(MediaType.APPLICATION_JSON)
												.content(new Gson().toJson(mockVO)))
												.andExpect(status().isOk()).andDo(print());
		
		action.andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void 어드민_상품_수정() throws Exception {
		// Long paramNo = 1L;
		// Product mock = adminService.getProductItem(paramNo).get();
		// assertTrue(mock.isPresent());
		// adminService.editItem(edited);

		Product paramItem = new Product(1L, "물품1", false, 1L, 10000L);
		// form을 통해 전달되는 Product 데이터
		

		ResultActions action = mockMVC.perform(post("/api/admin/product/edit")
											.contentType(MediaType.APPLICATION_JSON)
											.content(new Gson().toJson(paramItem)))
											.andExpect(status().isOk()).andDo(print());

		action.andExpect(jsonPath("$.data.title", is("수정된상품타이틀")));
	}
	

}
