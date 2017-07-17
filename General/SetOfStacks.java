import java.util.ArrayList;
import java.util.Stack;


public class SetOfStacks {
	final int  threshold =3;
	int count=0;
	ArrayList<Stack> as = new ArrayList<Stack>();
	
	public void push(int value)
	{
		value++;
		count++;
		if(((count-1) % threshold) == 0)
		{
			Stack s = new Stack();
			s.push(value);
			as.add(s);			
		}
		else
		{
			Stack s=as.get((count-1)/threshold);
			s.push(value);
		}
	}

	public int pop()
	{
		
		Stack s=as.get((count-1)/threshold);
		count--;
		return (int)s.pop();
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		SetOfStacks ss= new SetOfStacks();
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.push(1);
		ss.pop();
		ss.push(2);
		ss.push(3);
		ss.push(7);
		ss.push(2);
		ss.push(5);
		int value=10;
		ss.push(10);
		System.out.print(value);
		ss.pop();
		
		
		
	} 
	
}
