import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Grid extends JPanel{
    private final int ROWS = 29;
    private final int COLS = 29;
    private ArrayList<Cell> cells = new ArrayList<>();
    private static final int W = 60;
    private static final int H = W;
    private static final Dimension PREF_SIZE = new Dimension(W, H);
    private Color originalColor = null;
    private JPanel selectedPanel = null;
    private boolean[][] board;
    private int underpopulation = 2;
    private int overpopulation = 3;
    private int reproduction = 3;
    protected static final Color SELECTION_COLOR = Color.pink;

    Grid() {
        setLayout(new GridLayout(ROWS, COLS, 1, 1));

        // loop through board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                Cell cell = new Cell(i, j);


                cells.add(cell);
            }
        }

        setBackground(Color.BLACK);


    }

    public void paintComponent(Graphics g) {
        super.paintComponent( g );

        for( Rectangle r : cells ) {

            g.setColor(Color.WHITE);
            g.drawRect( r.x, r.y, r.width, r.height );
        }
    }
    
    public boolean getCellAt(int row, int col) {
        return board[row][col];
    }
    public void setCellAt(int row, int col) {
        board[row][col] = !board[row][col];
    }
    public int getUnderpopulation() {
        return underpopulation;
    }
    public void setUnderpopulation(int value) {
        underpopulation = value;
    }
    public int getOverpopulation() {
        return overpopulation;
    }
    public void setOverpopulation(int value) {
        overpopulation = value;
    }
    public int getReproduction() {
        return reproduction;
    }
    public void setReproduction(int value) {
        reproduction = value;
    }
    public boolean[][] getBoard() {
        return board;
    }
    public void nextCycle() 
    {
    	boolean[][] newBoard = new boolean[board.length][board[0].length];
    	for(int i = 0; i < board.length; i++)
    	{
    		for(int j = 0; j < board[0].length; j++)
    		{
//    			if dead
    			if(!board[i][j])
    			{
    				if(numAround(i, j) == reproduction)
    					newBoard[i][j] = !board[i][j];
    			}
    			else
    			{
    				if(numAround(i, j) < underpopulation)
    					newBoard[i][j] = !board[i][j];
    				else if(numAround(i, j) > overpopulation)
    					newBoard[i][j] = !board[i][j];
    				else
    					newBoard[i][j] = board[i][j];
    			}
    		}
    	}
    	board = newBoard;
    }
    public int numAround(int row, int col)
    {
    	int count = 0;
    	if(row==0)
    	{
    		if(col == 0)
    		{
    			if(board[row+1][col])
    				count++;
    			if(board[row+1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    		}
    		else if(col == board[0].length-1)
    		{
    			if(board[row+1][col])
    				count++;
    			if(board[row+1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    		}
    		else
    		{
    			if(board[row+1][col])
    				count++;
    			if(board[row+1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    			if(board[row+1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    		}
    	}
    	else if(row == board.length-1)
    	{
    		if(col == 0)
    		{
    			if(board[row-1][col])
    				count++;
    			if(board[row-1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    		}
    		else if(col == board[0].length-1)
    		{
    			if(board[row-1][col])
    				count++;
    			if(board[row-1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    		}
    		else
    		{
    			if(board[row-1][col])
    				count++;
    			if(board[row-1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    			if(board[row-1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    		}
    	}
    	else
    	{
    		if(col == 0)
    		{
    			if(board[row+1][col])
    				count++;
    			if(board[row+1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    			if(board[row-1][col])
    				count++;
    			if(board[row-1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    		}
    		else if(col == board[0].length-1)
    		{
    			if(board[row+1][col])
    				count++;
    			if(board[row+1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    			if(board[row-1][col])
    				count++;
    			if(board[row-1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    		}
    		else
    		{
    			if(board[row+1][col])
    				count++;
    			if(board[row+1][col+1])
    				count++;
    			if(board[row][col+1])
    				count++;
    			if(board[row+1][col-1])
    				count++;
    			if(board[row][col-1])
    				count++;
    			if(board[row-1][col])
    				count++;
    			if(board[row-1][col+1])
    				count++;
    			if(board[row-1][col-1])
    				count++;
    		}
    	}
    	return count;
    }
}
