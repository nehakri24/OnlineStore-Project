package com.hcl.ui;

/**
 * all copy rights reserved to user pravalika 
 */
import com.hcl.pojo.Item;
import com.hcl.pojo.User;

public class StoreInformation {
	Item[] items = new Item[20];
	User[] users = new User[1];

	public String validateUser(String emailId, String password) {
		for (User user : users) {
			if (user.getEmailId().equals(emailId) && user.getPassword().equals(password)) {
				return user.getUserName();

			}
		}
		return null;
	}

	public void register(User registerUser) {
		users[0] = registerUser;
	}

	public void storeItems(Item[] items) {
		this.items = items;
	}

	public Item getProductById(int productId) {
		for (Item item : items) {
			if (item.getProductId() == productId) {
				return (item);
			}
		}
		return (null);

	}

	public Item[] getProductByCategory(String category) {
		Item[] itemsByCategory = new Item[10];
		int i = 0;
		System.out.println("*****");
		for (Item item : items) {
			if (item.getCategory().equalsIgnoreCase(category)) {
				itemsByCategory[i++] = item;
				System.out.println(item);
			}
		}
		if (i == 0)
			return null;
		return itemsByCategory;

	}

	public Item[] searchByProductName(String productName) {
		Item[] itemsByProductName = new Item[10];
		int i = 0;
		System.out.println("*****");
		for (Item item : items) {
			if (item.getProductName().equalsIgnoreCase(productName)) {
				itemsByProductName[i++] = item;
				System.out.println(item);

			}

		}
		if (i == 0)
			return null;
		return itemsByProductName;
	}

	public double totalAmount() {
		double total = 0.0;
		for (Item item : items) {
			total += (item.getBuyingPrice() * item.getAvailableQuantity());
		}
		return total;
	}

	public void profitByCategoryWise() {
		Item[] itemByCategory = new Item[10];
		int c = 0;
		System.out.println("*****");
		for (Item item : items) {
			boolean isAvailable = false;
			for (int i = 0; i < c; i++) {
				if (item.getCategory().equals(itemByCategory[i].getCategory())) {
					isAvailable = true;
					break;
				}
			}
			if (!isAvailable) {
				itemByCategory[c++] = item;
				System.out.println(
						"[category = " + item.getCategory() + ", profit = " + getProfit(item.getCategory()) + "]");
			}
		}
		System.out.println("*****");
	}

	private double getProfit(String category) {
		double profit = 0.0;
		for (Item item : items) {
			if (item.getCategory().equals(category)) {
				profit += (item.getSellingPrice() - item.getBuyingPrice()) * (item.getAvailableQuantity());
			}

		}
		return profit;
	}

	public Item[] getItems() {
		return this.items;

	}
}
