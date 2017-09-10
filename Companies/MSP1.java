package LeetCode.Trees;
import java.util.Scanner;

public class MSP1 {
	
	public String isSymmetric(String str)
	{
		
		String split[] = str.split(";");
		int m = split.length;
		String subSplit[] = split[0].split(",");
		int n = subSplit.length;
		
		int arr [][] = new int[m][n];
		
		for(int i=0;i<m;i++)
		{
			subSplit = split[i].split(",");
			for(int j=0;j<n;j++)
			{
				arr[i][j] = Integer.parseInt(subSplit[j]);
			}
		}
		
		boolean symmetric = true;
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if(arr[i][j] != arr[j][i])
                {
                    symmetric = false;
                    break;
                }
            }
        }
         
        if(symmetric)
        {
        	return "Symmetric"; 
        }
        else
        {
            return "Not symmetric";
        }
		
		
	}
	
	
	public String calendar(String str)
	{
	  String arr[] = str.split(" ");
	  String present = arr[1];
	  String month = "";
	  String year = "";
	  String day = "";
	  
	  if(present.charAt(0) == 'y')
	  {
		  if(present.charAt(5) == 'm' && present.charAt(8) == 'm')
		  {
			  			year = arr[0].substring(0, 4);
			  			month = arr[0].substring(5, 7);
			  			day = arr[0].substring(8);
		  }
	  } 
	  if(present.charAt(0) == 'y')
	  {
		  if(present.charAt(5) == 'd' && present.charAt(8) == 'd')
		  {
			  			year = arr[0].substring(0, 4);
			  			day = arr[0].substring(5, 7);
			  			month = arr[0].substring(8);
		  }
	  } 
	  
	  if(present.charAt(0) == 'y')
	  {
		  if(present.charAt(5) == 'm')
		  {
			  			year = arr[0].substring(0, 4);
			  			month = arr[0].substring(5, 7);
			  			day = arr[0].substring(8);
		  }
	  } 
	  
	  if(present.charAt(0) == 'y')
	  {
		  if(present.charAt(5) == 'd')
		  {
			  			year = arr[0].substring(0, 4);
			  			day = arr[0].substring(5, 7);
			  			month = arr[0].substring(8);
		  }
	  } 
		
	  if(present.charAt(0) == 'm')
	  {
		  if(present.charAt(3) == 'y' && present.charAt(8) == 'm')
		  {
			  			year = arr[0].substring(3, 7);
			  			month = arr[0].substring(0, 2);
			  			day = arr[0].substring(8);
		  }
	  } 
	  
	 	
	  if(present.charAt(0) == 'm')
	  {
		  if(present.charAt(3) == 'm')
		  {
			  			year = arr[0].substring(6);
			  			month = arr[0].substring(0, 2);
			  			day = arr[0].substring(3,5);
		  }
	  } 
	  
	  if(present.charAt(0) == 'm')
	  {
		  if(present.charAt(3) == 'y')
		  {
			  			year = arr[0].substring(3, 7);
			  			month = arr[0].substring(0, 2);
			  			day = arr[0].substring(8);
		  }
	  } 
	  
	  if(present.charAt(0) == 'm')
	  {
		  if(present.charAt(3) == 'd')
		  {
			  			year = arr[0].substring(6);
			  			month = arr[0].substring(0, 2);
			  			day = arr[0].substring(3,5);
		  }
	  } 
	  
	  if(present.charAt(0) == 'd')
	  {
		  if(present.charAt(3) == 'y' && present.charAt(8) == 'd')
		  {
			  			year = arr[0].substring(3, 7);
			  			day = arr[0].substring(0, 2);
			  			month = arr[0].substring(8);
		  }
	  } 
	  
	  if(present.charAt(0) == 'd')
	  {
		  if(present.charAt(3) == 'd')
		  {
			  			year = arr[0].substring(6);
			  			day = arr[0].substring(0, 2);
			  			month = arr[0].substring(3,5);
		  }
	  }
	  if(present.charAt(0) == 'd')
	  {
		  if(present.charAt(3) == 'y')
		  {
			  			year = arr[0].substring(3, 7);
			  			day = arr[0].substring(0, 2);
			  			month = arr[0].substring(8);
		  }
	  } 
	  
	  if(present.charAt(0) == 'd')
	  {
		  if(present.charAt(3) == 'm')
		  {
			  			year = arr[0].substring(6);
			  			day = arr[0].substring(0, 2);
			  			month = arr[0].substring(3,5);
		  }
	  } 
		
	  
	  String future = arr[2];
	  
	  if(future.charAt(0) == 'y')
	  {
		  if(future.charAt(5) == 'm')
		  {
			  			return year+future.charAt(4)+month+future.charAt(4)+day;
			  			
		  }
	  } 
	  
	  
	  
	  if(future.charAt(0) == 'y')
	  {
		  if(future.charAt(5) == 'd')
		  {
			  return year+future.charAt(4)+day+future.charAt(4)+month;
		  }
	  } 
		  
	  
	  if(future.charAt(0) == 'm')
	  {
		  if(future.charAt(3) == 'y')
		  {
			  return month+future.charAt(2)+year+future.charAt(2)+day;
		  }
	  } 
	  
	  if(future.charAt(0) == 'm')
	  {
		  if(future.charAt(3) == 'd' || future.charAt(3) == 'm')
		  {
			  return month+future.charAt(2)+day+future.charAt(2)+year;
		  }
	  } 
	  
	  if(future.charAt(0) == 'd')
	  {
		  if(future.charAt(3) == 'y')
		  {
			  return day+future.charAt(2)+year+future.charAt(2)+month;
		  }
	  } 
	  
	  if(future.charAt(0) == 'd')
	  {
		  if(future.charAt(3) == 'm' || future.charAt(3) == 'd')
		  {
			  return day+future.charAt(2)+month+future.charAt(2)+year;
		  }
	  } 
	  return "";
	  
	}
	
	
	
	public static void main(String[] args) {
		
		MSP1 ms = new MSP1();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			System.out.println(ms.calendar(sc.nextLine()));
		}
		
	}

}
