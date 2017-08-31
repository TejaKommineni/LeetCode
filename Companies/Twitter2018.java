package LeetCode.Companies;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Twitter2018 {

	public int uniquePaths(int m, int n) {
	    if(m==0 || n==0) return 0;
	    if(m==1 || n==1) return 1;
	 
	    int[][] dp = new int[m][n];
	 
	    //left column
	    for(int i=0; i<m; i++){
	        dp[i][0] = 1;
	    }
	 
	    //top row
	    for(int j=0; j<n; j++){
	        dp[0][j] = 1;
	    }
	 
	    //fill up the dp table
	    for(int i=1; i<m; i++){
	        for(int j=1; j<n; j++){
	            dp[i][j] = dp[i-1][j] + dp[i][j-1];
	        }
	    }
	 
	    return dp[m-1][n-1];
	}
	
	
	
	
	
	public static void main(String[] args) {
		double pl = (double) 200/3;
		DecimalFormat df1 = new DecimalFormat("#.00");
		
		System.out.println(df1.format(pl));
	
		Twitter2018 t = new Twitter2018();
		args = new String[7];
		args[0] = "10.10.10.10 - - [27/Sep/2017:05:22:00 +0000] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 500 563 19 \"Twitter-iPhone/6.63 iOS/10.0.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177";
		args[1] = "10.10.10.10 - - [27/Sep/2016:05:22:08 +0000] \"GET /1.1/friendships/list.json?user_id=123 HTTP/1.1\" 200 563 19 \"Twitter-iPhone/6.63 iOS/10.0.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177";
		args[2] = "10.10.10.10 - - [27/Sep/2016:05:22:31 +0000] \"GET /1.1/friendships/list.json HTTP/1.1\" 200 563 19 \"Twitter-iPhone/6.63 iOS/10.0.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177\r\n" + 
				"";
		args[3] = "10.10.10.10 - - [27/Sep/2016:05:22:59 +0000] \"GET /1.1/friendships/list.json HTTP/1.1\" 200 94 6 \"Twitter-iPhone/6.63 iOS/10.0.1 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177\r\n" + 
				"";
		args[4] = "10.10.10.10 - - [27/Sep/2016:05:23:01 +0000] \"GET /1.1/users/show.json?include_entities=1&user_id=321 HTTP/1.1\" 200 4160 51 \"Twitter-iPhone/6.63 iOS/9.3.5 (Apple;iPhone7,2;;;;;0)\" 177.177.177.177\r\n" + 
				"";
		args[5] = "10.10.10.10 - - [27/Sep/2016:22:45:33 +0000] \"GET /1.1/friendships/list.json?user_id=234 HTTP/1.1\" 200 563 19 \"Twitter-iPhone/6.63 iOS/10.0.2 (Apple;iPhone7,2;;;;;1)\" 177.177.177.177\r\n" + 
				"";
		args[6] = "10.10.10.10 - - [27/Sep/2016:22:45:51 +0000] \"POST /1.1/friendships/create.json HTTP/1.1\" 200 4193 120 \"Twitter-iPhone/6.62.1 iOS/9.3.5 (Apple;iPhone7,2;;;;;0)\" 177.177.177.177";
		HashMap<String, String> months = new HashMap();
		months.put("Jan", "01");months.put("Feb", "02");months.put("Mar", "03");		months.put("Apr", "04");
		months.put("May", "05");months.put("Jun", "06");months.put("Jul", "07");		months.put("Aug", "08");
		months.put("Sep", "09");months.put("Oct", "10");months.put("Nov", "11");		months.put("Dec", "12");
		TreeMap<String, ArrayList<Log>> apache = new TreeMap<String, ArrayList<Log>>();
		for(int i=0;i<args.length;i++)
		{
			String keep[] = args[i].split(" ");
			int start = keep[3].indexOf('[');
			int end = keep[3].length();
			String temp = keep[3].substring(1, end);
			String splited[] = temp.split("/");
			String day = splited[0];
			String month = months.get(splited[1]);
			String year = splited[2].split(":")[0];
			String hour = splited[2].split(":")[1];
			String minute = splited[2].split(":")[2];
			String dateTime = year+"-"+month+"-"+day+"T"+hour+":"+minute;
			
			String logKey = keep[6];
			if(logKey.indexOf("?") >0)
			{
				logKey = logKey.split("\\?")[0];
			}
			//System.out.println(logKey);
			String code = keep[8];
			//System.out.println(code);
			if(apache.containsKey(dateTime))
			{
				boolean flag = false;
				ArrayList<Log> li = apache.get(dateTime);
				for(int j=0;j<li.size();j++)
				{
					if(li.get(j).id.equals(logKey))
					{
						if(code.equals("500"))
							li.get(j).failure++;
						else
							li.get(j).success++;
						flag =true;
					}
				}
				if(!flag)
				{
					Log l = new Log(logKey);
					if(code.equals("500"))
						l.failure++;
					else
						l.success++;
					apache.get(dateTime).add(l);
				}
			}
			else
			{
				
				ArrayList<Log> logs = new ArrayList();
				Log l = new Log(logKey);
				if(code.equals("500"))
					l.failure++;
				else
					l.success++;
				logs.add(l);
				apache.put(dateTime, logs);
			}
			
		}
		for(Map.Entry<String, ArrayList<Log>> entry : apache.entrySet())
		{
			String dateTime = entry.getKey();
			ArrayList<Log> li = entry.getValue();
			Collections.sort(li, new Comparator<Log>()
			{

				@Override
				public int compare(Log arg0, Log arg1) {
					
					return arg0.id.compareTo(arg1.id);
				}
				
			});
			
			for(int i=0;i<li.size();i++)
			{
				int x = li.get(i).success;
				int y = li.get(i).failure;
				double ans = ((double)x/(double)(x+y))*100;
				String vats = String.valueOf(ans);
				String test = vats.split("\\.")[1];
				if(test.length()>2)
					test = test.substring(0, 2);
				else if(test.length()<2)
					test = test+"0";
				System.out.println(dateTime +" " +li.get(i).id + " "+vats.split("\\.")[0]+"."+test);
			}
		}
		
		
	}
}

class Log 
{
	String id;
	int success =0;
	int failure =0;
	
	public Log(String id)
	{
		this.id = id;
	}
	
}
