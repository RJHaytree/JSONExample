package com.gmail.rjhaytree.JSONExample;

import java.io.File;
import java.util.Scanner;

public class DeleteUser {
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Core delete method needed to delete and existing user file
	 */
	public static void delete() {
		System.out.println("\n--------------[ DELETE USER ]--------------");
		System.out.println("Enter the ID of the user to delete:");
		Integer id = scanner.nextInt();
		
		if (deleteUser(id)) {
			System.out.println("The file with ID " + id + " has been deleted");
		}
		else {
			System.out.println("The file with ID: " + id + " has not been deleted");
		}
	}
	
	/**
	 * Delete user file using the selected index/id
	 * @param i - index/id of the file 
	 * @return boolean - whether delete was successful
	 */
	private static boolean deleteUser(Integer i) {
		
		File dir = new File("../data/");
		File[] files = dir.listFiles();
		
		return files[i].delete();
	}
}
