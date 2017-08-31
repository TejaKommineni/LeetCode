package LeetCode.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FindRestaurant {

	public class Solution {
	    public String[] findRestaurant(String[] a1, String[] a2) {
	        
	        TreeMap<Integer, List<String>> tr= new TreeMap();
	        List list1 = Arrays.asList(a1);
	        List list2 = Arrays.asList(a2);    
	        for(int i=0;i<list1.size();i++)
	        {
	            int index = list2.indexOf(list1.get(i));
	            if(index != -1)
	            {
	                if(tr.containsKey(i+index))
	                {
	                    List li = tr.get(i+index);
	                    li.add(list1.get(i));
	                    tr.put(i+index,li);
	                }
	                else
	                {
	                    List li = new ArrayList();
	                    li.add(list1.get(i));
	                    tr.put(i+index,li);
	                }
	            }
	        }
	        for(Map.Entry<Integer,List<String>> e:tr.entrySet())
	        {
	            return e.getValue().toArray(new String[0]);
	        }
	        return new String[]{};
	    }
	}   
}
