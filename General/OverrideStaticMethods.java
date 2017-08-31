package LeetCode.General;

import java.util.HashMap;
import java.util.HashSet;

public class OverrideStaticMethods {
	int a =1;
	public void method()
	{
		System.out.println("teja");
		System.out.println(a);

	}
	
	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet();
		Integer a = new Integer(2);
		Integer b = new Integer(2);
		hs.add(a); hs.add(b);
		HashMap<Integer, HashSet> hs1 = new HashMap();
		hs1.put(1, hs);
		hs.add(5);
		a = 4;
		hs.add(a);
		System.out.println(a.hashCode());
		System.out.println("teja"+'c');
		OverrideStaticMethods o ;
		o = new OverrideStaticMethods();
		o.method();
		o = new subclass();	
		o.method();
		Integer i = 100;
		Integer i1 = 100;
		if(i == i1)
			System.out.println(true);
	}
}

class subclass extends OverrideStaticMethods
{
	public void method()
	{
		System.out.println('a'+"vathsala");
		
	}
}
