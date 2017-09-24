package LeetCode.Contests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Contest51 {



    public String nextClosestTime(String time) {
        
        List <Integer> li = new ArrayList();
        li.add(time.charAt(0)-'0');
        li.add(time.charAt(1)-'0');
        li.add(time.charAt(3)-'0');
        li.add(time.charAt(4)-'0');
        Collections.sort(li);
        List<String> allTimes = new ArrayList();
        generateAllTimes(li,"", allTimes);
        Collections.sort(allTimes);
        int min = Integer.MAX_VALUE;
        String answer  = "";
        int givenHours =  Integer.parseInt(time.substring(0,2)); 
        int givenMinutes =  Integer.parseInt(time.substring(3)); 
        for(int i=allTimes.size()-1;i>=0;i--)
        {
            String temp = allTimes.get(i);
            int temp1 = 0;
            int presentHours =  Integer.parseInt(temp.substring(0,2)); 
            int presentMinutes =  Integer.parseInt(temp.substring(2)); 
           
            if(presentHours == givenHours && presentMinutes == givenMinutes) 
            {	temp1 = 1440;
                }
            
                if(presentHours > givenHours)
                {
                    temp1 = (presentHours - givenHours)*60;
                    temp1 = temp1 + 60 - givenMinutes;
                    temp1 = temp1 + presentMinutes;
                }
                else if(presentHours == givenHours)
                {
                    if(presentMinutes>givenMinutes)                    
                    temp1 = temp1 + presentMinutes - givenMinutes;
                    else
                    {
                        temp1 = temp1 + 23*60 + presentMinutes + 60 - givenMinutes;
                    }   
                }
                else
                {
                    temp1 = (23 - givenHours)*60 + (presentHours)*60;
                    temp1 = temp1 + 60 - givenMinutes;
                    temp1 = temp1 + presentMinutes;
                }
               
            
            if(min > temp1)
            {
                min = temp1;
                answer = presentHours +":" + presentMinutes; 
                if(presentHours <10)
                	answer = "0"+answer; 
                if(presentMinutes <10)
                	answer = answer.substring(0,3) + "0"+presentMinutes;
            }
        }
        return answer;
    }
    
    public void generateAllTimes(List<Integer> li,String s,  List<String> allTimes)
    {
        if(s.length() == 4)
        {
            if(Integer.parseInt(s.substring(0,2))<24 && Integer.parseInt(s.substring(2))<59)
                allTimes.add(s);
            return;
        }
        for(int i=0;i<li.size();i++)
        {            
            generateAllTimes(li,s+li.get(i),allTimes);
        }
        
    }
    
 public int calPoints(String[] ops) {
        
        if(ops == null || ops.length == 0)
            return 0;
        
        Stack<Integer> s = new Stack();
        
        for(int i=0;i<ops.length;i++)
        {
            if(s.isEmpty() && (ops[i].equals("C") || ops[i].equals("D")))
                continue;
            if(ops[i].equals("+") && (s.isEmpty() || s.size() == 1))
                continue;
            if(ops[i].equals("C"))
                s.pop();
            else if(ops[i].equals("D"))
                s.push(2*s.peek());
            else if(ops[i].equals("+"))
            {
                int temp = s.pop();
                int temp1 = temp + s.peek();
                s.push(temp);
                s.push(temp1);
            }
            else 
                s.push(Integer.parseInt(ops[i]));
            
            
        }        
        int sum = 0;
        while(!s.isEmpty())
            sum = sum + s.pop();
        return sum;
    }
    public static void main(String[] args) {
		Contest51 cs = new Contest51();
		System.out.println(cs.nextClosestTime("00:00"));
	}
}