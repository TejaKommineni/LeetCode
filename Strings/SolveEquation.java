package LeetCode.Strings;

public class SolveEquation {
	
	 public String solveEquation(String equation) {
	     
	        String leftHalf = equation.split("=")[0];
	        String rightHalf = equation.split("=")[1]; 
	        int a [] = evaluate(leftHalf);
	        int b [] = evaluate(rightHalf);
	        System.out.println(a[0] +" " +a[1]);
	        System.out.println(b[0] +" " +b[1]);
	        if(a[0] == b[0] && a[1] == b[1])
	            return "Infinite solutions";
	        else if(a[0] == b[0])
	            return "No solution";
	        else
	        {
	            int x = a[0]-b[0];
	            int y = b[1]-a[1];
	            if((x>0 && y>0) || (x<0 && y<0))
	                return "x="+(y/x);
	            else
	                return "x=-"+(y/x);
	        }
	        
	    }
	    
	    public int[] evaluate(String s)
	    {
 	        int ans[] = new int[2]; 
	        int sign =1,result = 0;
	        for(int i=0;i<s.length();i++)
	        {
	            if(s.charAt(i) == 'x')
	            {
	                if(result == 0)
	                    ans[0] = ans[0] +sign * 1;
	                else                   
	                    ans[0] = ans[0] + sign*result;
	                sign =1;
	                result =0;
	            }
	            else if(s.charAt(i) == '+')
	            {
	                ans[1] = ans[1] + result *sign;
	                sign =1;
	                result =0;
	            }    
	            else if(s.charAt(i) == '-')
	            {
	                ans[1] = ans[1] + result *sign;
	                sign =-1;
	                result =0;
	            }    
	            else
	                result = result*10 + s.charAt(i)-'0';
	            
	        }      
	        ans[1] = ans[1] + result*sign;
	        return ans;
	    }        
	    
	    
	    public static void main(String[] args) {
			SolveEquation s = new SolveEquation();
			s.solveEquation("x+5-3+x=6+x-2");
					
		}

}
