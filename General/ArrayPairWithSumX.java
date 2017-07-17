import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayPairWithSumX {
	private static Map<String, String> sortByKey(Map<String, String> unsortMap, boolean asc) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, String>> list =
                new LinkedList<Map.Entry<String, String>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
            	if(asc)
            		return (o1.getKey()).compareTo(o2.getKey());
            	else 
                    return (o2.getKey()).compareTo(o1.getKey());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (Map.Entry<String, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	
    public static void main(String args[] ) throws Exception {
    	
       
        Scanner sc = new Scanner(System.in);
        String timePeriod = sc.nextLine();
        String time[] = timePeriod.split(",");
        String start_time = time[0].trim();
        String end_time = time[1].trim();
        sc.nextLine();
        HashMap<String,String> map = new HashMap<String,String>();
        boolean flag =true;
        while(sc.hasNextLine())
        {
            String input = sc.nextLine();
           
            String inputPeriod = input.substring(0,input.lastIndexOf("-"));            
            String key = inputPeriod;
            
            if(inputPeriod.compareTo(start_time)>=0 &&  inputPeriod.compareTo(end_time)<0)  
            {
                if(map.containsKey(key))
                {
                    String value =  map.get(key);             
                    String temp = value+","+input.substring(input.indexOf(",")+1,input.length());
                    map.put(key,temp);
                }
                else
                {
                	map.put(key,input.substring(input.indexOf(",")+1,input.length()));
                }
            }            
                    
        }
        Map<String,String> sortedMap = sortByKey(map,false);          
        for(Map.Entry<String, String> e : sortedMap.entrySet())
        {
        	String key =e.getKey();        	
        	String printed = key;    	
        	String split[] = e.getValue().trim().split(",");        	
             HashMap<String,String> hs = new HashMap<String,String>();
             for(int i=0;i<split.length;i=i+2)
             {
            	if(hs.containsKey(split[i].trim())) 
             	{
            		int value = Integer.parseInt(hs.get(split[i].trim()));
            		value = value +  Integer.parseInt(split[i+1].trim());
            		hs.put(split[i].trim(), String.valueOf(value));
             	}
            	else
            	{
            		hs.put(split[i].trim(), split[i+1].trim());	
            	}
             }
             Map<String,String> sortedValue = sortByKey(hs,true);  
        	for(Map.Entry<String, String> v : sortedValue.entrySet())
        	{
        		printed = printed + ", "+v.getKey()+", "+v.getValue();
        	}
        	
        		
        		System.out.println(printed);
        	
        }
        
       
               
        
    }
}