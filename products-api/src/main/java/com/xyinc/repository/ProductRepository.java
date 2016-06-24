package com.xyinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyinc.model.Product;

/**
 * Repositório de dados de produtos.
 * 
 * @author diogenes.feijo
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
