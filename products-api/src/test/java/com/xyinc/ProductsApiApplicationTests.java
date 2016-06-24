package com.xyinc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.xyinc.application.ProductApiApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProductApiApplication.class)
@WebAppConfiguration
public class ProductsApiApplicationTests {

	@Test
	public void contextLoads() {
	}

}
