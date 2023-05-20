package com.hcl.dao;

/**
 * all copy rights reserved to user pravalika
 */
s
public interface ProductDAO {
	public void getAllProducts();

	public void getProductById(int productId);

	public void getProductByCategory(String Category);

	public void searchByProductName(String productName);

	public void totalAmount();

	public void profitByCategoryWise();

}
