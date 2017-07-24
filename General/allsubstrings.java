package LeetCode.General;
import java.util.ArrayList;
import java.util.Arrays;


public class allsubstrings {
	static void buildSubsequences(String s) {
       
		ArrayList<String> set = new ArrayList<String>() ;
		for(int i=0;i<s.length();i++)
		{
			set.add(String.valueOf(s.charAt(i)));
		}
		
		ArrayList<ArrayList<String>> allSubsets =getSubsets(set,0);
		String answer [] = new String[allSubsets.size()-1];
		int count =0;
		for(int i=0;i<allSubsets.size();i++)
		{
			ArrayList<String> local = allSubsets.get(i);
            String k="";
			for(int j=0;j<local.size();j++)
			{
				k=k+local.get(j);
			}
		  if(!k.equals(""))
		  {
			answer[count]=k;
			count++;
		  }
			  
		}
		Arrays.sort(answer);
		System.out.println(answer);
	}


	static ArrayList<ArrayList<String>>  getSubsets(ArrayList<String> set, int index) {
	ArrayList<ArrayList<String>> allsubsets;
	 if (set.size()== index) {//Base case - add empty set
	 allsubsets = new ArrayList<ArrayList<String>>();
	 allsubsets.add(new ArrayList<String>()); // Empty set
	 } else {
	 allsubsets = getSubsets(set, index+ 1);
     String item= set.get(index);
	 ArrayList<ArrayList<String>> moresubsets = new ArrayList<ArrayList<String>>();
	 for (ArrayList<String> subset : allsubsets) {
	 ArrayList<String> newsubset = new ArrayList<String>();
	 newsubset.addAll(subset); //
	 newsubset.add(item);
	 moresubsets.add(newsubset);
	 }
	 allsubsets.addAll(moresubsets);
	 }
	 return allsubsets;
	 }

	
	
	
	public static void main(String[] args) {
		
		buildSubsequences("abc");
	}
}
