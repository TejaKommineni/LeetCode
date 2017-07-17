import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Anagram {
    public static int numberNeeded(String first, String second) {
      int numberNeeded=0;
        for(int i=0;i<first.length();i++)
            {
            for(int j=0;j<second.length();j++)
                {
         if((first.charAt(i))==(second.charAt(j))){
             char seconde[]=second.toCharArray();
             seconde[j]='0';
             second=new String(seconde);
             numberNeeded++;
                 break;   
                    
         }}
        }
        int x=first.length()-numberNeeded;
        x=x+second.length()-numberNeeded;
            
      return  x;
        
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
