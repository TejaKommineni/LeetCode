package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;


public class WordBreak {
	 List<String> li = new ArrayList();
	 String visited[];
    public List<String> wordBreak(String s, List<String> wordDict) {        
       visited = new String[s.length()];
        wordBroke(s,wordDict,0, "");
		return li;
        
    }
    
    public void wordBroke(String s, List<String> wordDict, int k, String target)
    {
        if(s.length() == k)
        {
            li.add(target.substring(1,target.length()));
            return;
        }
        
        for(int i=k+1; i<=s.length(); i++)
        {
          
			if(wordDict.contains(s.substring(k,i)))
            {
                wordBroke(s,wordDict,i,target+" "+s.substring(k,i));
            }
        }
    }
    
    public static void main(String[] args) {
    	WordBreak wb = new WordBreak();
    	List<String> wordDict = new ArrayList();    	
    	wordDict.add("cat");
    	wordDict.add("cats");
    	wordDict.add("and");
    	wordDict.add("sand");
    	wordDict.add("dog");
    	wb.wordBreak("catsanddog", wordDict);
    	
    	
	}
}