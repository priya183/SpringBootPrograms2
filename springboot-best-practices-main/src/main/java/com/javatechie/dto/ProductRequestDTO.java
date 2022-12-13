package com.javatechie.dto;


import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductRequestDTO {

    @NotBlank(message = "product name shouldn't be NULL OR EMPTY")
    private String name;

    private String description;

    @NotBlank(message = "product type shouldn't be NULL OR EMPTY")
    private String productType;

    @Min(value = 1,message = "quantity is not defined !")
    private int quantity;

    @Min(value = 200, message = "product price can't be less than 200")
    @Max(value = 500000, message = "product price can't be more than 5000")
    private double price;

    private String supplierName;

    @NotBlank(message = "supplier code shouldn't be NULL OR EMPTY")
    private String supplierCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public ProductRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductRequestDTO(@NotBlank(message = "product name shouldn't be NULL OR EMPTY") String name,
			String description, @NotBlank(message = "product type shouldn't be NULL OR EMPTY") String productType,
			@Min(value = 1, message = "quantity is not defined !") int quantity,
			@Min(value = 200, message = "product price can't be less than 200") @Max(value = 500000, message = "product price can't be more than 5000") double price,
			String supplierName, @NotBlank(message = "supplier code shouldn't be NULL OR EMPTY") String supplierCode) {
		super();
		this.name = name;
		this.description = description;
		this.productType = productType;
		this.quantity = quantity;
		this.price = price;
		this.supplierName = supplierName;
		this.supplierCode = supplierCode;
	}

	@Override
	public String toString() {
		return "ProductRequestDTO [name=" + name + ", description=" + description + ", productType=" + productType
				+ ", quantity=" + quantity + ", price=" + price + ", supplierName=" + supplierName + ", supplierCode="
				+ supplierCode + "]";
	}
    
    

}
