package com.ecom.ui;

import java.util.Scanner;

import com.ecom.dao.AdminDAO;

public class HomeScreen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean status = true;

		AdminScreen adScreen; // declaration
		adScreen = new AdminScreen(); // Memory allocation

		UserScreen usrScreen = new UserScreen();

		AdminDAO adminDAO = new AdminDAO();

		String email, pass;
		int ch;
		do {
			System.out.println("1. Admin");
			System.out.println("2. User");
			System.out.println("0. Exit");

			System.out.println("Enter your choice");
			ch = sc.nextInt();

			switch (ch) {
			case 1:

				System.out.println("Enter Email-Id ");
				email = sc.next();

				System.out.println("Enter Password ");
				pass = sc.next();

				status = adminDAO.login(email, pass);

				if (status == true) {
					adScreen.productMenu();
				} else {
					System.out.println("Email and password does not match...");
				}

				break;
			case 2:
				usrScreen.init();
				break;
			case 0:
				System.out.println("Good bye!!!");
				break;
			default:
				System.out.println("Wrong choice");
			}
		} while (ch != 0);
	}
}