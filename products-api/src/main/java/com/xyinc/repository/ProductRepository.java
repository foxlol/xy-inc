package com.xyinc.repository;

import org.springframework.data.repository.CrudRepository;

import com.xyinc.model.Product;

/**
 * Repositório de dados de produtos.
 * 
 * @author diogenes.feijo
 *
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
