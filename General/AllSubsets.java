package LeetCode.General;
import java.util.ArrayList;

public class AllSubsets
{
	
	ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
	ArrayList<ArrayList<Integer>> allsubsets;
	 if (set.size()== index) {//Base case - add empty set
	 allsubsets = new ArrayList<ArrayList<Integer>>();
	 allsubsets.add(new ArrayList<Integer>()); // Empty set
	 } else {
	 allsubsets = getSubsets(set, index+ 1);
     int item= set.get(index);
	 ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
	 for (ArrayList<Integer> subset : allsubsets) {
	 ArrayList<Integer> newsubset = new ArrayList<Integer>();
	 newsubset.addAll(subset); //
	 newsubset.add(item);
	 moresubsets.add(newsubset);
	 }
	 allsubsets.addAll(moresubsets);
	 }
	 return allsubsets;
	 }

	public static void main(String[] args) {
		
		AllSubsets as = new AllSubsets();
		ArrayList ai = new ArrayList();
		ai.add(1);ai.add(2);ai.add(3);
		System.out.println(as.getSubsets(ai,0));
	}

}