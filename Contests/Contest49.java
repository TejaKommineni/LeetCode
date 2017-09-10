package LeetCode.Contests;

import java.util.HashMap;
import java.util.Map;

public class Contest49 {
	
	
	
	public static void main(String[] args) {
		
		Contest49 cs = new Contest49();
		MagicDictionary mc = new MagicDictionary();
		mc.buildDict(new String[] {"a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"});
		System.out.println(mc.search("a"));
		System.out.println(mc.search("b"));
		System.out.println(mc.search("abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj"));
		
	}

}

class Trie
{
    char ch;
    HashMap<Character,Trie> children;
    boolean isLeaf;
    
    Trie(char c)
    {
        this.ch = c;
    }
   
}
class MagicDictionary {
	Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
         root = new Trie('.');
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str: dict)
        {
            Trie node = root;
            for(int i=0;i<str.length();i++)
            {
                if(node.children == null)
                {
                    node.children = new HashMap();
                    node.children.put(str.charAt(i),new Trie(str.charAt(i)));                    
                }
                else if(!node.children.containsKey(str.charAt(i)))
                {
                    node.children.put(str.charAt(i),new Trie(str.charAt(i)));                    
                }                
                node = node.children.get(str.charAt(i));
            }
            node.isLeaf = true;            
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return searchLetterExchanged(root,word,false);
    }
    
    public boolean searchLetterExchanged(Trie node, String word, boolean oneLetterExchanged)
    {
        
        for(int i=0;i<word.length();i++)
        {
          if(node.children == null)
              return false;
                                 
          if(!oneLetterExchanged)
          {
              boolean flag = false;
              for(Map.Entry<Character,Trie> e: node.children.entrySet())
              {
                  if(e.getKey() == word.charAt(i))
                      flag = searchLetterExchanged(e.getValue(),word.substring(i+1),false);
                  else                      
                      flag = searchLetterExchanged(e.getValue(),word.substring(i+1),true);
                  if(flag)
                      return true;
                  else 
                	  return false;
              }
          }
          
          if(node.children.containsKey(word.charAt(i))){                               
                node = node.children.get(word.charAt(i));
          }       
          else
          {
              return false;
          }            
        }
      return node.isLeaf && oneLetterExchanged;  
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */