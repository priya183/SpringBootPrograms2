package com.springbootrestapicrud.app.service;

import com.springbootrestapicrud.app.model.Product;

public interface ProductService {

	public Product saveProduct(Product p);

	public Iterable<Product> getAllProduct();

	public Product updateProduct(Long productId, Product p);

    public void deleteProduct(Long productId);

	public Product getProductById(Long productId);

	

}
