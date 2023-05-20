package com.hcl.ui;
import java.util.Scanner;
 
import com.hcl.dao.ProductDAOImpl;
import com.hcl.pojo.Item;
import com.hcl.pojo.User;
/**
 *main application with user interface for princi
 */
public class MainApplication {
	public static void main(String[] args) {
		
		StoreInformation storeInformation =new StoreInformation();
		User user = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our store Application");
		
		String userName;
		String emailId;
		String password;
		
		boolean isLogged = false;
		do {
			System.out.println("1.Login\n2. Register\n3. Exit");
			System.out.println(" Enter Your Choice : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Your Email ID : ");
				emailId = sc.nextLine();
				System.out.println("ENter Your Password");
				password = sc.nextLine();
				try {
					String loggedUserName = storeInformation.validateUser(emailId,password);
					if(loggedUserName == null) {
						System.out.println("Invalid Credentials Please Try Again");
					}
					else {
						isLogged = true;
						System.out.println("\nWelcome " + loggedUserName);
					}
				}
				catch(NullPointerException exception) {
					System.out.println("Invalid Credentials Please Try Again\n");
				}
				break;
				
			case 2:
			    System.out.println("Enter Your user Name : ");
			    userName=sc.nextLine();
			    System.out.println("Enter Your Email ID : ");
			    emailId=sc.nextLine();
			    System.out.println("Enter Your Password : ");
			    password=sc.nextLine();
			    user = new User(userName, emailId, password);
			    storeInformation.register(user);
			    System.out.println("Registration successful");
			    break;
			    
			case 3:
				System.out.println("Exiting");
				System.exit(0);
			default:
				System.out.println("*****Invalid Choice !!! Please try again*****");
				break;
			}
		}
		while(!isLogged);
		
		Item item1 = new Item(1, "Fruits", (30*0.5+30), 5, "Apples", "Grocery", 30);
		Item item2 = new Item(2, "Stationary Items", (20*0.5+20), 3, "Pencil", "Stationary", 20);
		Item item3 = new Item(3, "Fruits", (10*0.5+10), 4, "Banana", "Grocery", 10);
		Item item4 = new Item(4, "Stationary Items", (40*0.5+40), 2, "InkPot", "Stationary", 40);
		Item item5 = new Item(5, "Toiletry items", (10*0.5+10), 6, "Soap", "Toiletry", 10);
		  Item[] items = {item1, item2, item3, item4, item5};
		  storeInformation.storeItems(items);
			ProductDAOImpl productDAOImpl = new ProductDAOImpl(storeInformation);
		  
		  while(true) {
			  System.out.println(" 1. List the products in the store");
			  System.out.println("2. Search product by using product id");
			  System.out.println(" 3. List the products by Cateogory");
			  System.out.println("4. Search product By Using PRoduct Name ");
			  System.out.println(" 5. Total Amount Spent on Products");
			  System.out.println(" 6. Total profit Category Wise");
			  System.out.println("7. exit ");
			  System.out.println(" Enter your choice");
			 int choice =sc.nextInt();
			 switch(choice) {
			 case 1 :
				 productDAOImpl.getAllProducts();
				 break;
			 case 2 :
				 System.out.println("Enter Product Id to search");
				 int productId = sc.nextInt();
				 productDAOImpl.getProductById(productId);
				 break;
			 case 3 :
				 System.out.println("Enter Product Category to search");
				 sc.nextLine();
				 String category = sc.nextLine();
				 productDAOImpl.getProductByCategory(category);
				 break;
			 case 4:
				System.out.println("Enter Product name to search");
				 sc.nextLine();
				 String productName = sc.nextLine();
				 productDAOImpl.searchByProductName(productName);
				 break;
			 case 5:
				 productDAOImpl.totalAmount();
				 break;
			 case 6:
				 productDAOImpl.profitByCategoryWise();
				 break;
			 case 7: System.out.println("exiting");
			 System.exit(0);
			 default:
				 System.out.println("*****invalid choice");
				}
		}
	}
}

