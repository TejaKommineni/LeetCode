package LeetCode.Trees;
import java.io.*;
import java.util.*;

/*
 * Part 1:
 * Sort an array by the length of the string, then alphabetical order (case-
 * insensitive).  For example, a correctly sorted list might be:
	a
	D
	z
	vb
	afd
*/
class Sorter {

	static void sort(String[] data) {
		Arrays.sort(data, new Comparator<String>() {
			//TODO: Fill in this function
			public int compare(String s1, String s2) {
				
				if(s1.length() == s2.length())
					return s1.toLowerCase().compareTo(s2.toLowerCase());
				else
					return s1.length() - s2.length();
			}
		});
	}

}

/*
 * Part 2: Write a small, reasonably efficient class that takes strings as input, and calls
 * a callback method whenever a newline ("\n") is reached, passing in the previous line's
 * text.  The class should discard old data when possible to save memory.

 * Hint: This should not take more than about 15-50 lines of code.
 */
class LineParser {

	private final LineReceiver receiver;
	private String line = "";
	LineParser(LineReceiver receiver) {
		this.receiver = receiver;
	}

	void read(String data) {
		//TODO: Fill in this function	
	for(int i=0;i<data.length();i++) 
	{			
		if(data.charAt(i) == '\n')
		{			
			receiver.lineComplete(line);
			line = "";
		}
		else
		{
			line = line + String.valueOf(data.charAt(i));
		}
	 }
	 
	}

}

interface LineReceiver {

	void lineComplete(String line);

}

/* 
 * Part 3: Implement the following game.
 * 
 * This game is played on a rectangular grid. At the beginning of the game, each space on
 * the board is filled in with a random piece, chosen from a predefined set of possible
 * types of pieces. The player selects a location on the board where there are at least
 * two of the same type of piece adjacent to each other (vertically or horizontally), and
 * the selected piece and all connected pieces of the same type are removed from the board,
 * at which time pieces above them (if any) fall down to take their place.
 * 
 * For example, if the user selected the middle space of the following board:
 * 
 * x o x
 * o o o
 * x x x
 * 
 * the result would be this
 * 
 * x   x
 * x x x
 * 
 * since all the connected o's were removed. The user could then select any of the x's, and
 * the entire board would be cleared, since the x's are all connected.
 * 
 * On the following board, there are no legal moves, since there are no connected pieces of
 * the same type. At this point, the game is over:
 * 
 * o x o
 * x o x
 * 
 * The user gets points based on how many pieces he removes at a time. Each piece removed in
 * a single move is worth one more point than the last piece. So for example,
 * 
 * 1 piece = 1 point
 * 2 pieces = 1 + 2 = 3 points
 * 3 pieces = 1 + 2 + 3 = 6 points
 * 
 * and so on. When there are no longer any legal moves, you deduct points for remaining pieces:
 * 
 * 1 piece left = -1 point
 * 2 pieces left = -1 - 2 = -3 points
 * 3 pieces left = -1 - 2 - 3 = -6 points
 * 
 * and so on. When the game is over, you should display the final score to the user and exit.
 * 
 * A skeleton class for the game is already prepared for you. The board is a simple rectangular
 * array of integers indexing into the pieceTypes array, with 0 representing a blank space.
 * The play() function currently loops forever, asking the user for a move (it guarantees the 
 * space entered is on the board), clearing the space they entered, and re-drawing the board. 
 * You should replace this logic with the correct logic described above.
 * 
 * Time permitting, you may write an AI that plays the game automatically, trying to get the
 * highest possible score.
 */
class Game {

	private final char[] pieceTypes = {' ', 'o', 'x', '$'};
	private final int width = 8;
	private final int height = 8;
	private int board[][] = new int[width][height];
	private final int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}}; 

	private int score = 0;

	Game() {
		Random random = new Random();
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				board[x][y] = random.nextInt(pieceTypes.length-1) + 1;
			}
		}
	}
	
	class Coordinate {
		int x;
		int y;
		
		Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			Coordinate c = (Coordinate)o;
			return c.x == x && c.y == y;
		}

		@Override
		public int hashCode() {
			return new Integer(x * 31 + y).hashCode();
		}
	}

	private Coordinate getMoveInput() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			String text = in.readLine();
			int x = text.charAt(0) - 'a';
			int y = Character.digit(text.charAt(1), 10) - 1;
			return new Coordinate(
				Math.max(0, Math.min(width - 1, x)),
				Math.max(0, Math.min(height-1, y))
			);
		} catch(Exception e) {
			return getMoveInput();
		}
	}

	private void render() {
		System.out.print(" ");
		for(int x = 0; x < width; x++) {
			System.out.printf(" %s", (char)('a'+x));
		}

		for(int y = 0; y < height; y++) {
			System.out.printf("\n%d", y+1);
			for(int x = 0; x < width; x++) {
				System.out.printf(" %s", pieceTypes[board[x][y]]);
			}
		}
		System.out.printf("\nCurrent score: %d\n", score);
	}

	public void play() {
		while(true) {
			render();
			
			Coordinate c = getMoveInput();
			if(board[c.x][c.y] == 0)
				System.out.println("Invalid move");
			int temp = board[c.x][c.y];
			int count = 1;
			for(int [] dir: dirs)
			{
				int x = c.x+dir[0];
				int y = c.y+dir[1];
				if(x<board.length && x>=0 && y<board[0].length && y>=0 && board[x][y] == temp)
				{
					count++;
				}
			}
			if(count < 2)
				System.out.println("Invalid move");
			else
			{				
				int moveScore = dfs(board,c.x,c.y,temp);
				score = score + calcScore(moveScore);
//				for(int i=1;i<board.length;i++)
//				{
//					for(int j=0;j<board[0].length;j++)
//					{
//						if(board[i][j] == 0)
//							board[i][j] = board[i-1][j];
//					}
//				}			
				 
			}
		}
	}
	
	private int calcScore(int moveScore) {
		
		int count =0;
		for(int i=1;i<=moveScore;i++)
		{
			count = count+i;
		}
		return count;
	}

	public int dfs(int[][] board, int i, int j, int c)
	{
		if(i<board.length && i>=0 && j<board[0].length && j>=0 && board[i][j] == c)
		{
			board[i][j] = 0;
			int numberOfCells =0;
			for(int [] dir: dirs)
			{
				int x = i+dir[0];
				int y = j+dir[1];				
				numberOfCells = numberOfCells + dfs(board, x, y, c);				
			}
			return 1+ numberOfCells;
		}
		else 
			return 0;		
	}

}

public class Test {

	public static void main(String[] args) {
		System.out.print("Part 1:\n");
		String[] data = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipisicing", "elit", "sed", "do", "eiusmod", "tempor", "incididunt", "ut", "labore", "et"};
		Sorter.sort(data);
		String [] data1 = {"a","D","z","vb","afd"};
		Sorter.sort(data);
		for(String s : data) {
			System.out.println(s);
		}
		System.out.println("\n");
		
		System.out.print("Part 2:\n");
		LineParser parser = new LineParser(new LineReceiver() {
			@Override
			public void lineComplete(String line) {
				System.out.println(line.replace("\n", " "));
			}
		});
		parser.read("This is t");
		parser.read("he first l");
		parser.read("ine.\nAnd this is the second.\n");
		parser.read("And this is the third.\n\n\nAnd the");
		parser.read(" fourth.\n");
		System.out.println("\n");

		System.out.print("Part 3:\n");
		new Game().play();
	}

}
