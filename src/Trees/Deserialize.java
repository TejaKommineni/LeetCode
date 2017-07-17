package Trees;

import java.util.Arrays;

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }

public class Deserialize {
	
	public TreeNode deserialize(String data) {
	    if(data == null)
	        return null;
	 
	    int t = 0;
	    String[] arr = data.split(",");
	 
	    return helper(arr, t);
	}
	 
	public TreeNode helper(String[] arr, int t){
	    if(arr[t].equals("#")){
	        return null;
	    }
	 
	    TreeNode root = new TreeNode(Integer.parseInt(arr[t]));
	 
	    t=t+1;
	    root.left = helper(arr, t);
	    t=t+1;
	    root.right = helper(arr, t);
	 
	    return root;
	}

	public static void main(String[] args) {
		Deserialize d = new Deserialize();
		String array[] = {"Hello", "This", "Is", "Sorting", "Example"};//{"10", "0001", "111001", "1", "0"};
		Arrays.sort(array);
		int a = "Hello".compareTo("Example");
		d.deserialize("10,7,4,1,#,#,5,#,#,9,8,#,#,#,16,14,#,15,#,#,18,#,19,#,#");
	}
	
}

