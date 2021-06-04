import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Grid extends JPanel {
	private static final int rowCount = 30;
	private static final int width = 60;
	private static final Dimension size = new Dimension(width, width);
	// private JPanel selectedPanel = null;
	private boolean[][] board = new boolean[rowCount][rowCount];
	private int underpopulation = 2;
	private int overpopulation = 3;
	private int reproduction = 3;
	private int cycles = 0;

	// TODO: need to handle board being changed

	Grid() {
		// make grid layout
		setLayout(new GridLayout(rowCount, rowCount, 1, 1));
		// make boarder white
		setBackground(Color.WHITE);

		setName("Board");

		paintBoard();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// get panel where mouse clicks
				// e.getComponent() does not work, no idea why
				JPanel panel = (JPanel) getComponentAt(e.getPoint());
				// if null, grid, or other component
				if (panel == null || panel == Grid.this || panel == getParent()) {
					return;
				}

				String name = panel.getName();
				Logger.debug("Got cell " + name);
//				int row = Integer.parseInt(String.valueOf(name.charAt(1)));
//				int col = Integer.parseInt(String.valueOf(name.charAt(3)));

//				0 = row
//				1 = col
				int[] cords = parseName(name);

				setCellAt(cords[0], cords[1]);

				if (panel.getBackground().equals(Color.BLACK)) {
					panel.setBackground(Color.WHITE);
				} else {
					panel.setBackground(Color.BLACK);
				}

				// selectedPanel.add(new JLabel(name));
				// selectedPanel.add(new JLabel(String.format("[%d,%d]", row, col)));

				panel.revalidate();
				panel.repaint();
			}
		});

	}

	public String formatCord(int row, int col) {
		return String.format("%d,%d", row, col);
	}

	private void repaintBoard() {
		Logger.info("Repainting the board");
		removeAll();
		revalidate();
		paintBoard();
	}

	private void paintBoard() {
		Logger.info("Painting the board");

		for (int i = 0; i < rowCount * rowCount; i++) {
			JPanel panel = new JPanel();

			int row = i / rowCount;
			int col = i % rowCount;

			// set name for later parsing
			String name = formatCord(row, col);
			panel.setName(name);

			// if (i == 0) {
			// originalColor = panel.getBackground();
			// }

			// get whether cell is alive or dead
			Boolean alive = getCellAt(row, col);

			if (alive) {
				panel.setBackground(Color.WHITE);
			} else {
				panel.setBackground(Color.BLACK);
			}

			// set size
			panel.setPreferredSize(size);
			add(panel);
		}
		revalidate();
	}

	public int[] parseName(String name) {
		int[] cords = new int[2];

		String[] s = name.split(",");
		cords[0] = Integer.parseInt(s[0]);
		cords[1] = Integer.parseInt(s[1]);

		return cords;
	}

	public boolean getCellAt(int row, int col) {
		return board[row][col];
	}

	public void setCellAt(int row, int col) {
		Logger.debug("Set cell " + formatCord(row, col));
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

	public int getCycles() { return cycles; }

	public void nextCycle() {
		Logger.info("Next cycle");

		boolean[][] newBoard = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// if dead
				if (!board[i][j]) {
					if (numAround(i, j) == reproduction)
						newBoard[i][j] = !board[i][j];
				} else {
					if (numAround(i, j) < underpopulation)
						newBoard[i][j] = !board[i][j];
					else if (numAround(i, j) > overpopulation)
						newBoard[i][j] = !board[i][j];
					else
						newBoard[i][j] = board[i][j];
				}
			}
		}
		board = newBoard;

		repaintBoard();
		cycles++;
	}

	public int numAround(int row, int col) {
		int count = 0;
		if (row == 0) {
			if (col == 0) {
				if (board[row + 1][col])
					count++;
				if (board[row + 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
			} else if (col == board[0].length - 1) {
				if (board[row + 1][col])
					count++;
				if (board[row + 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
			} else {
				if (board[row + 1][col])
					count++;
				if (board[row + 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
				if (board[row + 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
			}
		} else if (row == board.length - 1) {
			if (col == 0) {
				if (board[row - 1][col])
					count++;
				if (board[row - 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
			} else if (col == board[0].length - 1) {
				if (board[row - 1][col])
					count++;
				if (board[row - 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
			} else {
				if (board[row - 1][col])
					count++;
				if (board[row - 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
				if (board[row - 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
			}
		} else {
			if (col == 0) {
				if (board[row + 1][col])
					count++;
				if (board[row + 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
				if (board[row - 1][col])
					count++;
				if (board[row - 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
			} else if (col == board[0].length - 1) {
				if (board[row + 1][col])
					count++;
				if (board[row + 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
				if (board[row - 1][col])
					count++;
				if (board[row - 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
			} else {
				if (board[row + 1][col])
					count++;
				if (board[row + 1][col + 1])
					count++;
				if (board[row][col + 1])
					count++;
				if (board[row + 1][col - 1])
					count++;
				if (board[row][col - 1])
					count++;
				if (board[row - 1][col])
					count++;
				if (board[row - 1][col + 1])
					count++;
				if (board[row - 1][col - 1])
					count++;
			}
		}
		return count;
	}
}
