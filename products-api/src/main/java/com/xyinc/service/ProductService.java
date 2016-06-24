package com.xyinc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.xyinc.model.Product;
import com.xyinc.repository.ProductRepository;

/**
 * Serviço para manipulação de produtos.
 * 
 * @author diogenes.feijo
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Obtém todos os produtos cadastrados.
	 * 
	 * @return todos os produtos cadastrados
	 */
	@Transactional(readOnly = true)
	public Collection<Product> getAllProducts() {

		return Lists.newArrayList(this.productRepository.findAll());
	}
	
	/**
	 * Obtem um produto pelo seu ID.
	 * 
	 * @param id - id do produto
	 * 
	 * @return produto obtido
	 */
	@Transactional(readOnly = true)
	public Product getProductById(Integer id) {
		
		return this.productRepository.findOne(id);
	}
	
	/**
	 * Cria um produto.
	 * 
	 * @param product - produto a ser criado
	 * 
	 * @return produto criado
	 */
	@Transactional
	public Product createProduct(Product product) {
				
		return this.productRepository.save(product);		
	}
	
	/**
	 * Atualiza um produto existente.
	 * 
	 * @param id - id do produto
	 * @param updatedProduct - produto atualizado
	 */
	@Transactional
	public void updateProduct(Integer id, Product updatedProduct) {
		
		Product productForUpdate = this.productRepository.findOne(id);
		
		if (productForUpdate == null) {
			
			throw new RuntimeException("Produto inexistente");
		}
		
		productForUpdate.setName(updatedProduct.getName());
		productForUpdate.setDescription(updatedProduct.getDescription());
		productForUpdate.setPrice(updatedProduct.getPrice());
		productForUpdate.setCategory(updatedProduct.getCategory());
		
		this.productRepository.save(productForUpdate);
	}
	
	/**
	 * Deleta um produto.
	 * 
	 * @param id - id do produto
	 */
	@Transactional
	public void deleteProduct(Integer id) {
		
		this.productRepository.delete(id);
	}
	
}
