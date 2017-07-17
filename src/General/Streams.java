import java.util.LinkedList;
import java.util.Queue;


public class Streams {
	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		System.out.println(r.totalMemory());
		System.out.println(r.freeMemory());
		r.gc();
		System.out.println(r.freeMemory());
		Queue q = new LinkedList();
		
		
	}

}
