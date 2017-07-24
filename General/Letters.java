package LeetCode.General;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Letters {
    
    public static void main(String[] args) {
        
    	
    	String s="-23465";
    	int number = 0;
    	int j=0;
    	for(int i=s.length()-1;i>=0;i--)
    	{
    		if(s.charAt(i)=='-' && i-1<0)
    		{
    			 System.out.println(number-2*number);
    		}
    		
    		number=number+(int)Math.pow(10, j)*(s.charAt(i)-'0');
    	 System.out.println(number);
    	 j++;
    		
    	}
    	
    	
    	String input = "tree";           
        
        Map<Character, Integer> letterFrequency = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLetter(c))
                continue;
            if (letterFrequency.containsKey(c)) {
                int frequency = letterFrequency.get(c);
                letterFrequency.put(c, ++frequency);
            } else
                letterFrequency.put(c, 1);
        }
        List<Entry<Character, Integer>> letters =
                new ArrayList<Entry<Character, Integer>>(letterFrequency.entrySet());
        Collections.sort(letters, new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1,
                               Entry<Character, Integer> o2) {
                Float diff = Math.signum(o2.getValue() - o1.getValue());
                return diff.intValue();
            }
        });
        for (Entry<Character, Integer> letter : letters)
            System.out.printf("%s: %2d%n", letter.getKey(), letter.getValue());
    }
    
}