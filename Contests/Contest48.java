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
	    
	    public int maximumSwap(int num) {
	        String number = String.valueOf(num);
	        boolean flag = false;
	        if(num<10)
	            return num;
	        int i=1;
	        for(;i<number.length();i++)
	        {
	            if(number.charAt(i-1)<number.charAt(i))
	            {
	                flag = true;
	                break;
	            }
	        }
	        if(!flag)
	            return num;
	        
	        int maxIndex = i;
	        int max = number.charAt(i) - '0';
	        for(int j=i;j<number.length();j++)
	        {
	            if(max<=(number.charAt(j)-'0'))
	            { max = (number.charAt(j) - '0');
	             maxIndex = j;
	            }
	        }
	        int j=0;
	        String s = "";
	        for(;j<i;j++)
	        {
	            if((number.charAt(j)-'0')<max)
	            {
	                break;}
	            s = s+number.charAt(j);
	        }
	        int swap = (number.charAt(j)-'0');
	        s = s + String.valueOf(max);
	        j++;        
	        for(;j<number.length();j++)
	        {
	            if(j == maxIndex)
	            {
	                s =s + String.valueOf(swap);
	            }
	            else
	            s = s+number.charAt(j);
	        }
	        
	        return Integer.parseInt(s);
	    }
	
	public static void main(String[] args) {
		Contest48 cs = new Contest48();
		
	}
}
