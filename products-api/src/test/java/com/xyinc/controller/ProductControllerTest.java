package com.xyinc.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xyinc.GenericTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;

@WebAppConfiguration
@DatabaseSetup("classpath:datasets/controller/productControllerTest.xml")
public class ProductControllerTest extends GenericTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
    	
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    
    @Test
    public void testGetProductById() throws Exception {

        this.mockMvc.perform(get("/products/1").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(status().isOk())
        			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(jsonPath("$.id").value(1));
    }   
    
    @Test
    public void testGetAll() throws Exception {

        this.mockMvc.perform(get("/products/").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(status().isOk())
        			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(jsonPath("$").isArray())
        			.andExpect(jsonPath("$", hasSize(2)));
    }
    
    @Test
    public void testCreateProduct() throws Exception {

        this.mockMvc.perform(
        			 post("/products/")
        			 	.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        				.content("{\"name\" : \"teste\",\"description\" : \"teste teste\",\"price\" : \"1500.10\", \"category\" : \"teste category\"}"))
        				.andExpect(status().isCreated())
        				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        				.andExpect(jsonPath("$.id").value(3));
    }
    
    @Test
    public void testUpdateProduct() throws Exception {

        this.mockMvc.perform(
        			 put("/products/1")
        			 	.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        				.content("{\"name\" : \"teste atualizado\",\"description\" : \"teste teste\",\"price\" : \"1500.10\", \"category\" : \"teste category\"}"))
        				.andExpect(status().isNoContent());
    }
    
    @Test
    public void testDeleteProduct() throws Exception {

        this.mockMvc.perform(delete("/products/1")
        			.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
        			.andExpect(status().isNoContent());
    }
	
}
