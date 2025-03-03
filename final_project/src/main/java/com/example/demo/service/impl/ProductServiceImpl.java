package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}
	
	@Override
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id).get();
	}
	
	@Override
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public boolean existsByProductName(String productName) {
        // Implement the logic to check if a product with the given name exists
        return productRepo.existsByProductName(productName);
    }
	
	@Override
    public Product getProductByProductName(String productName) {
        return productRepo.findByProductName(productName);
    }
}
