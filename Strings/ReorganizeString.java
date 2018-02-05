package LeetCode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public String reorganizeString(String S) {
        
        
     Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < S.length(); i++) {
        map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1); // map key is TaskName, and value is number of times to be executed.
    }
    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

    q.addAll(map.entrySet());

    int count = 0;
    String ans = "";
    while (!q.isEmpty()) {
        int k = 2;
        List<Map.Entry> tempList = new ArrayList<>();
        while (k > 0 && !q.isEmpty()) {
            Map.Entry<Character, Integer> top = q.poll(); // most frequency task
            ans = ans + top.getKey();
            top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
            tempList.add(top); // collect task to add back to queue
            k--;
            count++; //successfully executed task
        }

        for (Map.Entry<Character, Integer> e : tempList) {
            if (e.getValue() > 0) q.add(e); // add valid tasks 
        }
        
        
        if (q.isEmpty()) break;
        count = count + k; // if k > 0, then it means we need to be idle
        if(k > 0)
        {
            return "";
        }
        
    }
    return ans;
        
    }
    public static void main(String[] args) {
		
    	ReorganizeString r = new ReorganizeString();
    	r.reorganizeString("aaab");
	}
}