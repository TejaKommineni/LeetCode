package Contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Contest32 {
	
public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        
        HashMap<Integer, List<Integer>> hs = new HashMap();
        
        for(int i=0;i<ppid.size();i++)
        {
            if(hs.containsKey(ppid.get(i)))
            {
                hs.get(ppid.get(i)).add(pid.get(i));
                
            }
            else
            {
                List temp = new ArrayList();
                temp.add(pid.get(i));
                hs.put(ppid.get(i),temp);
            }
        }
        
        List<Integer> answer = new ArrayList();
        Queue<Integer> q = new LinkedList();
        q.add(kill);
        while(!q.isEmpty())
        {
        	int temp = q.remove();
        	answer.add(temp);
        	List<Integer> tempList = hs.get(temp);
        	if(tempList != null)
        	{
        		for(int i : tempList)
        		{
        			q.add(i);
        		}
        	}
        	
        }
        return answer; 
    }


	public boolean checkInclusion(String s1, String s2) {

		int map[] = new int[256];

		for (char c : s1.toCharArray()) {
			map[(int) c]++;
		}

		int begin = 0;
		int end = 0;
		int head = 0;
		int counter = s1.length();
		int d = Integer.MAX_VALUE;

		while (end < s2.length()) {

			if (map[(int) s2.charAt(end++)]-- > 0)
				counter--;

			while (counter == 0) {
				if (d > end - begin) {
					d = end - begin;
					head = begin;
				}
				if (map[(int) s2.charAt(begin++)]++ == 0)
					counter++;

				if (d == s1.length())
					return true;
			}

		}

		if (d == s1.length())
			return true;

		return false;

	}


public static void main(String[] args) {
	
	Contest32 cs = new Contest32();
	cs.checkInclusion("ab","eidboaoo");
	List<Integer> pid = Arrays.asList(1, 3, 10, 5);
	List<Integer> ppid = Arrays.asList(3, 0, 5, 3); 
    int kill = 5;
	cs.killProcess(pid, ppid, kill);
	
}
}
