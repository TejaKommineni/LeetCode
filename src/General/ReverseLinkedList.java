
class Node
{
int data;
Node next;
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public Node getNext() {
	return next;
}
public void setNext(Node next) {
	this.next = next;
}

}

public class ReverseLinkedList {
	
	
	
	
	public static void main(String[] args) {
		
		Node root = new Node();
		root.data=1;
		Node next = new Node();
		next.data=2;
		root.next=next;
		 next = new Node();
			next.data=3;
			root.next.next=next;
			 next = new Node();
				next.data=4;
				root.next.next.next=next;
	
				Node rev=reverse(root);
				
				rev=recReverse(root);
				
				while(rev!=null)
				{
					System.out.print(rev.data);
					rev=rev.next;
				}
	}

	private static Node recReverse(Node root) {
		
		if(root==null||root.next==null)
			return root;
		
		
		return recReverse(root.next);
		
		
	}

	private static Node reverse(Node root) {
		if(root==null || root.next==null)
			return root;
		
		Node temp= root.next;
		root.next=null;
		Node temp2=temp.next;
		temp.next=root;
		root=temp;
		while(temp2!=null)
		{
			temp=temp2.next;
			temp2.next=root;			
			root=temp2;
			temp2=temp;
		}
		return root;
		
	}

}
