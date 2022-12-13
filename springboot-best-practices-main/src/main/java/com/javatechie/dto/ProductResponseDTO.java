package com.javatechie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponseDTO {
    private long id;
    private String name;
    private String desc;
    private String productType;
    private int quantity;
    private double price;
    private String supplierName;
    private String supplierCode;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public ProductResponseDTO(long id, String name, String desc, String productType, int quantity, double price,
			String supplierName, String supplierCode) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.productType = productType;
		this.quantity = quantity;
		this.price = price;
		this.supplierName = supplierName;
		this.supplierCode = supplierCode;
	}
	public ProductResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductResponseDTO [id=" + id + ", name=" + name + ", desc=" + desc + ", productType=" + productType
				+ ", quantity=" + quantity + ", price=" + price + ", supplierName=" + supplierName + ", supplierCode="
				+ supplierCode + "]";
	}
    
}
