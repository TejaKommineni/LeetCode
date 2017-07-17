package AdvancedAlgorithms;

public class EquivalenceTesting {

	private static void equivalence(int[] nums, int i, int j) {
		
		if(i<j)
		{
			int mid = (i+j)/2;
			equivalence(nums,i,mid);
			equivalence(nums,mid+1,j);
			equivalenceCount(nums,i,mid,j);
		}
		
		
	}
	
	
	
	private static void equivalenceCount(int[] nums, int i, int mid, int j) {
		
		
	}



	public static void main(String[] args) {		
		int nums[] = {};		
		equivalence(nums,0,nums.length);
		
	}

	
}
