package com.gmail.rjhaytree.JSONExample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

public class CreateUser {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * method to create new user from console input
	 */
	public static void create() {
		System.out.println("--------------[ CREATE USER ]--------------");
		System.out.println("Enter the username for the new account: ");
		String username = scanner.nextLine();
		
		System.out.println("Enter the password for the new account: ");
		String password = scanner.nextLine();
		
		System.out.println("Enter the gender for the new account: ");
		String gender = scanner.nextLine();
		
		System.out.println("Enter the email for the new account: ");
		String email = scanner.nextLine();
		
		User user = new User(username, password, gender, email);
		
		writeToFile(user);
	}
	
	/**
	 * Saves the user object in a JSON file
	 * @param user - user object to be saved
	 * @return boolean - whether file was successfully saved
	 */
	private static boolean writeToFile(User user) {
		String name = user.getUsername();
		String PATH = "../data/" + name + ".json";
		
		try {
			File ufile = new File(PATH);
			
			// if user file doesn't exist, create file at desired path
			if (!ufile.exists()) {
				ufile.createNewFile();
				
				// use gson object to serialise user object to JsonString
				Gson gson = new Gson();
				String jsonUser = gson.toJson(user);
				
				// user file writer to write json string to newly created file
				FileWriter writer = new FileWriter(PATH);
				writer.write(jsonUser);
				writer.close();
				
				return true;
			}
			
			System.out.println("User already exists!");
			return false;
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}
}
