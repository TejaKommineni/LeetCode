import java.util.LinkedList;
import java.util.Queue;

class MyStack {

//one Queue solution
private Queue<Integer> q = new LinkedList<Integer>();

// Push element x onto stack.
public void push(int x) {
    q.add(x);
    for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
        q.add(q.poll());
    }
}

// Removes the element on top of the stack.
public void pop() {
    q.poll();
}

// Get the top element.
public int top() {
    return q.peek();        
}

// Return whether the stack is empty.
public boolean empty() {
    return q.isEmpty();
}


public static void main(String[] args) {
	
	MyStack ms = new MyStack();
	ms.push(1);
	ms.push(7);
	ms.push(6);
	ms.push(4);
}
}