import java.io.*;
import java.util.*;

public class Candies {

    public static void main(String[] args) {
    
        Scanner sc  = new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int memo[] = new int[n];
        int arr[]= new int[n];
        for(int i=0;i<n;i++)
        {
             arr[i]=sc.nextInt();                 
            
        }
        
        memo[0]=arr[0]>arr[1]?2:1;
       
          
         for(int i=1;i<n;i++)
        {            
           memo[i]=arr[i]>arr[i-1]?memo[i-1]+1:1;   
          
        }
         sum=memo[n-1];
         for(int i=n-2;i>=0;i--)
         {            
            memo[i]=(arr[i]>arr[i+1]) && (memo[i+1]>=memo[i])?memo[i+1]+1:memo[i];       
           
            sum=sum+memo[i];
         } 
               
        System.out.println(sum);
   }
}

