package Contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

 class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

public class Contest38 {
	

    int count =0;
    int width =0;
    boolean used[];
    public boolean makesquare(int[] nums) {
        count =0;
        int sum=0;
        used = new boolean[nums.length];
        for(int x:nums){
            sum=sum+x;
        }
        if(sum%4!=0||nums.length<4) return false;
        width=(sum/4);
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
          if(!used[i])    
          checkSquare(nums,0,i);
        } 
        return count == 4;
        
    }
    
    public boolean checkSquare(int[] nums,int sum, int id)
    {
        if(sum == width)
        {        
        count++;
        return true;
        }
        if(sum>width)
        return false;
        for(int i=id;i<nums.length;i++)
        {
            if(!used[id])
            {
                used[id] = true;
                if(checkSquare(nums,sum+nums[i],id+1))
                return true;
                used[id] =false;
            }
        }
        
        return false;
    }

public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final TreeNode left = root.left,
                right = root.right;
        root.left.val = 100;
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
	
	
	public static void main(String[] args) {
		
		List<Integer> li = new ArrayList(); 
		li.add(100);
		List li1 = li;
		li.add(200);
		
		Contest38 c =  new Contest38();
		c.makesquare(new int[]{3,3,3,3,1,1,1,1});
		
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4); root.right = new TreeNode(6);
		c.invertTree(root);
		int[][] courses = null;
		 Arrays.sort(courses, new Comparator<int[]>(){
	         
	            public int compare(int[] a ,int[] b)
	            {
	            	return a[0]-b[0];
	            }
	        });
		
	}
}
