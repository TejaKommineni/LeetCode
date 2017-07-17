package Strings;

import java.util.HashMap;
import java.util.Vector;

public class MinimumWindowSubstring {

public String minWindow(String s, String t) {
    if(t.length()>s.length()) 
        return "";
    String result = "";
 
    //character counter for t
    HashMap<Character, Integer> target = new HashMap<Character, Integer>();
    for(int i=0; i<t.length(); i++){
        char c = t.charAt(i);    
        if(target.containsKey(c)){
            target.put(c,target.get(c)+1);
        }else{
            target.put(c,1);  
        }
    }
 
    // character counter for s
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int left = 0;
    int minLen = s.length()+1;
 
    int count = 0; // the total of mapped characters
 
    for(int i=0; i<s.length(); i++){
        char c = s.charAt(i);
 
        if(target.containsKey(c)){
            if(map.containsKey(c)){
                if(map.get(c)<target.get(c)){
                    count++;
                }
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
                count++;
            }
        }
 
        if(count == t.length()){
            char sc = s.charAt(left);
            while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                    map.put(sc, map.get(sc) - 1);
                left++;
                sc = s.charAt(left);
            }
 
            if (i - left + 1 < minLen) {
                result = s.substring(left, i + 1);
                minLen = i - left + 1;
            }
        }
    }
 
    return result;
}

public static void main(String[] args) {

	MinimumWindowSubstring mws = new MinimumWindowSubstring();
	mws.minWindow("ADOBECODEBANC", "ABC");
	System.out.println(mws.minWindow2("ADOBECODEBANC", "ABC"));
	
}
private String minWindow2(String s, String t) {
	int map[] = new int[128]; 
	for(int i=0;i<t.length();i++)
    {
        map[t.charAt(i)]=map[t.charAt(i)]+1;
    }
    int counter = t.length();
    int begin=0,end =0,tail=Integer.MAX_VALUE,head =0;
    while(end<s.length())
    {
    	if(map[s.charAt(end++)]-->0)
    	{
    		counter--;
    	}
    	while(counter ==0)
    	{
	    	if(end-begin<tail)
	    	{
	    		head = begin;
	    		tail = end;
	    	}
	    	if(map[s.charAt(begin++)]++==0)
	    	{	
	    		counter++;
	    	}	
    	}
    }
    return tail==Integer.MAX_VALUE?"":s.substring(head, tail);
}
}