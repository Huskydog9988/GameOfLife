public class Board {
    /**
     * The game board
     * A "true" means a cell is alive, a "false" means its dead
     */
    private boolean[][] board;
    private int underpopulation = 2;
    private int[] livesOn = {2, 3};

    Board(int rows, int cols) {
        board = new boolean[rows][cols];
    }

    /**
     * Gets a cell at the specified position
     * @param row
     * @param col
     * @return
     */
    public boolean getCellAt(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets a cell at the specified position to it's opposite value
     * A "false" become a "true" and vice versa
     * @param row
     * @param col
     */
    public void setCellAt(int row, int col) {
        board[row][col] = !board[row][col];
    }

    /**
     * Steps through to the next cycle
     */
    public void nextCycle() {}

    /**
     * get underpopulation value
     * @return
     */
    public int getUnderpopulation() {
        return underpopulation;
    }

    /**
     * set underpopulation value
     * @param value
     */
    public void setUnderpopulation(int value) {
        underpopulation = value;
    }

    /**
     * get livesOn value
     * @return
     */
    public int[] getLivesOn() {
        return livesOn;
    }

    /**
     * sets livesOn value
     * @param lower
     * @param upper
     */
    public void setLivesOn(int lower, int upper) {
        livesOn[0] = lower;
        livesOn[1] = upper;
    }
}
