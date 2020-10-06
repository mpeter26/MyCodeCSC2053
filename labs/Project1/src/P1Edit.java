import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class P1Edit extends P1Methods {

	public static <K, V> K getKey(Map<K, V> map, V value) { //method to get key from value
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}

	public static boolean WordIsPalindrome(String str) {	//method to determine if string is palindrome		 
		if(str.length() == 0 || str.length() == 1)
            return true; 
		
        if(str.charAt(0) == str.charAt(str.length()-1))
        	return WordIsPalindrome(str.substring(1, str.length()-1));

        return false;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
	    File ProjectFile = new File("alice-in-wonderland.txt"); // read file into array list
		Scanner scan = new Scanner(ProjectFile);
		ArrayList<String> fileLines = new ArrayList<String>();
		while (scan.hasNextLine()) {
			/*if (scan.nextLine().isEmpty()) {
		    	fileLines.add(scan.nextLine());
			}*/
			String s = scan.nextLine();
			s.trim();
			if (!s.isEmpty()) {
		    fileLines.add(s);
			}
		}
	    scan.close();
	    //System.out.println(fileLines.get(fileLines.size() - 1));    
	    
	    HashMap<String,Integer> WordFreq = new HashMap<>(); // initialize word hashmap
		
	    HashMap<Character,Integer> LetterFreq = new HashMap<>(); // initialize letter hashmap
	    LetterFreq.put('a', 0);
	    LetterFreq.put('b', 0);	
	    LetterFreq.put('c', 0);		
	    LetterFreq.put('d', 0);
	    LetterFreq.put('e', 0);
	    LetterFreq.put('f', 0);
	    LetterFreq.put('g', 0);
	    LetterFreq.put('h', 0);
	    LetterFreq.put('i', 0);
	    LetterFreq.put('j', 0);
	    LetterFreq.put('k', 0);
	    LetterFreq.put('l', 0);
	    LetterFreq.put('m', 0);
	    LetterFreq.put('n', 0);
	    LetterFreq.put('o', 0);
	    LetterFreq.put('p', 0);
	    LetterFreq.put('q', 0);
	    LetterFreq.put('r', 0);
	    LetterFreq.put('s', 0);
	    LetterFreq.put('t', 0);
	    LetterFreq.put('u', 0);
	    LetterFreq.put('v', 0);
	    LetterFreq.put('w', 0);
	    LetterFreq.put('x', 0);
	    LetterFreq.put('y', 0);
	    LetterFreq.put('z', 0);
	    
	    for(String line: fileLines) { //converts array list into word map
			scan = new Scanner(line);
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
					//if food item is not in map yet, add it with value 1
					if(!word.isEmpty())
						WordFreq.put(word, 1);
				}
				
				for (int j = 0; j < word.length(); j++){ //converts words to letter map
		            char cr = word.charAt(j);
		        
		            if(LetterFreq.containsKey(cr)) {
		        		int num = LetterFreq.get(cr);
		        		LetterFreq.put(cr, num+1);
		        	}
				}
	        }
	    }

        //System.out.println(LetterFreq);
	    System.out.println();
        
        
        List<Integer> LetterList = new ArrayList<Integer>(LetterFreq.values());
        Collections.sort(LetterList, Collections.reverseOrder());
        List<Integer> LetterTop10 = LetterList.subList(0, 10);
        
        //System.out.println(LetterTop10);
        System.out.println();
        System.out.println("10 most frequently used letters in order");
        
        for (int i = 0; i < LetterTop10.size(); i++) {
            int val = LetterList.get(i);
			System.out.println("Letter: " + getKey(LetterFreq, val) + "  |  Frequency: " + LetterFreq.get(getKey(LetterFreq, val)));
        }
        System.out.println();
        
       
        
        
        
        
        List<Integer> WordList = new ArrayList<Integer>(WordFreq.values());
        Collections.sort(WordList, Collections.reverseOrder());
        List<Integer> WordTop10 = WordList.subList(0, 10);
        
        //System.out.println(WordTop10);
        System.out.println();
        System.out.println("10 most frequently used words in order");
        
        for (int i = 0; i < WordTop10.size(); i++) {
            int val = WordList.get(i);
            String keyL = getKey(WordFreq, val);
            if (keyL.length() == 3)
            	System.out.println("Word: " + keyL + "  |  Frequency: " + WordFreq.get(keyL));
            else if (keyL.length() == 1)
            	System.out.println("Word: " + keyL + "    |  Frequency: " + WordFreq.get(keyL));
            else if (keyL.length() == 2)
            	System.out.println("Word: " + keyL + "   |  Frequency: " + WordFreq.get(keyL));
            else if (keyL.length() == 4)
            	System.out.println("Word: " + keyL + " |  Frequency: " + WordFreq.get(keyL));
        }
        
        
        
        
        
        File SLfile = new File("stop-list.txt");  // read in stoplist file and create new array list
		Scanner scan2 = new Scanner(SLfile);;
		ArrayList<String> SLwords = new ArrayList<String>();
		while (scan2.hasNextLine()) {
			/*if (scan2.nextLine().isEmpty()) {
		    	fileLines.add(scan2.nextLine());
			}*/
			String stringy = scan2.nextLine();
			stringy.trim();
			if (!stringy.isEmpty()) {
				SLwords.add(stringy);
			}
		}
		scan2.close();
		
		
		for (int i = 0; i < SLwords.size(); i++) { //  remove sl words from word freq
			WordFreq.remove(SLwords.get(i));
		}
        
        HashMap<String,Integer> StopListHmap = new HashMap<>(); //create new map and input sl top 10
        for (int i = 0; i < 10; i++) {
        	int max = -1;
            String maxKey = null;
        	for (String key : WordFreq.keySet()) {
        		if (WordFreq.get(key) > max) {
        			max = WordFreq.get(key);
        			maxKey = key;
        		}
        	}
			StopListHmap.put(maxKey, max);
        	WordFreq.remove(maxKey);
        }
        System.out.println();
        System.out.println("10 most frequently used words in order using stop list");
        //System.out.println(StopListHmap);
        
        
        while (StopListHmap.size() != 0) { // order top 10 and print
        	int max = -1;
        	String maxKey = null;
        	for (String key : StopListHmap.keySet()) {
        		if (StopListHmap.get(key) > max) {
        			max = StopListHmap.get(key);
        			maxKey = key;
        		}
        	}
        	if (maxKey.length() == 4)
            	System.out.println("Word: " + maxKey + "    |  Frequency: " + StopListHmap.get(maxKey));
            else if (maxKey.length() == 2)
            	System.out.println("Word: " + maxKey + "      |  Frequency: " + StopListHmap.get(maxKey));
            else if (maxKey.length() == 3)
            	System.out.println("Word: " + maxKey + "     |  Frequency: " + StopListHmap.get(maxKey));
            else if (maxKey.length() == 5)
            	System.out.println("Word: " + maxKey + "   |  Frequency: " + StopListHmap.get(maxKey));
            else if (maxKey.length() == 6)
            	System.out.println("Word: " + maxKey + "  |  Frequency: " + StopListHmap.get(maxKey));
            else if (maxKey.length() == 7)
            	System.out.println("Word: " + maxKey + " |  Frequency: " + StopListHmap.get(maxKey));        	
        	StopListHmap.remove(maxKey);
        }
        
        
        
        
        
        
        
         System.out.println();
         System.out.println("Most frequently used palindromes in order excluding stop list palindromes");
            //System.out.println(StopListHmap);
            
         HashMap<String,Integer> PalindromeMap = new HashMap<>(); // create new map to hold palins
         String PalKey = null;
         for (String key : WordFreq.keySet()) {
            if (WordIsPalindrome(key)) {
            	PalindromeMap.put(key, WordFreq.get(key));
            	PalKey = key;
            }
         }
         WordFreq.remove(PalKey);
         
              
         while (PalindromeMap.size() != 0) {   // order palins and print
         	int max = -1;
         	String maxKey = null;
         	for (String key : PalindromeMap.keySet()) {
         		if (PalindromeMap.get(key) > max) {
         			max = PalindromeMap.get(key);
         			maxKey = key;
         		}
         	}
         	if (maxKey.length() == 4)
         		System.out.println("Word: " + maxKey + "    |  Frequency: " + PalindromeMap.get(maxKey));
            else if (maxKey.length() == 1)
             	System.out.println("Word: " + maxKey + "       |  Frequency: " + PalindromeMap.get(maxKey));
            else if (maxKey.length() == 2)
             	System.out.println("Word: " + maxKey + "      |  Frequency: " + PalindromeMap.get(maxKey));
            else if (maxKey.length() == 3)
             	System.out.println("Word: " + maxKey + "     |  Frequency: " + PalindromeMap.get(maxKey));
            else if (maxKey.length() == 5)
             	System.out.println("Word: " + maxKey + "   |  Frequency: " + PalindromeMap.get(maxKey));
            else if (maxKey.length() == 6)
             	System.out.println("Word: " + maxKey + "  |  Frequency: " + PalindromeMap.get(maxKey));
            else if (maxKey.length() == 7)
             	System.out.println("Word: " + maxKey + " |  Frequency: " + PalindromeMap.get(maxKey));        	
         	PalindromeMap.remove(maxKey);
         	
          }

	}
}


