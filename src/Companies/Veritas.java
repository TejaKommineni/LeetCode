package Companies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Veritas {
	
	

    static int reductionCost(int[] num) {
        
    	int sum =0;       
        ArrayList<Integer> ai = new ArrayList();       
        for(int i=0;i<num.length;i++)
        {
        	ai.add(num[i]);
        }
        
        while(ai.size()!=1)
        {
        	Collections.sort(ai);
        	int a = ai.get(0);
        	int b =ai.get(1);
        	sum = sum+ a+b ;
        	ai.remove(0);
        	ai.remove(0);
        	ai.add(0, a+b);
        	
        }
        
                
        
        return sum;   


    }

    
	 static String rollingString(String s, String[] operations) {
         
		 StringBuilder s1 = new StringBuilder(s);
	        for(int i=0;i<operations.length;i++)
	         {
	            String operation[] =  operations[i].split(" ");
	            int k = Integer.parseInt(operation[0]);
	            int j = Integer.parseInt(operation[1]);
	            String direction = operation[2];
	            if(direction.equals("L"))
	               {
	                while(k<=j)
	                 {
	                    char c = s1.charAt(k);
	                    if(c =='a')
	                    	s1.insert(k, 'z');	                   
	                    else
	                    	s1.insert(k, (char)(c-1));
	                    s1.deleteCharAt(k+1);
	                    
	                    k++;
	                }
	            }
	            if(direction.equals("R"))
	               {
	            	while(k<=j)
	                 {
	                    char c = s1.charAt(k);
	                    if(c =='z')
	                    	s1.insert(k, 'a');
	                    else
	                    	s1.insert(k, (char)(c+1));
	                    s1.deleteCharAt(k+1);	
	                    k++;
	                }
	               }
	                
	            }
	        return s1.toString();
            
	           
	        }
	
	public static void main(String[] args) {
		
		Veritas v = new Veritas();
		int num[] ={1,2,3,4};
		v.reductionCost(num);
		String operations[] =  {"0 0 L","2 2 L","0 2 R"};
		v.rollingString("abc", operations);
		int s=0;
		while(s++<10)
		{
			if(s<4 && s<9)
				continue;
			else
				System.out.print(s);
		}
		
	}

}
