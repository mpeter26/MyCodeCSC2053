// @ author --- Michael Peters

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Project1 extends P1Methods {
	
	public static void main(String[] args) throws FileNotFoundException { 
	    
	    HashMap<String,Integer> WordFreq = new HashMap<>(); // initialize word hashmap
		
	    HashMap<String,Integer> LetterFreq = new HashMap<>(); // initialize letter hashmap
	    LetterFreq.put("a", 0);
	    LetterFreq.put("b", 0);	
	    LetterFreq.put("c", 0);		
	    LetterFreq.put("d", 0);
	    LetterFreq.put("e", 0);
	    LetterFreq.put("f", 0);
	    LetterFreq.put("g", 0);
	    LetterFreq.put("h", 0);
	    LetterFreq.put("i", 0);
	    LetterFreq.put("j", 0);
	    LetterFreq.put("k", 0);
	    LetterFreq.put("l", 0);
	    LetterFreq.put("m", 0);
	    LetterFreq.put("n", 0);
	    LetterFreq.put("o", 0);
	    LetterFreq.put("p", 0);
	    LetterFreq.put("q", 0);
	    LetterFreq.put("r", 0);
	    LetterFreq.put("s", 0);
	    LetterFreq.put("t", 0);
	    LetterFreq.put("u", 0);
	    LetterFreq.put("v", 0);
	    LetterFreq.put("w", 0);
	    LetterFreq.put("x", 0);
	    LetterFreq.put("y", 0);
	    LetterFreq.put("z", 0);
	    
	    for(String line: TxtFileScanner("alice-in-wonderland.txt")) { //converts array list into word hashmap
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(line);
			while(scan.hasNext()) {
				//this will read the line and separate out each word
				scan.useDelimiter("[^a-zA-Z']");
				String word = scan.next();
				word=word.toLowerCase();
				//replace all leading apostrophes
				word = word.replaceAll("^'+", "");
				//replace all trailing apostrophes
				word = word.replaceAll("'+$", "");
				/* now you have a word to put in your map*/
				if(WordFreq.containsKey(word)) {
					int num = WordFreq.get(word);
					WordFreq.put(word, num+1);
				} else {
					if(!word.isEmpty())
						WordFreq.put(word, 1);
				}
				
				for (int j = 0; j < word.length(); j++){ //convert words to letter hashmap
		            char cr = word.charAt(j);
		            String sg = "" + cr;
		        
		            if(LetterFreq.containsKey(sg)) {
		        		int num = LetterFreq.get(sg);
		        		LetterFreq.put(sg, num+1);
		        	}
				}
	        }
	    }

	    System.out.println("Project 1     -    Alice in Wonderland Anaysis");
        
	    HashMap<String,Integer> LetterTop10 = new HashMap<>(); // create new map to hold letters top 10
        for (int i = 0; i < 10; i++) {
        	int max = -1;
            String maxKey = null;
        	for (String key : LetterFreq.keySet()) {
        		if (LetterFreq.get(key) > max) {
        			max = LetterFreq.get(key);
        			maxKey = key;
        		}
        	}
        	LetterTop10.put(maxKey, max);
        	LetterFreq.remove(maxKey);
        }
        System.out.println();
        System.out.println("10 most frequently used letters in order");
        OrderAndPrintHashmap(LetterTop10);
        
       
        
        
        
        
        HashMap<String,Integer> WordTop10 = new HashMap<>(); // create new map to hold words top 10
        for (int i = 0; i < 10; i++) {
        	int max = -1;
            String maxKey = null;
        	for (String key : WordFreq.keySet()) {
        		if (WordFreq.get(key) > max) {
        			max = WordFreq.get(key);
        			maxKey = key;
        		}
        	}
        	WordTop10.put(maxKey, max);
        	WordFreq.remove(maxKey);
        }
        System.out.println();
        System.out.println("10 most frequently used words in order");
        OrderAndPrintHashmap(WordTop10);
     
        
        
        
		for (int i = 0; i < TxtFileScanner("stop-list.txt").size(); i++) { //  remove stop list words from word WordFreq
			WordFreq.remove(TxtFileScanner("stop-list.txt").get(i));
		}
        
        HashMap<String,Integer> StopListTop10 = new HashMap<>(); //create new map and input stop list top 10
        for (int i = 0; i < 10; i++) {
        	int max = -1;
            String maxKey = null;
        	for (String key : WordFreq.keySet()) {
        		if (WordFreq.get(key) > max) {
        			max = WordFreq.get(key);
        			maxKey = key;
        		}
        	}
        	StopListTop10.put(maxKey, max);
        	WordFreq.remove(maxKey);
        }
        System.out.println();
        System.out.println("10 most frequently used words in order using stop list");
        OrderAndPrintHashmap(StopListTop10);
        
        
        
        
            
         HashMap<String,Integer> PalindromeTop10 = new HashMap<>(); // create new map to hold palindromes
         String PalKey = null;
         for (String key : WordFreq.keySet()) {
            if (WordIsPalindrome(key)) {
            	PalindromeTop10.put(key, WordFreq.get(key));
            	PalKey = key;
            }
         }
         WordFreq.remove(PalKey);
         
         System.out.println();
         System.out.println("10 most frequently used palindromes in order using stop list");
         OrderAndPrintHashmap(PalindromeTop10);
        
	}
}

