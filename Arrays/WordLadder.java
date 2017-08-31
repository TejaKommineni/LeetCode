package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Word 
{
    String word;
    int steps;
    
    public  Word(String word, int steps)
    {
        this.word =word;
        this.steps = steps;
    }
}
    
public class WordLadder {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
     
        List<List<String>> ans = new ArrayList();
        if(beginWord.equals(endWord))
            return ans;
        
        Queue<Word> q = new LinkedList();
        q.add(new Word(beginWord,1));
        int min = Integer.MAX_VALUE;
        HashMap<String, List<String>> dfsList = new HashMap();
        while(!q.isEmpty())
        {
            Word presentWord = q.poll();
            if(presentWord.steps>min)
                break;
            for(int i=0;i<presentWord.word.length();i++)
            {                
                for(int j = (int)'a' ;j<=(int)'z';j++)
                {
                    if(presentWord.word.charAt(i) != (char)j)
                    {
                     char [] wordArray = presentWord.word.toCharArray();
                     wordArray[i] = (char)j;
                     String nextWord = new String(wordArray);
                     if(endWord.equals(nextWord))
                     {
                        if(min>presentWord.steps+1)
                        {
                            min = presentWord.steps+1;
                        }
                        List<String> tempList = new ArrayList();
                        tempList.add(endWord);
                        dfsList.put(presentWord.word,tempList);
                     }
                     else if(wordList.contains(nextWord))
                     {
                         q.add(new Word(nextWord,presentWord.steps+1));
                         wordList.remove(nextWord);
                         if(dfsList.containsKey(presentWord.word))
                            dfsList.get(presentWord.word).add(nextWord);
                         else{                             
                            List<String> tempList = new ArrayList();
                            tempList.add(nextWord);
                            dfsList.put(presentWord.word,tempList);
                      }       
                     }
                        
                    }
                }                
            }               
                
            
        }
        List<String> sub = new ArrayList();sub.add(beginWord);
        backtrack(dfsList, ans,sub, beginWord, min);
        
        return ans;
    }
    
    public void backtrack(HashMap<String,List<String>> dfsList, List<List<String>> ans,List<String> temp, String currentWord, int min)
    {
        if(min == temp.size())
        {
            ans.add(new ArrayList(temp));
        }
        else
        {
            List<String> tempList = dfsList.get(currentWord);
            if(tempList != null) {
            for(int i=0;i<tempList.size();i++)
            {
                temp.add(tempList.get(i));
                backtrack(dfsList, ans,temp,tempList.get(i),min);
                temp.remove(temp.size()-1);
            }
            }
        }
    }
 public boolean isPerfectSquare(int num) {
        
        int low = 0;
        int high = num;
        if(num == 0)
            return false;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            long product = (long) mid*mid;
            if(product > Integer.MAX_VALUE)
            	high = mid-1;
            else if(mid*mid == num)
                return true;
            else if(mid*mid >num)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
		WordLadder wd = new WordLadder();
		List<List<Integer>> temp = new ArrayList(10); 
		temp.get(1).size();
		
		wd.isPerfectSquare(2147395600);
		List wordList = new ArrayList();
		wordList.add("hot"); wordList.add("dog");
		wd.findLadders("hot", "dog", wordList);
	}
} 