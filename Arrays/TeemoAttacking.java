package LeetCode.Arrays;

public class TeemoAttacking {
/*
 * 
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.

You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.
 */

	public int findPoisonedDuration(int[] timeSeries, int duration) {
	     
        int total =0;
        for(int i=0;i<timeSeries.length;i++)
        {
                
            if(i!=0 &&  timeSeries[i] - timeSeries[i-1] < duration)
                total = total - duration + (timeSeries[i] - timeSeries[i-1]);
            total = total+duration;
        }
        return total;
        
    }
	
	
}
