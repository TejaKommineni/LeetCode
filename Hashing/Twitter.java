package LeetCode.Hashing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Tweet implements Comparable<Tweet>
{
    int tweetId;
    int userId;
    public Tweet(int tweetId, int userId)
    {
        this.tweetId = tweetId;
        this.userId = userId;
    }
	
	@Override
	public int compareTo(Tweet o) {
		// TODO Auto-generated method stub
		return o.tweetId - this.tweetId;
	}
	
}
public class Twitter {

    HashMap<Integer, List<Integer>> users;
    PriorityQueue<Tweet> tweets; 
    
    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap();
        tweets = new PriorityQueue();   
      }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
     Tweet tw = new Tweet(tweetId,userId);
     tweets.add(tw);
     if(!users.containsKey(userId))
     {
      users.put(userId,new ArrayList());
         
     }   
     
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
         List<Integer>  newsFeed = new ArrayList();
        if(users.containsKey(userId))
        {
        List<Integer> allFollowers = getAllFollowers(userId);
        PriorityQueue<Tweet> temp = new PriorityQueue<Tweet>();    
            int count =1;
        while(!tweets.isEmpty())
        {
            Tweet t = tweets.poll();
            temp.add(t);
            if(allFollowers.contains(t.userId))
            {
                newsFeed.add(t.tweetId);
                count++;
                if(count ==10)
                    break;
            }
        }
        tweets.addAll(temp);
        }
        return newsFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
     if(users.containsKey(followerId))
     {
    	 if(users.get(followerId) == null)
    	 {
    		 ArrayList<Integer> temp = new ArrayList();
    		 temp.add(followeeId);
    		 users.put(followerId, temp);
    	 }
    	 else		 
    		 users.get(followerId).add(followeeId);       
     } 
        
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
      if(users.containsKey(followerId))
     {
      if(users.get(followerId).contains(followeeId))    
            users.get(followerId).remove(new Integer(followeeId));       
     } 
    }
    
    public List<Integer> getAllFollowers(int userId) {
        
        List<Integer> allFollowers = new ArrayList();
        Queue<Integer> q = new PriorityQueue();
        q.add(userId);
        while(!q.isEmpty())
        {
            int temp = q.poll();
            if(!allFollowers.contains(temp))
            {
                allFollowers.add(temp);
                for(int i=0;i<users.get(temp).size();i++)
                {
                    q.add(users.get(temp).get(i));
                }
            }
        }        
        return allFollowers;   
        
    }
    
    public static void main(String[] args) {
    	Twitter obj = new Twitter();
    	obj.postTweet(1,1);
        List<Integer> param_2 = obj.getNewsFeed(1);
    	obj.follow(2,1);
    	//obj.postTweet(2,6);
    	param_2 = obj.getNewsFeed(2);
    	obj.unfollow(2,1);
    	param_2 = obj.getNewsFeed(2);
	}
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
