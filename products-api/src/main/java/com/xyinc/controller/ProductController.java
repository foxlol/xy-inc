package com.xyinc.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.xyinc.model.Product;
import com.xyinc.service.ProductService;

/**
 * 
 * Controller REST para acesso ao recurso de produtos.
 * 
 * @author diogenes.feijo
 *
 */
@RestController
@RequestMapping(path = "/products", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	/**
	 * Obtém todos os produtos cadastrados.
	 * 
	 * @return Resposta HTTP com todos os produtos cadastrados
	 */
	@RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
	public ResponseEntity<Collection<Product>> getAllProducts() {

		return ResponseEntity.ok().body(this.productService.getAllProducts());
	}
	
	/**
	 * Obtém um produto cadastrado pelo seu ID.
	 * 
	 * @param id - identificador do produto
	 * 
	 * @return Resposta HTTP com o produto obtido
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Integer id) {
		
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
	
	/**
	 * Cria um produto
	 * 
	 * @param product - produto a ser criado
	 * 
	 * @return Resposta HTTP com o produto criado
	 * 
	 * @throws URISyntaxException erro na sintaxe da URI do produto criado
	 */
	@RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product product, UriComponentsBuilder uriComponentsBuilder) throws URISyntaxException {
		
		product = this.productService.createProduct(product);
		
		URI createdProductURI = 
			uriComponentsBuilder.path("/products/{id}")
								.buildAndExpand(product.getId())
								.toUri();
		
		return ResponseEntity.created(createdProductURI).body(product);
	}
	
	/**
	 * Atualiza um produto
	 * 
	 * @param id - id do produto a ser atualizado
	 * @param product - produto atualizado
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {

		this.productService.updateProduct(id, product);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Deleta um produto
	 * 
	 * @param id - id do produto a ser deletado
	 */
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id) {
		
		this.productService.deleteProduct(id);

		return ResponseEntity.noContent().build();
	}	
	
}
