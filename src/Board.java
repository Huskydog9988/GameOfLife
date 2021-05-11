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
     * Any live cell with two or three live neighbours lives on to the next generation.
     */
    private int[] livesOn = {2, 3};
    /**
     * Any live cell with more than three live neighbours dies, as if by overpopulation.
     */
    private int overpopulation = 4;
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
     * Steps through to the next cycle
     */
    public void nextCycle() {}

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
     * get livesOn value
     * @return livesOn
     */
    public int[] getLivesOn() {
        return livesOn;
    }

    /**
     * sets livesOn value
     * @param lower the lower bounds to live on
     * @param upper the upper (inclusive) bound to live on
     */
    public void setLivesOn(int lower, int upper) {
        livesOn[0] = lower;
        livesOn[1] = upper;
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
}
