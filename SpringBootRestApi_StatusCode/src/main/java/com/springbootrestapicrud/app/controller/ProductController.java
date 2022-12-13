package com.springbootrestapicrud.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapicrud.app.model.Product;
import com.springbootrestapicrud.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController 
{
	@Autowired
	ProductService ps;

	// Post Api...
	@PostMapping(value = "/addProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p)
	{
		Product product=ps.saveProduct(p);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED); //Status Code :201 CREATED
	}
	
	 // Get Api...
	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<Iterable<Product>>  getAllProduct()
	{
	
		Iterable<Product> product=ps.getAllProduct();
		
		return new ResponseEntity<Iterable<Product>>(product,HttpStatus.OK); //Status Code : 200 OK
	}
	
	// Put Api...
	@PutMapping(value = "/updateProductById/{productId}")
	public ResponseEntity<Product>  updateProduct(@PathVariable Long productId,@RequestBody Product p)
	{
		Product id=ps.getProductById(productId);
		if(id.getProductId()==productId)
		{
		Product product=ps. updateProduct(productId,p);
		return new ResponseEntity<Product>(product,HttpStatus.OK); //Status Code : 200 OK
		}
		else
		{
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	   // Delete Api...
		@DeleteMapping(value = "/deleteProductById/{productId}")
		public ResponseEntity<Product> deleteProduct(@PathVariable Long productId)
		{
		    ps. deleteProduct(productId);
			
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT );  //Status Code : 204 NO_CONTENT
		}
		
		@GetMapping(value = "/getProductById/{productId}")
		public ResponseEntity<Product> getProductById(@PathVariable Long productId) 
		{
			  Product p=ps.getProductById(productId);
			  	if(p!=null) {
			  		 return new ResponseEntity<Product>(p,HttpStatus.OK);	
			  	}
			  	else
			  {
			  		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			  		
			  	}
			  
			 
		}


}
