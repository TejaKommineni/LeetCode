import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {
    
public float median(int[] a,int n)
{
    mergeSort(a,0,n);    
   
    int totalLength=n;
    if(totalLength%2==0)
     return((float)(a[totalLength/2]+a[(totalLength/2)-1])/2);
    else
     return((float)a[(totalLength/2)]);
    
}
    
 public void mergeSort(int[] a, int low, int high)
 {
     int mid=(low+high)/2;
     if(low<mid)
     {         
         mergeSort(a, low,mid);
         mergeSort(a,mid,high);
         sort(a,low,mid,high);   
     }
     
 }
    
 public void sort(int[] a, int low, int mid, int high)
   {
     int i=low;
     int j=mid;
     int k=0;
     int b[] =new int[high];

     while(i<mid && j<high)
     {
      if(a[i]>=a[j])
        {
          b[k]=a[j];
          k++;
          j++;
        } 
      else 
        {
          b[k]=a[i];
          k++;
          i++;
        }              
     }
     
     
      while(i<mid)  
          {
          b[k]=a[i];
          k++;
          i++;
     }
      while(j<high)  
          {
          b[k]=a[j];
          k++;
          j++;
     }
     
     for(i=0;i<k;i++)
     {
         a[low]=b[i];
         low++;
     }
     
     
     
     
 }  
     
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            RunningMedian s= new RunningMedian();
            System.out.println(s.median(a,a_i+1));
            
            
            
        }
    }
}
