package com.ecom.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ecom.dao.ProductDAO;
import com.ecom.dao.UserDAO;
import com.ecom.model.Product;
import com.ecom.model.User;

public class UserScreen {
	Scanner sc = new Scanner(System.in);

	public void init() {
		int ch;
		String email,password,name;
		int mobile;
		String res;
		UserDAO uDAO = new UserDAO(); 
				
		do {
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("0. Exit");

			System.out.println("Enter choice ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:

				System.out.println("Enter name ");
				name = sc.next();

				System.out.println("Enter email ");
				email = sc.next();
				
				System.out.println("Enter password ");
				password = sc.next();
				
				System.out.println("Enter Mobile ");
				mobile = sc.nextInt();
				
				User u = new User(name,email,password,mobile);
				boolean s = uDAO.register(u);
				if(s==true)
				{
					System.out.println("registered...");
				}
				else
				{
					System.out.println("try again");
				}
				break;

			case 2:
				System.out.println("Enter email ");
				email = sc.next();
				System.out.println("Enter password ");
				password = sc.next();
				
				res = uDAO.login(email, password);
				
				if(res == null)
				{
					System.out.println("email & password does not match");
				}
				else {			
					System.out.println("Welcome : "+res);
					productMenu();
				}
				break;

			case 0:
				System.out.println("bye");
				break;
			default:
				System.out.println("Invalid input");
			}
		} while (ch != 0);
	}

	public void productMenu() {
		int ch;
		ProductDAO pdao = new ProductDAO();				
		do {
			System.out.println("1. List all products");
			System.out.println("2. search product by id");
			System.out.println("0. Logout");

			System.out.println("Enter choice ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				ArrayList<Product> lst = pdao.getAllProducts();
				if(lst.isEmpty()==true)
				{
					System.out.println("there are no products");
				}
				else
				{
					for(Product temp : lst)
					{
						System.out.println(temp);
					}
				}
				break;
			case 2:
				System.out.println("Enter Id ");
				int id = sc.nextInt();
				
				Product p = pdao.searchProduct(id);
				if(p==null)
				{
					System.out.println("Product not found...");
				}
				else
				{
					System.out.println(p);
				}
				break;
			case 0:
				System.out.println("bye user");
				break;
				
			default :
				System.out.println("Invalid input");
				break;
			}

		} while (ch != 0);
	}

}
