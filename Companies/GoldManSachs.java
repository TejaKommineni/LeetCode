package LeetCode.Companies;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class GoldManSachs {
	
	private int test;

	static int bestAverageGrade(String[][] scores) {

	    HashMap<String, Integer> numberOfScores = new  HashMap<String, Integer> ();
	    HashMap<String, Double> score = new  HashMap<String, Double> ();
	    
	    for(int i=0;i<scores.length;i++)
	    {
	        if(numberOfScores.containsKey(scores[i][0]))
	        {
	           numberOfScores.put( scores[i][0], numberOfScores.get(scores[i][0])+1); 
	           score.put(scores[i][0] , score.get(scores[i][0])+Double.valueOf(scores[i][1]));
	        }
	        else
	        {
	             numberOfScores.put(scores[i][0],1);
	             score.put(scores[i][0],Double.valueOf(scores[i][1]));
	        }
	    }

	    int bestAverage = Integer.MIN_VALUE;
	    for(Map.Entry<String, Double> e: score.entrySet())
	    {
	        double sum = e.getValue();
	        int appeared = numberOfScores.get(e.getKey());
	        double average = (sum/appeared);
	        bestAverage = Math.max((int)(Math.floor(average)), bestAverage);
	        
	    }


	    return bestAverage;
	}
	
	
	 static String[] uniqueSubstrings(String inputString, int substringLength) {
	        
	        if(inputString.length() == 0 || substringLength == 0 || inputString.length() < substringLength)
	            return new String[0];
	            
	        TreeSet<String> ts = new TreeSet();
	        for(int i=0;i<=inputString.length()-substringLength;i++)
	        {
	            if(!ts.contains(inputString.substring(i,i+substringLength)))
	            {
	                ts.add(inputString.substring(i, i+ substringLength));
	            }
	        }
	        String ans[] = new String[ts.size()];
	        int i=0;
	        for (String s : ts) {
	                ans[i] = s;
	                i++;
	            }
	        
	        return ans;
	    }
	

static int countPairs(int sum, int[] a) {
    
    HashMap<Integer, Integer> hm = new HashMap<>();  
    if(a == null || a.length == 0)
        return 0;
     
     for (int i=0; i<a.length; i++){          
         if(!hm.containsKey(a[i]))
             hm.put(a[i],1);
         else
             hm.put(a[i], hm.get(a[i])+1);
     }
     int count = 0;
        
     for (int i=0; i<a.length; i++)
     {
         if(hm.containsKey(sum-a[i])){
         count += hm.get(sum-a[i]);   
         if (sum-a[i] == a[i])
             count--;
         }    
     }   
     return count/2;
     
 }
	
	public static void main(String[] args) {
		
		GoldManSachs g = new GoldManSachs();
		x X = new x();
		
		g.countPairs(-2147483648, new int[] {2147483647,1,2,3,4,5});
		g.uniqueSubstrings("aaabbc", 2);
	}
}



 class x extends GoldManSachs
 {
	 
	 
 }

	
