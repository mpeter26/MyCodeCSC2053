// @ author --- Michael Peters

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class P1Methods {

	// This method takes a string and determines whether or not the string is a palindrome
	// Method is boolean and returns true if string is a palindrome and false if not
	public static boolean WordIsPalindrome(String str)  {		 
		if(str.length() == 0 || str.length() == 1)
            return true; 
		
        if(str.charAt(0) == str.charAt(str.length()-1))
        	return WordIsPalindrome(str.substring(1, str.length()-1));

        return false;
	}
	

	// This method takes a string name of a txt file and returns an array list of strings 
	// Each String in the array list represents a line from the file
	public static ArrayList<String> TxtFileScanner (String FileName) throws FileNotFoundException{
		File ProjectFile = new File(FileName);
		Scanner scan = new Scanner(ProjectFile);
		ArrayList<String> fileLines = new ArrayList<String>();
		while (scan.hasNextLine()) {
			String s = scan.nextLine();
			s.trim();
			if (!s.isEmpty()) {
		    fileLines.add(s);
			}
		}
	    scan.close();
	    return fileLines; 
	}
	
	
	// This method takes a hashmap with 10 keys and their frequency/value 
	// It returns a printed list of the keys and frequencies in order from most to least frequent
	public static void OrderAndPrintHashmap(Map<String, Integer> map) {
		
        while (map.size() != 0) { // order top 10 and print
        	int max = -1;
        	String maxKey = null;
        	for (String key : map.keySet()) {
        		if (map.get(key) > max) {
        			max = map.get(key);
        			maxKey = key;
        		}
        	}
        	if (maxKey.length() == 4)
            	System.out.println("Word: " + maxKey + "    |  Frequency: " + map.get(maxKey));
        	else if (maxKey.length() == 1)
            	System.out.println("Word: " + maxKey + "       |  Frequency: " + map.get(maxKey));
            else if (maxKey.length() == 2)
            	System.out.println("Word: " + maxKey + "      |  Frequency: " + map.get(maxKey));
            else if (maxKey.length() == 3)
            	System.out.println("Word: " + maxKey + "     |  Frequency: " + map.get(maxKey));
            else if (maxKey.length() == 5)
            	System.out.println("Word: " + maxKey + "   |  Frequency: " + map.get(maxKey));
            else if (maxKey.length() == 6)
            	System.out.println("Word: " + maxKey + "  |  Frequency: " + map.get(maxKey));
            else if (maxKey.length() == 7)
            	System.out.println("Word: " + maxKey + " |  Frequency: " + map.get(maxKey));        	
        	map.remove(maxKey);
        }
	}
	
}
