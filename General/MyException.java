
public class MyException extends Exception
{
	String message;
	
	MyException(String message)
	{
		this.message=message;
	}
	
	public void printStackTrace()
	{
		StackTraceElement ste[] = super.getStackTrace();
		System.out.println(ste);
	}
	
	
public static void main(String[] args) {
	
	MyException me= new MyException("test");
	me.printStackTrace();
	
}	
 
}
