package com.gmail.rjhaytree.JSONExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

public class UpdateUser {
	private static Scanner scanner = new Scanner(System.in);
	private static String PATH;
	/**
	 * Core update method needed to update an existing user file
	 */
	public static void update() {
		System.out.println("\n--------------[ UPDATE USER ]--------------");
		System.out.println("Enter the ID of the user to update:");
		Integer id = scanner.nextInt();
		
		try {
			updateUser(id);
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * Fetches the correct file using the selected ID, and will run the methods needed
	 * to update and save the user credentials.
	 * 
	 * @param i - The index/id of the user to be deleted
	 * @return boolean - whether update was successful
	 * @throws FileNotFoundException
	 */
	private static boolean updateUser(Integer i) throws FileNotFoundException {
		File dir = new File("../data/");
		File[] files = dir.listFiles();
		
		if (i < files.length) {
			// get path of the selected file at the index
			PATH = files[i].getPath();
			// store a version of the file's contents in memory
			BufferedReader reader = new BufferedReader(new FileReader(PATH));
			
			Gson gson = new Gson();
			// use the stored content of the json file to create a new user object (deserialise)
			User user = gson.fromJson(reader, User.class);
			
			updateCredentials(user, i);
		}
		
		return false;
	}
	
	/**
	 * Update the credentials of the selected user object
	 * @param user - the user object to be updated
	 * @param i - index of selected user in data directory
	 */
	private static void updateCredentials(User user, Integer i) {
		System.out.println("-------[ NAME: " + user.getUsername() + " | ID: " + i + " ]-------");
		System.out.println("The username of the user cannot be updated. Furthermore, we must to the password.");
		
		// scanner.nextLine() must be ran to consume \n being called after scanner.nextInt() used when 
		// the user index.
		scanner.nextLine();
		
		System.out.println("Input a new password for this user: (Existing password: " + user.getPassword() + ")");
		String password = scanner.nextLine();
		user.setPassword(password);
		
		System.out.println("Input the new gender of this user: (Existing gender: " + user.getGender() + ")");
		String gender = scanner.nextLine();
		user.setGender(gender);
		
		System.out.println("Input the new email of this user: (Existing email: " + user.getEmail() + ")");
		String email = scanner.nextLine();
		user.setEmail(email);
		
		try {
			saveUserToFile(user);
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * Save updated user object to the desired file
	 * @param user - the user object that has been updated
	 * @throws IOException
	 */
	private static void saveUserToFile(User user) throws IOException {
		
		// create file object pointing to the correct path for this user's file
		File ufile = new File(PATH);
		
		// if user file doesn't exist, create file at desired path
		if (ufile.exists()) {
			
			// refresh the file by deleting and recreated it
			ufile.delete();
			ufile.createNewFile();
			
			// use gson object to serialise user object to JsonString
			Gson gson = new Gson();
			String jsonUser = gson.toJson(user);
			
			// user file writer to write json string to newly created file
			FileWriter writer = new FileWriter(PATH);
			writer.write(jsonUser);
			writer.close();
		}
	}
}
