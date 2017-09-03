package LeetCode.Contests;

import java.util.TreeSet;

public class Contest48 {

	 TreeSet<Integer> tr = new TreeSet();
	    public int findSecondMinimumValue(TreeNode root) {
	        
	        inorder(root);
	        if(tr.size()>=2)            
	        {
	            int index = 0;
	            for(Integer element : tr){
	             if(index == 1){
	                 return element;
	                }
	            index++;
	             }
	        }
	        else
	        {
	        	return -1;
	        }
			return 0;
	    }
	    
	    public void inorder(TreeNode node)
	    {
	        if(node == null)
	            return ;
	        
	        inorder(node.left);
	        tr.add(node.val);
	        inorder(node.right);
	            
	        
	    }
	
	    public TreeNode trimBST(TreeNode root, int L, int R) {
	        
	        if(root == null)
	            return root;
	        if(root.val >= L && root.val <= R)
	        {
	            root.left = trimBST(root.left,L,R);
	            root.right = trimBST(root.right,L,R);
	            return root;
	        }
	        else if(root.val<L)
	        {
	            return trimBST(root.right,L,R);
	        }
	        else
	            return trimBST(root.left,L,R);
	        
	    }
	
	public static void main(String[] args) {
		Contest48 cs = new Contest48();
		
	}
}
