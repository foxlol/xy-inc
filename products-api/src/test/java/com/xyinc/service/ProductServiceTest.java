package com.xyinc.service;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.xyinc.GenericTest;
import com.xyinc.exception.InvalidProductException;
import com.xyinc.exception.ProductNotFoundException;
import com.xyinc.model.Product;

@DatabaseSetup("classpath:datasets/service/productServiceTest.xml")
public class ProductServiceTest extends GenericTest {

	@Autowired
	private ProductService productService;
	
	@Test
	public void testGetAllProducts() {
		
		Collection<Product> products = productService.getAllProducts();
		
		Assert.assertNotNull("Lista de produtos nula", products);
		Assert.assertTrue("Lista com quantidade menor do que esperada", products.size() == 2);
	}
	
	@Test
	public void testGetProductById() throws ProductNotFoundException {
		
		final Integer expectedProductId = 1;
		
		Product product = productService.getProductById(expectedProductId);
		
		Assert.assertNotNull("Produto nulo", product);
		Assert.assertTrue("ID do produto é diferente", product.getId().equals(expectedProductId));
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void testGetInexistentProduct() throws ProductNotFoundException {
		
		final Integer expectedProductId = 3;
		
		productService.getProductById(expectedProductId);
	}
	
	@Test
	public void testCreateProduct() throws ProductNotFoundException, InvalidProductException {
		
		Product product = new Product("nome", "descrição", 145.10f, "categoria");
		
		product = productService.createProduct(product);
		
		Assert.assertNotNull("Produto nulo", product);
		Assert.assertNotNull("ID do produto nulo", product.getId());
	}
	
	@Test(expected = InvalidProductException.class)
	public void testCreateInvalidProduct() throws ProductNotFoundException, InvalidProductException {

		productService.createProduct(null);
	}
	
	@Test
	public void testDeleteProduct() throws ProductNotFoundException {
	
		final Integer expectedProductId = 1;
		
		productService.deleteProduct(expectedProductId);
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void testDeleteInexistentProduct() throws ProductNotFoundException {

		productService.deleteProduct(3);
	}
	
}
