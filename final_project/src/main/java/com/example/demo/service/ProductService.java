package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	
	Product saveProduct(Product product);
	
	Product getProductById(Long id);
	Product updateProduct(Product product);
	boolean existsByProductName(String productName);
	
	Product getProductByProductName(String productName);
}
