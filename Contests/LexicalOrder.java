package LeetCode.Contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LexicalOrder {

	public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> s = new Stack<Integer>();
        if(n<=9)
        {
          for(int i=1;i<=n;i++)
            {
                result.add(i);
            } 
        
          return result;
        }
        else
        {
            for(int i=9;i>=1;i--)
            {
                s.push(i);
            } 
            
            while(!s.isEmpty())
            {
             int temp = s.pop();  
             for(int i=9;i>=0;i--)
             {
                 int local = temp*10+i;
                 if(local<=n)
                 s.push(local);
             }
             result.add(temp);
            }
        
        System.out.println(result);
        }
        return result;
    }
	
	public static void main(String[] args) {
		
		LexicalOrder l = new LexicalOrder();
		l.lexicalOrder(103);
	}
	
}
