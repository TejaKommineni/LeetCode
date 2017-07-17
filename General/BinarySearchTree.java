class BNode
{
	BNode(int data)
	{
		this.data=data;
	}
	int data;
	BNode left;
	BNode right;
}

public class BinarySearchTree
{
	public static BNode root;	
	public static int count;
	public void insertNode(int data)
	{		
		BNode node = new BNode(data);
		if(root == null)
		{
			root=node;
		}
		else
		{   BNode previous=null;
		    BNode current=root;
			while(current!=null)
			{		
				previous=current;
				if(current.data>data)
					current=current.left;
				else
					current=current.right;
								
			}
			if(previous.data>data)
				previous.left=node;
			else
				previous.right=node;
		}
		
	}
	
	public static void main(String[] args) {
		
		BinarySearchTree bst = new  BinarySearchTree();		
		bst.insertNode(3);
		bst.insertNode(2);
		bst.insertNode(1);
		bst.insertNode(4);
		bst.insertNode(5);
		bst.insertNode(6);
		bst.printInOrder(root);
//		BNode capture=bst.convertToLinkedList(root);		
//		while(capture!=null)
//		{
//			
//			System.out.print(capture.data);
//			capture=capture.right;
//		}
		bst.addGreaterKeys(root,0);
		//bst.printInOrder(root);
				
	}

	private void printInOrder(BNode node) {
		if (node == null)
		return;		
		
		printInOrder(node.right);
		count++;
		if(count==2)			
		System.out.println(node.data);
		printInOrder(node.left);
		
	}
	
	private BNode convertToLinkedList(BNode current)
	{
		if(current == null)
		{
			return current;
		}
		
		BNode left=convertToLinkedList(current.left);
		BNode right=convertToLinkedList(current.right);
		
		if(left==null && right==null)
			return current;
		if(left==null)
		{
			current.right=right;
			return current;
		}	
		BNode temp=left;
		while(temp.right!=null)
		{
			temp=temp.right;
		}
		temp.right=current;
		current.left=null;
		current.right=right;
		return left;
	}
	
	private int addGreaterKeys(BNode node,int data)
	{
		if(node==null)
			return 0;
		
		 int right=addGreaterKeys(node.right,data);
		 int temp=node.data+right+data;
		 System.out.print(temp+" ");
		 int left = addGreaterKeys(node.left,temp);		
		
		 return temp+left;
		
	}
	
}