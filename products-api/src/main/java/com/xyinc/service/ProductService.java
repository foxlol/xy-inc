package com.xyinc.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyinc.exception.InvalidProductException;
import com.xyinc.exception.ProductNotFoundException;
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

		return this.productRepository.findAll();
	}
	
	/**
	 * Obtem um produto pelo seu ID.
	 * 
	 * @param id - id do produto
	 * 
	 * @return produto obtido
	 * 
	 * @throws ProductNotFoundException produto não encontrado
	 */
	@Transactional(readOnly = true)
	public Product getProductById(Integer id) throws ProductNotFoundException {
		
		Product product = this.productRepository.findOne(id);
		
		if (product == null) {
			
			throw new ProductNotFoundException();
		}
		
		return product;
	}
	
	/**
	 * Cria um produto.
	 * 
	 * @param product - produto a ser criado
	 * 
	 * @return produto criado
	 * 
	 * @throws InvalidProductException produto inválido
	 */
	@Transactional(rollbackFor = InvalidProductException.class)
	public Product createProduct(Product product) throws InvalidProductException {
		
		if (product == null) {
			
			throw new InvalidProductException();
		}
		
		try {
			
			return this.productRepository.save(product);
			
		} catch (DataIntegrityViolationException e) {
			
			throw new InvalidProductException();
		}
	}
	
	/**
	 * Atualiza um produto existente.
	 * 
	 * @param id - id do produto
	 * @param updatedProduct - produto atualizado
	 * 
	 * @return produto atualizado
	 * 
	 * @throws ProductNotFoundException produto não encontrado para atualização
	 * @throws InvalidProductException produto inválido
	 */
	@Transactional(rollbackFor = InvalidProductException.class)
	public Product updateProduct(Integer id, Product updatedProduct) throws ProductNotFoundException, InvalidProductException {
		
		Product productForUpdate = this.productRepository.findOne(id);
		
		if (productForUpdate == null) {
			
			throw new ProductNotFoundException();
		}
		
		if (updatedProduct == null) {
			
			throw new InvalidProductException();
		}
		
		productForUpdate.setName(updatedProduct.getName());
		productForUpdate.setDescription(updatedProduct.getDescription());
		productForUpdate.setPrice(updatedProduct.getPrice());
		productForUpdate.setCategory(updatedProduct.getCategory());
		
		try {
			
			return this.productRepository.saveAndFlush(productForUpdate);

		} catch (DataIntegrityViolationException e) {
			
			throw new InvalidProductException();
		}
	}
	
	/**
	 * Remove um produto.
	 * 
	 * @param id - id do produto
	 * 
	 * @throws ProductNotFoundException produto não encontrado para remoção
	 */
	@Transactional(rollbackFor = ProductNotFoundException.class)
	public void deleteProduct(Integer id) throws ProductNotFoundException {
		
		try {
			
			this.productRepository.delete(id);
			
		} catch (EmptyResultDataAccessException e) {

			throw new ProductNotFoundException();
		}
	}
	
}
