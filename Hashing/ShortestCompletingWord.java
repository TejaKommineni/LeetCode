package LeetCode.Hashing;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.
Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
Note:
licensePlate will be a string with length in range [1, 7].
licensePlate will contain digits, spaces, or letters (uppercase or lowercase).
words will have a length in the range [10, 1000].
Every words[i] will consist of lowercase letters, and have length in range [1, 15].
 * 
 * 
 */

public class ShortestCompletingWord {
	

    public String shortestCompletingWord(String licensePlate, String[] words) {
        
	        
	        Arrays.sort(words, new Comparator<String>(){
	            public int compare(String o1, String o2) {
	                     return Integer.compare(o1.length(), o2.length());
	            }
	        });     
	        //System.out.println(words);
	        
	        String temp = "";
	        licensePlate = licensePlate.toLowerCase();
	        for(int i=0;i<licensePlate.length();i++)
	        {
	        	if(licensePlate.charAt(i) >= 'a' &&  licensePlate.charAt(i) <= 'z')
	        		temp = temp + licensePlate.charAt(i);
	        }
	        licensePlate = temp;
	        for(int i=0;i<words.length;i++)
	        {
	        	String word = words[i];
	        	int begin=0;
	        	int end =0;
	        	int alpha [] = new int [256];
	        	int count = licensePlate.length();
	        	if (word.length() < licensePlate.length())
	        	{
	        		continue;
	        	}
	        	for(int j=0;j<licensePlate.length();j++)
	        		alpha[licensePlate.charAt(j)]++;
	        	while(end < word.length())
	        	{
	        		if(alpha[word.charAt(end++)]-- > 0 ) 
	        			count --;
	        		
	        		if(count == 0)
	        			return word;
	        		
	        	}
	        	
	        	
	        }
	        
	        return "no";
	     
    }

}
