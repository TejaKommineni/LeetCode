package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

/*
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.

 */
	
	public int leastInterval(char[] tasks, int n) {
	     Map<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < tasks.length; i++) {
	        map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
	    }
	    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
	            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

	    q.addAll(map.entrySet());

	    int count = 0;
	    while (!q.isEmpty()) {
	        int k = n + 1;
	        List<Map.Entry> tempList = new ArrayList<>();
	        while (k > 0 && !q.isEmpty()) {
	            Map.Entry<Character, Integer> top = q.poll(); // most frequency task
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
	    }
	    return count;
	}
	
}
