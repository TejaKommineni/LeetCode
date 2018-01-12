package LeetCode.Strings;

import java.util.HashMap;
import java.util.Map;

class DeleteOperationOfTwoStrings {
    public int minDistance(String word1, String word2) {
        
        HashMap<Character, Integer> hs1 = new HashMap();
        HashMap<Character, Integer> hs2 = new HashMap();
        
        for(int i=0;i<word1.length();i++)
        {
            hs1.put(word1.charAt(i), hs1.getOrDefault(word1.charAt(i),0)+1);
        }
        
         for(int i=0;i<word2.length();i++)
        {
            hs2.put(word2.charAt(i), hs2.getOrDefault(word2.charAt(i),0)+1);
        }
        
        int min = 0;
        
        for( Map.Entry<Character, Integer> e: hs1.entrySet())
        {
            if(hs2.containsKey(e.getKey()))
            {
                if(e.getValue() != hs2.get(e.getKey()))
                    min = min + Math.abs(e.getValue() - hs2.get(e.getKey()));
                hs2.remove(e.getKey());
                    
            }
            else
            {
                min = min+ e.getValue();
            }
        }
        
         for( Map.Entry<Character, Integer> e: hs2.entrySet())
        {
                      min = min+ e.getValue();
        }
        
        return min;
        
    }
    
    public static void main(String[] args) {
    	DeleteOperationOfTwoStrings d = new DeleteOperationOfTwoStrings();
    	System.out.println(d.minDistance("sea", "eat"));
	}
}