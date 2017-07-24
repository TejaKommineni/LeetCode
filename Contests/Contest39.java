package LeetCode.Contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Contest39 {

	
	
	    public int leastInterval(char[] tasks, int n) {
	        HashMap<Character,Integer> hs = new HashMap();
	        LinkedHashSet<Character> hs1 = new LinkedHashSet();
	        for(int i=0;i<tasks.length;i++)
	        {
	            Character temp = Character.valueOf(tasks[i]);
	            if(hs1.contains(temp))
	            {
	                hs.put(temp,hs.get(temp)+1);
	            }
	            else
	            {
	                hs.put(temp,1);
	                hs1.add(temp);
	            }
	        }
	        int count =0;
	        while(hs.size() != 0)
	        {
	            int x =n+1;
	            for(Character c: hs1)
	            {
	            
	                if(hs.containsKey(c))
	                {
	                    x--;
	                    count++;
	                    int temp = hs.get(c);
	                    if(temp == 1)
	                        hs.remove(c);
	                    else
	                        hs.put(c,hs.get(c)-1);
	                }
	                 
	            }
	            count = hs.size()!=0 && x>0 ? count +x:count;
	            
	        }
	        
	        return count;
	        
	    }
	
	
	public static void main(String[] args) {
						
		Contest39 cs = new Contest39 ();
		cs.leastInterval(new char[]{'A','A','A','B','B','B'}, 2);
		int [] a = new int[2];
		List<int[]> li = new ArrayList();
		li.add(a);
		System.out.println("tja");
		System.out.println(cs.hashCode());
		System.out.println(cs.toString());
		try
		{
			int c = 3/0;
		}
		catch(Exception e)
		{
			System.out.println("ayoo error");
		}
		System.out.println("still i will get printed.");
		
		Integer i  = 1;
		Integer i1  = 1;
		if(i.equals(i1))
			System.out.println("still i will get printed.");
		
	}
	
}


