package LeetCode.Arrays;

public class DeleteOperations {
	
	
	public int minDistance(String word1, String word2) {
		 
        int characters [] = new int[256];
        
        for(int i=0;i<word1.length();i++)
        {
            int temp = word1.charAt(i);
            characters[temp]++;
        }
        for(int i=0;i<word2.length();i++)
        {
            int temp = word2.charAt(i);            
            if(characters[temp]>0)
            	characters[temp]--;
            else
            	characters[temp]++;
        }   
        int count = 0;
        
        for(int i=0;i<256;i++)
        {
            if(characters[i] != 0)
                count = count + characters[i];
        }        
        return count;
    }
	public static void main(String[] args) {
		DeleteOperations d = new DeleteOperations();
		d.minDistance("sea", "eat");
	}
	

}
