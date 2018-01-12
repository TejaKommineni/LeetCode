package LeetCode.DFS;

import java.util.Stack;

class DecodeString {
    public String decodeString(String s) {        
        
        return dfs(s);
        
    }
    
    
    public String dfs(String s)
    {
    	String ans = "";
    	Stack<Character> st = new Stack<Character>();
    	for(int i=0;i<s.length();i++)
    	{
    		if(s.charAt(i) == ']')
    		{
    			char c;
    			String temp = "";
    			while((c = st.pop()) != '[')
    			{
    				temp = c + temp;
    			}
    			c = st.pop();
    			while(c <= '0' && c >='9')
    			{
    				
    			}
    		}
    		else
    		{
    			st.push(s.charAt(i));
    		}
    	}
    }
    
    public static void main(String[] args) {
		
    	DecodeString d = new DecodeString();
    	System.out.println(d.decodeString("3[a2[c]]"));
	}
}
