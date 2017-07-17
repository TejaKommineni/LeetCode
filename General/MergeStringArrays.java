public class MergeStringArrays
{
	
	
public String[] merge(String[] a, String[] b)
{
 int aLength=a.length;
 int bLength=b.length;
 int i=0;
 int j=0;
 int k=0;
 String c[] = new String[aLength+bLength];
 
 while(i<aLength && j<bLength)
 {
	 if(compareStrings(a[i],b[j]))
	 {
		 c[k]=a[i];
		 i++;
		 k++;
	 }
	 else
	 {
		 c[k]=b[j];
		 j++;
		 k++;
	 }
	 
 }
 
 if(i<aLength)
 {
	 while(i<aLength)
	 {
		c[k]=a[i];
		i++;
		k++;
	 }
 }
 
 if(j<bLength)
 {
	 while(j<bLength)
	 {
		c[k]=b[j];
		j++;
		k++;
	 }
 }
 
	return c;
}

private boolean compareStrings(String a, String b) {
	int i=0;
	int j=0;
	
	

	while(i<a.length() && j<b.length())
	{
		if((int)(a.charAt(i))>(int)(b.charAt(j)))
		{
			return false;
		}
		if((int)(a.charAt(i))<(int)(b.charAt(j)))
		{
			return true;
		}
		i++;
		j++;
	}
	
	if(i<a.length())
		return false;
	if(j<a.length())
		return true;
	
	return true;
}

public static void main(String[] args) {

	MergeStringArrays msa = new MergeStringArrays();
	String A[]= {"good", "person" };
	String B[] = { "he", "is" };
	String c[]=msa.merge(A,B);
	
	for(int i=0;i<c.length;i++)
	{
		System.out.println(c[i]);
	}
	
	System.out.println("tejav".compareToIgnoreCase("vathsal"));
	
}
}