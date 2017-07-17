

	 class ListNode {
	     int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
public class list {

	    public ListNode partition(ListNode head, int x) {
	        
	        if(head == null) return head;
	        
	        ListNode past = new ListNode(0);	 
	        past.next=head;
	        ListNode temp = past;
	        ListNode prev = head;
	        if(head.val<x)
	        {
	         head = head.next;
	        }  
	        while(head.next !=null)
	        {
	            if(head.val<x)
	            {  
	                prev.next = head.next;
	                head.next = past.next;
	                past.next = head;
	                past = head;
	                head = prev;
	                
	            }
	            prev = head;
	            head= head.next;
	            
	        }
	        if(head.val<x)
	        {
	         prev.next = head.next;
	         head.next = past.next;
	         past.next = head;
	        }    
	        
	      return temp.next;    
	        
	    
	}
	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode temp1 = new ListNode(4);
		ListNode temp2 = new ListNode(3);
		ListNode temp3 = new ListNode(2);
		ListNode temp4 = new ListNode(5);
		ListNode temp5 = new ListNode(2);	
		head.next=temp1;
		temp1.next = temp2;
		temp2.next = temp3;
		temp3.next = temp4;
		temp4.next = temp5;
		temp5.next = null;
//		ListNode head = new ListNode(2);
//		ListNode temp1 = new ListNode(1);
//		head.next=temp1;
//		temp1.next=null;
		list s = new list();
		s.partition(head, 3);
		
	}
}
