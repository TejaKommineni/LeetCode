import java.io.*;
import java.util.*;

public class GridlandMetro {

    public static void main(String[] args) {

Scanner sc = new Scanner(System.in);   
int row= sc.nextInt();
int column=sc.nextInt();
int tracks =sc.nextInt();
HashMap<Integer,HashSet> hs = new HashMap<Integer,HashSet>();

while(tracks>0)
{
int trackRow=sc.nextInt();
int trackColStart=sc.nextInt();
int trackColEnd=sc.nextInt();


while(trackColEnd>=trackColStart)
{
	if(hs.containsKey(trackRow))
	{
	HashSet hset= hs.get(trackRow);
if(hset.contains(trackColStart))
{}
else
{
hset.add(trackColStart);
}

trackColStart++;
}

else
{
   HashSet hset= new HashSet();
    hset.add(trackColStart);
    hs.put(trackRow,hset);
    trackColStart++;
        
}
}  
tracks--;
}

int size=0;
        
for(int key:hs.keySet())
{
HashSet hSet=hs.get(key);

size=size+hSet.size();
}

System.out.println((row*column)-size);



    }
}
