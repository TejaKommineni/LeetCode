import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class DLLtoBST {
	static BNode head;
	
	
	public static BNode convertToBST(BNode first ,BNode last)
	{
		if(first == null && last == null)
			return first;
		
		if(first==last)
		{
			first.right=null;
			first.left=null;
			return first;
		}	
		
		BNode mid=first;
		BNode temp=first;
		while(temp!=last && temp.right!=last)
		{
			mid = mid.right;	
			temp = temp.right.right;
		}
		BNode left=convertToBST(first,mid.left);
		BNode right=convertToBST(mid.right,last);
		
		if(mid==left)
			mid.left= null;
		else
			mid.left=left;
		
		if(mid==right)
			mid.right= null;
		else
			mid.right=right;
		
		return mid;
		
	}
	
	public static void main(String[] args) {
		
		head=new BNode(1);
		insert(2);
		insert(3);
		insert(4);
		insert(5);
		insert(6);
		//insert(7);		
		BNode fastPointer = head;
		BNode slowPointer = head;
		while(fastPointer!=null && fastPointer.right!=null)
		{
			slowPointer = slowPointer.right;	
		    fastPointer = fastPointer.right.right;
		}
		BNode root=convertToBST(head,fastPointer);
		printInOrder(root);
		printLevelOrder(root);
	}

	private static void printLevelOrder(BNode root) {
		
		Queue<BNode> q = new LinkedList<BNode>() ;
		int nodeCount=0;
		q.add(root);
		
		if (root== null)
			return ;
			
		while(true)
		{
			nodeCount=q.size();
			if(nodeCount==0)
				break;
			
			
			while(nodeCount>0)
			{
				BNode node=q.poll();
				System.out.print(" "+node.data+" ");
				if(node.left!= null)
				q.add(node.left);
				if(node.right!= null)
				q.add(node.right);
				nodeCount--;
				
			}
			System.out.println("$");
			
		}		
		
		
		
	}

	private static void printInOrder(BNode node) {
		if (node == null)
		return;
		
		
		printInOrder(node.right);				
		System.out.println(node.data);
		printInOrder(node.left);
		
	}

	private static void insert(int i) {
		
		BNode prev=null;
		BNode current=head;
		while(current!=null)
		{
			prev=current;
			current=current.right;
		}	
		BNode node =new BNode(i);
		prev.right=node;
		node.left=prev;
		
	}

}
