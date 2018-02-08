package LeetCode.Hashing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentWordss {
    
    public List<String> topKFrequent(String[] words, int k) {

        
        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
      
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue()
        );
        
        pq.addAll(map.entrySet());
        
        while(k>0)
        {
        	result.add(pq.poll().getKey());
        	k--;
        }

              
        return result;
    }
    
    public static void main(String[] args) {
		TopKFrequentWordss tk = new TopKFrequentWordss();
		tk.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2);
    	
	}
    
 public String reverseWords(String s) {
        
        String words[] = s.split(" ");
        String ans = "";
        for(String word : words)
        {
            ans = word +" "+ans;
        }
        ans = ans.trim();
        return ans;
        
    }
    
    }
