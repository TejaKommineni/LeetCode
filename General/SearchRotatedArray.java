
package LeetCode.General;
public class SearchRotatedArray {
	
	
	public static void main(String[] args) {
		
		int[] arr= {14,15,16, 19, 20, 25, 1, 3, 4, 5, 7, 10};
		search(arr,5);
		System.out.println("string".compareToIgnoreCase(""));
		
	}

	private static int search(int[] arr,int find) {
		
		int low=0;
		int high=arr.length-1;
		
		while(high>=low)
		{
			int mid= (high+low)/2;
			if(arr[mid]==find)
				return mid;
			if(arr[mid]>find && arr[low]<=find)
			{
				high=mid;
			}
			else
			{
				low=mid+1;
			}							
		}	
		return -1;
		
	}

}
