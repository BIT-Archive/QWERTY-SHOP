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

import com.cafe24.gg.Service.AdminService;
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
public class AdminControllerTest {

	private MockMvc mockMVC;


	@Autowired
	private WebApplicationContext context;

	@Autowired
	public AdminService adminService;

	@Before
	public void setup(){
		mockMVC = MockMvcBuilders.webAppContextSetup(context)
								.build();

		Product dummy = new Product( null , "테스트용 물품", true, 1234L, 1582937L );
		adminService.addItem(dummy);
		
		
	}


	@Test
 	public void _0contextLoads() {
	}

	@Test
	public void _1어드민_서비스(){
		assertNotNull(adminService);
	}

	@Test 
  	public void _2어드민_상품_리스트_조회() throws Exception {
	
		ResultActions action =mockMVC.perform(get("/api/admin/product/list"))
								.andExpect(status().isOk()).andDo(print());
		
	}

	@Test
	public void _3어드민_상품_조회() throws Exception {
		
		ResultActions action = mockMVC.perform(get("/api/admin/product")
												.param("id", "1"))
												.andExpect(status().isOk()).andDo(print());

		action.andExpect(jsonPath("$.result", is("success")));
	}

	@Test
	public void _4어드민_상품_추가() throws Exception {
		Product mockVO = new Product( null , "물품타이틀제목1", true, 1L, 100000L );

		ResultActions action = mockMVC.perform(post("/api/admin/product")
												.contentType(MediaType.APPLICATION_JSON)
												.content(new Gson().toJson(mockVO)))
												.andExpect(status().isOk()).andDo(print());
		
		action.andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void _5어드민_상품_수정() throws Exception {
		// Long paramNo = 1L;
		// Product mock = adminService.getProductItem(paramNo).get();
		// assertTrue(mock.isPresent());
		// adminService.editItem(edited);

		Product paramItem = new Product(1L, "물품1", false, 1L, 10000L);
		// form을 통해 전달되는 Product 데이터
		

		ResultActions action = mockMVC.perform(put("/api/admin/product")
											.contentType(MediaType.APPLICATION_JSON)
											.content(new Gson().toJson(paramItem)))
											.andExpect(status().isOk()).andDo(print());

		action.andExpect(jsonPath("$.data.title", is("수정된상품타이틀")));
	}
	
	@Test
	public void _6어드민_상품_삭제() throws Exception{

		Long paramNo = 1L;

		ResultActions action = mockMVC.perform(delete("/api/admin/product")
											.contentType(MediaType.APPLICATION_JSON)
											.content(new Gson().toJson(paramNo)))
											.andExpect(status().isOk()).andDo(print());

		action.andExpect(jsonPath("$.result", is("fail")));

		assertFalse(adminService.getProductItem(paramNo).isPresent());
	}

}
