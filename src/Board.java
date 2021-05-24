public class Board {
    /**
     * The game board
     * A "true" means a cell is alive, a "false" means its dead
     */
    private boolean[][] board;
    /**
     * Any live cell with fewer than two live neighbours dies, as if by underpopulation.
     */
    private int underpopulation = 2;
    /**
     * Any live cell with more than three live neighbours dies, as if by overpopulation.
     */
    private int overpopulation = 3;
    /**
     * Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */
    private int reproduction = 3;

    /**
     * create a new board for the game
     * @param rows how many rows
     * @param cols how many columns
     */
    Board(int rows, int cols) {
        board = new boolean[rows][cols];
    }

    /**
     * Gets a cell at the specified position
     * @param row the row
     * @param col the column
     * @return value at specified position
     */
    public boolean getCellAt(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets a cell at the specified position to it's opposite value
     * A "false" become a "true" and vice versa
     * @param row the row
     * @param col the column
     */
    public void setCellAt(int row, int col) {
        board[row][col] = !board[row][col];
    }

    /**
     * get underpopulation value
     * @return underpopulation
     */
    public int getUnderpopulation() {
        return underpopulation;
    }

    /**
     * set underpopulation value
     * @param value new underpopulation
     */
    public void setUnderpopulation(int value) {
        underpopulation = value;
    }

    /**
     * gets overpopulation value
     * @return overpopulation
     */
    public int getOverpopulation() {
        return overpopulation;
    }

    /**
     * sets overpopulation value
     * @param value new overpopulation
     */
    public void setOverpopulation(int value) {
        overpopulation = value;
    }

    /**
     * gets reproduction value
     * @return reproduction
     */
    public int getReproduction() {
        return reproduction;
    }

    /**
     * sets reproduction value
     * @param value new reproduction
     */
    public void setReproduction(int value) {
        reproduction = value;
    }

    /**
     * Get the game board
     * @return the game board
     */
    public boolean[][] getBoard() {
        return board;
    }
    
    /**
     * Steps through to the next cycle
     */
    public void nextCycle() 
    {
    	boolean[][] newBoard = new boolean[board.length][board[0].length];
    	for(int i = 0; i < board.length; i++)
    	{
    		for(int j = 0; j < board[0].length; j++)
    		{
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
    }
    
    /**
     * count live cells in proximity
     * @param row
     * @param col
     * @return number of live cells around the current cell
     */
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
