import java.text.DecimalFormat;
import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
	
    	double a =2;
    	
    	DecimalFormat decim = new DecimalFormat("0.00");
    	Double price2 = Double.parseDouble(decim.format(a));
    	System.out.println("teja+"
    			+ "");
    	MinStack m = new MinStack();
    	m.push(3);
    	m.push(6);
    	m.push(9);
    	m.pop();
    	m.getMin();
    	m.push(-1);
    	m.push(2);
    	m.push(-2);
    	m.push(-1);
    	m.push(-3);
    	m.push(-4);
    	m.pop();
    	m.pop();
    	m.pop();
    	m.pop();
    	m.getMin();
    	m.getMin();
    	m.getMin();
    	
    	
	}
}