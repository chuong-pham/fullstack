package com.skillstorm.assignments.week6.FileWordCount;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * The program counts the total number of times that word appeared in the text file
 */
public class FileWordCountDemo {

	public static void main(String[] args) {
		char answer;
		Scanner keyboard = new Scanner(System.in);
		do {
			
			System.out.print("Please enter a file name: ");
			String inputFileString = keyboard.nextLine();
			Map<String, Integer> wordMap = countFileWord(inputFileString);
			
			System.out.println("Total words found: " + wordMap.size());	
			for(String key : wordMap.keySet()) {
				System.out.format("%-20s = %d\n", key, wordMap.get(key));
			}
			
			System.out.print("Do you want to continue?(Y/N): ");
			answer = keyboard.nextLine().charAt(0);
			
			
		}while(answer == 'Y' || answer == 'y');
		
		System.out.println("The program finishes.");
		System.exit(0);
		

	}
	
	public static Map<String, Integer> countFileWord(String inputFileString) {
		
		Map<String, Integer> wordMap = new HashMap<>();
		
		try {
			Scanner scanner = new Scanner(new FileReader(inputFileString));
			while(scanner.hasNext()) {
				//Finds and returns the next complete token which is 
				//delimited by a white space character
				String rawWord = scanner.next();
				//Convert the original string to lower case 
				//characters and remove all non alphabetic characters.
				String keyWord = rawWord.toLowerCase().replaceAll("[^a-z]", "");
				//Only add valid words as keys to the Hash Map
				if(!keyWord.isEmpty()) {
					if(!wordMap.containsKey(keyWord)) {
						wordMap.put(keyWord, 1);
					}
					else {
						wordMap.replace(keyWord, wordMap.get(keyWord) + 1);
					}
				}
			}
			
			scanner.close();
			
			
		}
		catch (FileNotFoundException e) {
			System.err.println("Error: File " + inputFileString + " Not Found!");
		} 
		return wordMap;
	}

}
