package LeetCode.Contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Contest55 {
	

	
	public List<Integer> findIntersection(int[] arr1, int[] arr2)
	{
		List<Integer> li = new ArrayList<Integer>();
		int m= arr1.length;
		int n= arr2.length;
		HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
		//O(M)
		for(int i=0;i<m;i++)
		{
			hs.put(arr1[i], hs.getOrDefault(arr1[i], 0)+1);
		}
		// O(N)
		for(int i=0;i<n;i++)
		{
			if(hs.containsKey(arr2[i]))
			{
				li.add(arr2[i]);
				hs.put(arr2[i], hs.get(arr2[i]) - 1);
				if(hs.get(arr2[i]) == 0) {
					hs.remove(arr2[i]);
				}
			}
			
		}
		
		return li;
	}
	
	public static void main(String[] args) {
		Contest55 cs = new Contest55();
		cs.findIntersection(new int[] {5,4,1,6,4,4,87,9,0} ,new int[] {1,1,2,3,4,4,9});
	}
}
