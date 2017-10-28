package LeetCode.Search;

public class WordSearch {
	
	
/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED",  returns true,
word = "SEE", returns true,
word = "ABCB", returns false.
 * 
 */


    public boolean exist(char[][] board, String word) {
    
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
        
                if(verify(board,i,j,word,0))
                    return true;
            }
        
        }
        return false;
    }
    
    public boolean verify(char[][] board, int i, int j, String word, int start)
    {
        if(start == word.length())
            return true;
            
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        
        if(word.charAt(start) == board[i][j])
        {            
            board[i][j] = '#';
         boolean answer = (verify(board,i+1,j,word,start+1) || verify(board,i-1,j,word,start+1)|| verify(board,i,j-1,word,start+1) || verify(board,i,j+1,word,start+1));
            board[i][j] = word.charAt(start);    
            return answer;
        }
        return false;
    }
}
