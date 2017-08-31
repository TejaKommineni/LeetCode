package LeetCode.Strings;

public class ISNumber {
	
	 public boolean isNumber(String s) {
	        
         if(s == null)
            return false;
 
         s = s.trim();
         boolean pointSeen = false, eSeen = false;
         boolean numberSeen = false;
         for(int i=0;i<s.length();i++)
         {
             if(s.charAt(i) == ' ')
                 continue;
             
             if(s.charAt(i) == '+' || s.charAt(i) == '-')
             {
                 if(i-1<0 || s.charAt(i-1) != 'e')
                     return false;
             }
             if((s.charAt(i) == 'e' ||  s.charAt(i) == '.') && eSeen)
                  return false;
             if((s.charAt(i) == '.'  && (eSeen||pointSeen)))
                  return false;
             if((s.charAt(i) == 'e' ||  s.charAt(i) == '.')  && (!numberSeen))
                  return false;
             if(s.charAt(i) == '.')    
                 pointSeen = true;
             if(s.charAt(i) == 'e')    
                 eSeen = true;  
             if(s.charAt(i) <= '9' && s.charAt(i) >= '0' )    
                 numberSeen = true;  
             else
                return false;
         }
 
         return true;
         
 
}

}
