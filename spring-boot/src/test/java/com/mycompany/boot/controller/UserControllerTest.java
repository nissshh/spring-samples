package com.mycompany.boot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.mycompany.boot.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class UserControllerTest {
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
	public void testValidUser() throws Exception{
		String  testcontent = "{\"username\":\"test\",\"password\":\"test\"}";
		MockHttpServletRequestBuilder req = post("/user").contentType(expectedContentType).content(testcontent);
		this.mockMvc
			.perform(req)
			.andExpect(status().isOk())
			.andExpect(content().contentType(expectedContentType))
			.andExpect(jsonPath("$.firstname").value("TestUser"))
			.andExpect(jsonPath("$.lastname").value("TestSurname"))
			.andExpect(jsonPath("$.email").value("testemail@testserver.com"));
	}
	
	@Test
	public void testInValidUser() throws Exception{
		String  testcontent = "{\"username\":\"junk\",\"password\":\"hack\"}";
		MockHttpServletRequestBuilder req = post("/user").contentType(expectedContentType).content(testcontent);
		this.mockMvc
			.perform(req)
			.andExpect(status().isNotFound());
//			.andExpect(content().new String("{}"));
	}

}
