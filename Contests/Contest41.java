package LeetCode.Contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Contest41 {

    class Exclusive
    {
        String id;
        String type;
        Integer timeStamp;
        
        public Exclusive(String id, String type, Integer  timeStamp)
        {
         this.id =id;
         this. type = type;
         this. timeStamp = timeStamp;   
        }
        
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        
        TreeMap<String,Integer> hs = new TreeMap();
        Stack<Exclusive> st= new Stack();
        for(int i=0;i<logs.size();i++)
        {
            String split[] = logs.get(i).split(":");
            Exclusive e = new Exclusive(split[0],split[1],Integer.parseInt(split[2]));
            if(!st.isEmpty())
            {
                Exclusive temp = st.peek();
                if(temp.type.equals("start") && e.type.equals("start"))
                {
                     Exclusive e1 = new Exclusive(temp.id,"end",Integer.parseInt(split[2])-1);
                     st.push(e1);
                     st.push(e);
                    
                }                
                else if(temp.type.equals("end") && e.type.equals("end"))
                {
                     Exclusive e1 = new Exclusive(split[0],"start",Integer.parseInt(split[2]));
                     st.push(e1);
                     st.push(e);
                }
                else
                {
                    st.push(e);
                }
            }
            else
            {
                st.push(e);
            }    
            
        }
        while(!st.isEmpty())
        {
            Exclusive e = st.pop();
            Exclusive e1 = st.pop();
            if(!hs.containsKey(e.id))
            {
                hs.put(e.id,e.timeStamp-e1.timeStamp+1);
            }
            else
            {
                hs.put(e.id,hs.get(e.id)+e.timeStamp-e1.timeStamp+1);
            }
        }
        int result [] = new int[n];
        int i=0;
        for(Map.Entry<String,Integer> e : hs.entrySet())
        {
            result[i++] = e.getValue();
        }
      return result;  
    }
    
    public static void main(String[] args) {
		Contest41 c = new Contest41();
		List<String> logs = new ArrayList();
		logs.add("0:start:0"); 
		logs.add("1:start:2"); 
		logs.add("1:end:5"); 
		logs.add("0:end:6"); 
		c.exclusiveTime(2, logs);
	}
}
