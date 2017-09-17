package LeetCode.Contests;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



class MapSum {

    /** Initialize your data structure here. */
	class Trie
	{
	    char ch;
	    HashMap<Character,Trie> children;
	    boolean isLeaf;
	    Integer n;
	    Trie(char c)
	    {
	        this.ch = c;
	    }
	   
	}
	
    Trie root;
    public MapSum() {
        root = new Trie('.');
    }
    
    public void insert(String key, int val) {      
      
            
            Trie node = root;
            for(int i=0;i<key.length();i++)
            {
                if(node.children == null)
                {
                    node.children = new HashMap();
                    node.children.put(key.charAt(i),new Trie(key.charAt(i)));
                    //node.n = val;
                }
                else if(!node.children.containsKey(key.charAt(i)))
                {
                    node.children.put(key.charAt(i),new Trie(key.charAt(i)));       
                    //node.n = node.n+val;
                }                
                node = node.children.get(key.charAt(i));
            }
            node.isLeaf = true;   
            node.n = val;
             
    }
    
    public int sum(String prefix) {
     
        int sum =0;
        Trie node = root;
        boolean flag = false;
        for(int i=0;i<prefix.length();i++)
        {
            if(node.children != null && node.children.containsKey(prefix.charAt(i)))
            {
                node = node.children.get(prefix.charAt(i));
            }
            else
            {
                flag = true;
                break;
            }            
        }    
        
        if(flag)
            return 0;
        
        else
        {
           return sum + dfs(node);
            
        }
        
    }
    
    public int dfs(Trie node)
    {
        int sum =0;
        if(node.isLeaf)
            sum = sum + node.n;
        
        if(node.children == null)
            return sum;
        
        for(Map.Entry<Character,Trie> e: node.children.entrySet())
        {
            sum = sum+ dfs(e.getValue());
        }
        return sum;    
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

public class Contest50 {
	
	 public boolean checkValidString(String s) {
	        Stack<Character> stack = new Stack();
	        int star =0;
	        for(int i=0;i<s.length();i++)
	        {
	            if(s.charAt(i) == '*')
	                star++;
	            else if(s.charAt(i) == ')')
	            {
	                if(stack.isEmpty() && star == 0)
	                    return false;
	                else if(!stack.isEmpty())
	                    stack.pop();
	                else 
	                    star--;
	            }
	            else
	                stack.push('(');
	        }
	        
	        
	        return stack.isEmpty() || stack.size() == star;
	    }
	
	
	 public boolean validPalindrome(String s) {
	        
	        return isPalindrome(s,false);
	        
	    }
	    public boolean isPalindrome(String s, boolean flag)
	    {
	        int i=0; 
	        int j=s.length()-1;
	        while(i<=j)
	        {
	            if(s.charAt(i) != s.charAt(j) && flag)
	                return false;
	            if(s.charAt(i) != s.charAt(j))
	                return isPalindrome(s.substring(0,i)+s.substring(i+1),true) || isPalindrome(s.substring(0,j)+s.substring(j+1),true);
	            
	            i++;
	            j--;
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		Contest50 cs = new Contest50();
		//System.out.println(cs.validPalindrome("abca"));
		MapSum ms = new MapSum();
		
		ms.insert("a", 3);
		//System.out.println(ms.sum("ap"));
		ms.insert("b", 2);
		//System.out.println(ms.sum("a"));
		System.out.println(cs.checkValidString("*(()"));
	}

}
