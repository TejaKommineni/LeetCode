package Contests;

public class Contest21 {

public char[][] updateBoard(char[][] board, int[] click) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        recursive(board,click,visited);
        return board;
    }
    
    public void recursive(char[][] board, int[] click, boolean[][] visited)
    {
    	if(visited[click[0]][click[1]] == true)
    		return;
    	else
    		visited[click[0]][click[1]] = true;
    	
        if(board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return;
        }  
        if(board[click[0]][click[1]] == 'B')
        {
            return;
        }    
        
        int x[] = {1,0,-1};
        int y[] = {1,0,-1};
        int mines = 0;
        for(int i=0;i<x.length;i++)
        {
            for(int j=0;j<y.length;j++)
            {
             if(x[i] == 0 && x[i]==y[j])
             continue;
             
             if(click[0]+x[i]>=0 && click[0]+x[i]<board.length  && click[1]+y[j]>=0 && click[1]+y[j]<board[0].length)
             {
              if(board[click[0]+x[i]][click[1]+y[j]] == 'M') 
                 mines++;
             }
           
          }
        }
        
       
        	if(mines ==0)
            {
              board[click[0]][click[1]] = 'B';
              for(int i=0;i<x.length;i++)
            {
                for(int j=0;j<y.length;j++)
                {
                 if(x[i] == 0 && x[i]==y[j])
                 continue;
                 
                 if(click[0]+x[i]>=0 && click[0]+x[i]<board.length  && click[1]+y[j]>=0 && click[1]+y[j]<board[0].length)
                 {
                  if(board[click[0]+x[i]][click[1]+y[j]] == 'E')
                     recursive(board, new int[] {click[0]+x[i],click[1]+y[j]},visited);
                 }
               
              }
            }
              
            }  
        else
          board[click[0]][click[1]] = (char)('0' + mines);
        
    }
    
    public static void main(String[] args) {
    	
    	Contest21 c = new Contest21();
    	System.out.println(c.updateBoard(new char [][] {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}}, new int[] {3,0}));
		
	}
}
