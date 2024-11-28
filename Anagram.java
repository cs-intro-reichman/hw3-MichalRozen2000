import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String processedStr1 = preProcess(str1);
        String processedStr2 = preProcess(str2);
		if (processedStr1.length() != processedStr2.length()) {
            return false;
        }

		for (int i = 0; i < processedStr1.length(); i++) {
            char c1 = processedStr1.charAt(i);
            boolean match = false;

			for (int j = 0; j < processedStr2.length(); j++) {
                if (processedStr2.charAt(j) == c1) {
					processedStr2 = processedStr2.substring(0, j) + processedStr2.substring(j + 1); // Remove matched character
                    match = true;
                    break;
                }
            }

            if (match) {
                return false;
            }
        }

        return true;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                result.append(Character.toLowerCase(c));

            } else if (c == ' ') {
                result.append(c);
            }
        }
        
        return result.toString();
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String processedStr = preProcess(str);
        
        // Convert the string to a char array
        char[] charArray = processedStr.toCharArray();
        
        // Use the Random class to shuffle the characters
        Random random = new Random();
        
        // Shuffle the characters in the char array
        for (int i = 0; i < charArray.length; i++) {
            int j = random.nextInt(charArray.length); // Get a random index to swap with
            // Swap the characters at positions i and j
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        
        // Convert the char array back to a string and return it
        return new String(charArray);
		
	}
}
