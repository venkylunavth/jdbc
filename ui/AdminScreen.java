package com.ecom.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ecom.dao.ProductDAO;
import com.ecom.model.Product;

public class AdminScreen {
	Scanner sc = new Scanner(System.in);
	ProductDAO pdao = new ProductDAO();
	public void productMenu() {
		int ch = 0;
		String name;
		int id;
		Product p;
		boolean s;
		float price;
		do {
			System.out.println("1. insert a new product");
			System.out.println("2. list all products");
			System.out.println("3. search product by id");
			System.out.println("4. Update product by id");
			System.out.println("5. Delete product by id");
			System.out.println("0. Logout");

			System.out.println("Enter your choice ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("Enter name ");
				name = sc.next();
				
				System.out.println("Enter price ");
				price = sc.nextFloat();
				
				p = new Product(name,price);
				s = pdao.addProduct(p);
				if(s==true)
				{
					System.out.println("Product added...");
				}
				else
				{
					System.out.println("Try again...");
				}
				break;

			case 2:
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

			case 3:
				System.out.println("Enter Id ");
				id = sc.nextInt();
				
				p = pdao.searchProduct(id);
				if(p==null)
				{
					System.out.println("Product not found...");
				}
				else
				{
					System.out.println(p);
				}
				break;

			case 4:
				System.out.println("Enter Id ");
				id = sc.nextInt();
				
				System.out.println("Enter name ");
				name = sc.next();
				
				System.out.println("Enter price ");
				price = sc.nextFloat();
				
				p = new Product(name,price);
				p.setId(id);
				s = pdao.updateProduct(p);
				if(s==true)
				{
					System.out.println("Product updated...");
				}
				else
				{
					System.out.println("Try again...");
				}
				break;

			case 5:
				System.out.println("Enter Id ");
				id = sc.nextInt();
				
				s = pdao.deleteProduct(id);
				if(s==true)
				{
					System.out.println("Product deleted...");
				}
				else
				{
					System.out.println("Try again...");
				}
				break;
			case 0:
				System.out.println("Bye Admin");
				break;
				
			default:
				System.out.println("invalid choice");
			}
		} while (ch != 0);
	}
}
