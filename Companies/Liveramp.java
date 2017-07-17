package Companies;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Liveramp {
    public String solution(int A, int B, int C, int D) {
        
    	String s = String.valueOf(A)+ String.valueOf(B)+String.valueOf(C)+String.valueOf(D);
        List<String> possibilities = new ArrayList(); 
        combinations(s, possibilities, "");
        Collections.sort(possibilities);
       
        for(int i=possibilities.size()-1;i>=0;i--)
        {
        	String temp= possibilities.get(i);
        	String lastTwoDigits = temp.substring(2, 4);
        	if(Integer.valueOf(lastTwoDigits)<=59)
        	{
        		return temp.substring(0, 2)+":"+lastTwoDigits;
        	}
        	
        }
          
        return "NOT POSSIBLE";
        
    }

	private void combinations(String s, List possibilities, String target) {
	
		if(s.length()==0)
		{
			if(Integer.parseInt(target)<=2359)
			{
			possibilities.add(target);
			}
		}
		for(int i=0;i<s.length();i++)
		{
			target=target+s.charAt(i);
			String newString = s.substring(0, i)+ s.substring(i+1, s.length());
			combinations(newString,possibilities,target);
			target=target.substring(0,target.length()-1);
		}
		
	
	}
    
	public static void main(String[] args) {
		Liveramp l = new Liveramp();
		System.out.println(l.solution(9, 1, 7, 9));
	} 
	
	
    
}