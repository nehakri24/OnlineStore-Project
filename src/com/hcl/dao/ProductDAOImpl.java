package com.hcl.dao;

/**
 * all copy rights reserved to user pravalika 
 */

import com.hcl.pojo.Item;
import com.hcl.ui.StoreInformation;

public class ProductDAOImpl implements ProductDAO {
	StoreInformation storeInformation;

	public ProductDAOImpl() {

	}

	public ProductDAOImpl(StoreInformation storeInformation) {
		super();
		this.storeInformation = storeInformation;
	}

	/**
	 * method to get all products
	 */
	@Override
	public void getAllProducts() {
		System.out.println("*******");
		for (Item items : storeInformation.getItems()) {
			System.out.println("Product[productId=" + items.getProductId() + ", productName=" + items.getProductName()
					+ ", sellingPrice=" + items.getSellingPrice() + ",availableQuantity=" + items.getAvailableQuantity()
					+ ", category=" + items.getCategory() + "]");
		}
		System.out.println("**********");
	}

	/**
	 * method to get product by productId
	 */
	@Override
	public void getProductById(int productId) {
		Item item = storeInformation.getProductById(productId);
		if (item == null) {
			System.out.println("no product found with mentioned id");
		} else {
			System.out.println(item);
		}
	}

	/**
	 * method to get product by category
	 */
	@Override
	public void getProductByCategory(String category) {
		Item[] items = storeInformation.getProductByCategory(category);
		if (items == null) {
			System.out.println("no product with mentioned category found");
		}
		System.out.println("**********");
	}

	/**
	 * method to search by product name
	 */
	@Override
	public void searchByProductName(String productName) {
		Item[] items = storeInformation.searchByProductName(productName);
		if (items == null) {
			System.out.println("no category with the mentioned category found");
		}
		System.out.println("********");
	}

	@Override
	public void totalAmount() {
		System.out.println("*******\n" + storeInformation.totalAmount() + "\n*******");
	}

	/**
	 * method to get profit by categoryWise
	 */
	@Override
	public void profitByCategoryWise() {
		storeInformation.profitByCategoryWise();
	}

}
