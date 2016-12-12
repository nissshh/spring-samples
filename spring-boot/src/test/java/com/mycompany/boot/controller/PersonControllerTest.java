/**
 * 
 */
package com.mycompany.boot.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.mycompany.boot.Application;

/**
 * @author NishantS
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class PersonControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MediaType expectedContentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	//@Sql("/test-schema.sql")
	public void setup() {
		Assert.assertNotNull(webApplicationContext);
		this.mockMvc = webAppContextSetup(webApplicationContext)
				//.apply(springSecurity())
				.build();	
		
	}

	@Test
	public void testPost() throws Exception {
		String testcontent = "{\r\n" + 
				"  \"isActive\": false,\r\n" + 
				"  \"balance\": 10000,\r\n" + 
				"  \"age\": 34,\r\n" + 
				"  \"name\": \"INTUSER\",\r\n" + 
				"  \"gender\": \"Male\",\r\n" + 
				"  \"company\": \"UnitTestInc.\",\r\n" + 
				"  \"email\": \"unittest@unittest.com\",\r\n" + 
				"  \"phone\": \"2222222222\",\r\n" + 
				"  \"address\": \"Some Address,San Francisco\",\r\n" + 
				"  \"about\": \"This is a Unit Test :)\"\r\n" + 
				"}";
		MockHttpServletRequestBuilder req = post("/person").contentType(expectedContentType).content(testcontent);
		this.mockMvc
			.perform(req)
			.andExpect(status().isOk())
			.andExpect(content().contentType(expectedContentType))
			.andExpect(jsonPath("$.name").value("INTUSER"))
			.andExpect(jsonPath("$.phone").value("2222222222"));
	}

	@Test
	public void testPut() throws Exception {
		String testcontent = "{\r\n" + 
				"  \"isActive\": false,\r\n" + 
				"  \"balance\": 10000,\r\n" + 
				"  \"age\": 34,\r\n" + 
				"  \"name\": \"INTUSER\",\r\n" + 
				"  \"gender\": \"Male\",\r\n" + 
				"  \"company\": \"UnitTestInc.\",\r\n" + 
				"  \"email\": \"unittest@unittest.com\",\r\n" + 
				"  \"phone\": \"11111111\",\r\n" + 
				"  \"address\": \"Some Address,San Francisco\",\r\n" + 
				"  \"about\": \"This is a Unit Test :)\"\r\n" + 
				"}";
		this.mockMvc
			.perform(put("/person").contentType(expectedContentType).content(testcontent))
			.andExpect(status().isOk())
			.andExpect(content().contentType(expectedContentType))
			.andExpect(jsonPath("$.name").value("INTUSER"));;
	}
	
	
	public void testDelete() throws Exception {
		this.mockMvc
			.perform(delete("/person/{id}"))
			.andExpect(status().isOk());
			//.andExpect(content().contentType(expectedContentType));
	}
	
	@Test
	@Timed(millis=1000)
	public void testGet() throws Exception {
		this.mockMvc
			.perform(get("/person/{name}","INTUSER").accept(expectedContentType)) //create request
			.andDo(log()) //debug response
			.andExpect(status().isOk()) //verify http status
			.andExpect(content().contentType(expectedContentType)) //verify content type
			.andExpect(jsonPath("$.name").value("INTUSER")); //verify results
	}
	
	
	@Test
	public void testGetAll() throws Exception {
		this.mockMvc
			.perform(get("/person"))
			.andDo(log())
			.andExpect(status().isOk())
			.andExpect(content().contentType(expectedContentType)); //verify content type
	}

}
