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
	
	
	
	public static void main(String[] args) {
		Contest48 cs = new Contest48();
		
	}
}
