package LeetCode.Contests;

import java.util.Arrays;
import java.util.Comparator;

public class Contest63 {
	
	
	 public String shortestCompletingWord(String licensePlate, String[] words) {
	        
	        Arrays.sort(words, new Comparator<String>(){
	            public int compare(String o1, String o2) {
	                     return Integer.compare(o1.length(), o2.length());
	            }
	        });     
	        System.out.println(words);
	        
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
	 
	 public static void main(String[] args) {
		
		 Contest63 cs = new Contest63();
		 cs.shortestCompletingWord("1s3 PSt", new String[] {"step", "steps", "stripe", "stepple"});
	}
	    
	 

}
