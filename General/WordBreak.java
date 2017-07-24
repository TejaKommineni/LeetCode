package LeetCode.General;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {

	
	public int wordBreak(String s, ArrayList<String> B) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state
        Set<String> dict = new HashSet<>(B);
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) 
                continue;
 
            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;
 
                if(t[end]) continue;
 
                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }
 
        return t[s.length()]?1:0;
    }


	public static void main(String[] args) {
		
		WordBreak wb = new WordBreak();
		
		String s = "codeleet";
		//System.out.println(s.substring(11,18));
		ArrayList<String> dict = new ArrayList<String>(Arrays.asList("leet", "code"));
		
		wb.wordBreak(s,dict);
		
		
	}
	
}
