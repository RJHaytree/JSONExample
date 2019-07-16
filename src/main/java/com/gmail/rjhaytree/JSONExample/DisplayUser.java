package com.gmail.rjhaytree.JSONExample;

import java.io.File;

public class DisplayUser {
	/**
	 * Core update method needed to display all users in the data directory
	 */
	public static void display() {
		File dir = new File("../data/");
		File[] files = dir.listFiles();
		
		System.out.println("\n-------------[ DISPLAY USERS ]-------------");
		
		for (int i = 0; i < files.length; i++) {
			System.out.println("[" + i + "] " + files[i].getName());
		}
	}
}
