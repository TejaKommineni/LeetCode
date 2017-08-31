package LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class UniquePaths {
	 public int uniquePaths(int m, int n) {
	        int ans[][] = new int[m][n];
	        ans[0][0] =1;
	        for(int i=0;i<m;i++)
	        {
	            for(int j=0;j<n;j++)
	            {
	                if(i==0 || j ==0)
	                    ans[i][j] = 1;
	                else              
	                    ans[i][j] = ans[i-1][j]+ans[i][j-1];
	                
	            }
	        }
	        return ans[m-1][n-1];
	        
	    }
	
	 public int maxPoints(Point[] points) {
	        if(points.length <= 0) return 0;
	        if(points.length <= 2) return points.length;
	        int result = 0;
	        for(int i = 0; i < points.length; i++){
	            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
	            int samex = 1;
	            int samep = 0;
	            for(int j = 0; j < points.length; j++){
	                if(j != i){
	                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
	                        samep++;
	                    }
	                    if(points[j].x == points[i].x){
	                        samex++;
	                        continue;
	                    }
	                    double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
	                    if(hm.containsKey(k)){//0.9999999894638303
	                        hm.put(k,hm.get(k) + 1);
	                    }else{
	                        hm.put(k, 2);
	                    }
	                    result = Math.max(result, hm.get(k) + samep);
	                }
	            }
	            result = Math.max(result, samex);
	        }
	        return result;
	    }


	 public static void main(String[] args) {
		Solution s = new Solution();
		UniquePaths u = new UniquePaths();
		
		Point p1 = new Point(94911151,94911150);Point p2 = new Point(94911152,94911151);
		Point p3 = new Point(0,0);
		u.maxPoints(new Point[] {p3,p1,p2});
		s.findSubstring("abababab", new String[] {"ab","ba"});
	}
}

 class Solution {
	 
	 //168/169 test cases passed
	 
	 
    public List<Integer> findSubstring(String s, String[] words) {
        
         List<Integer> li = new ArrayList();
        List<String> wordList = Arrays.asList(words);
        String p="";
        int wordSize=0;
         for(int j =0;j<words.length;j++)
        {
          p =p+words[j];
          wordSize = words[j].length();   
         }
        
        if(s.length()<p.length()) return li;
        
        
        
        int [] alpha = new int[256];
        for(int i=0;i<p.length();i++)
        {
            int temp = p.charAt(i);
            alpha[temp] = alpha[temp]+1;
        }
        int i=0, begin =0;
        int count=p.length();
        while(i<s.length())
        {
            if(alpha[s.charAt(i++)]-->0) count--;
            
            while(count==0)
            {
                if(i-begin == p.length())
                    li.add(begin);
                
                if(alpha[s.charAt(begin++)]++>=0) count++;
            }
        }
        List<Integer> ans = new ArrayList();
       
        for(i=0;i<li.size();i++)
        {
            boolean flag = true;
            List<String> tempList = new ArrayList(wordList);
            for(int j=li.get(i);j<li.get(i)+p.length();)
            {
                
                if(!tempList.contains(s.substring(j,j+wordSize)))
                {
                    flag = false;
                    break;
                }
                else
                {
                    tempList.remove(s.substring(j,j+wordSize));
                }
                j =j+wordSize;
            }
                   if(flag)
                   ans.add(li.get(i));
        }
        return ans;
    
    
    }
}