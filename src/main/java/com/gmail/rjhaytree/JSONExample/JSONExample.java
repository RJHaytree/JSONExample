package com.gmail.rjhaytree.JSONExample;

import java.io.File;
import java.util.Scanner;

public class JSONExample {
	// instantiate scanner to read input from console
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		appNavigator();
	}
	
	/**
	 * Method will use user input from console to determine what function will be used.
	 */
	private static void appNavigator() {
		boolean loop = true;
		
		while(loop) {
			// show input options in console
			System.out.println("Choose which action to perform:");
			System.out.println("A) CREATE USER");
			System.out.println("B) DISPLAY USER");
			System.out.println("C) DELETE USER");
			System.out.println("D) UPDATE USER \n");
		
			String input = scanner.nextLine();
		
			switch (input) {
				case "A":
					CreateUser.create();
					break;
				case "B":
					DisplayUser.display();
					break;
				case "C":
					DeleteUser.delete();
					break;
				case "D":
					UpdateUser.update();
					break;
				default: 
					System.out.println("Input was invalid. Please enter a valid choice...");
					loop = true;
					break;
			}
		}
	}
	
	private static void init() {
		String DIR = "../data";
		File dir = new File(DIR);
		
		try {
			// check if directory doesn't exist, and create if needed
			if (!dir.exists()) {
				dir.mkdir();
			}	
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
