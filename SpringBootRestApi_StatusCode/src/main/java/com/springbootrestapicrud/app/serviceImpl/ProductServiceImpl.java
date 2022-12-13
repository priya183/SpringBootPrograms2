package com.springbootrestapicrud.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrestapicrud.app.model.Product;
import com.springbootrestapicrud.app.repository.ProductRepository;
import com.springbootrestapicrud.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService 
{

	@Autowired
	ProductRepository pr;
	
	@Override
	public Product saveProduct(Product p) {
		Product saveProduct=new Product();
		try
		{
			saveProduct=pr.save(p);
		}
		catch (Exception e) {
			System.out.println("Exception while adding Product");
		}
		System.out.println("Product Adding Successfully ");
		return saveProduct;
	}

	@Override
	public Iterable<Product> getAllProduct() {
	Iterable<Product> listproduct=null;
	try {
		listproduct=pr.findAll();
	}
	catch (Exception e) {
		System.out.println("Exception while getting Product");
	}
		return  listproduct;
	}

	@Override
	public Product updateProduct(Long productId, Product p) 
	{
		Optional<Product> op=pr.findById(productId);
		if(op.isPresent())
		{
			Product product=op.get();
			product.setProductName(p.getProductName());
			product.setProductPrice(p.getProductPrice());
			
			pr.save(product);
		}
		else
		{
			System.out.println("Product not available");
		}
		System.out.println("Product Updating Successfully ");
		return p;
	}

	@Override
	public void deleteProduct(Long productId) 
	{
		Product product=new Product();
		
		try{
			
			product=getProductById(productId);
			if(product !=null)
			{
				pr.deleteById(productId);
				
			}
		}
		catch (Exception e) {
			System.out.println("Exception while removing Employee");
		}
		System.out.println("Product deleted Successfully ");
	}

	@Override
	public Product getProductById(Long productId) 
	{
		Optional<Product> op=pr.findById(productId);
		if(op.isPresent())
		{
			  Product product=op.get();
			 return product;
		}
		else 
		{
			System.out.println("prodcut not availabe");
			return null;
		}
	}

}
