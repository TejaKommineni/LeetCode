import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    public static boolean isBalanced(String expression) {
        HashMap opening = new HashMap();
        opening.put('(',1);
        opening.put('{',2);
        opening.put('[',3);
        
        HashMap closing = new HashMap();
        closing.put(')',1);
        closing.put('}',2);
        closing.put(']',3);
        
        Stack s= new Stack();
        
        for(int i=0;i<expression.length();i++)
         {
            if(opening.containsKey(expression.charAt(i)))              
            s.push(opening.get(expression.charAt(i)));
            if(closing.containsKey(expression.charAt(i)))
             {	int peek = 0;
                if(!s.isEmpty()){
           peek =(int)s.peek();
                }
                else
                {
                	return false;
                }
                if(peek==(int)closing.get(expression.charAt(i)))
                    s.pop();
                else
                    return false;
                
            }
            
         }
        
       if(s.isEmpty())
           return true;
        else
            return false;
        
     }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
