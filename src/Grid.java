import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Grid extends JPanel {
	private static final int rowCount = 10;
	private static final int width = 60;
	private static final Dimension size = new Dimension(width, width);
	// private JPanel selectedPanel = null;
	private boolean[][] board = new boolean[rowCount][rowCount];
	private int underpopulation = 2;
	private int overpopulation = 3;
	private int reproduction = 3;

	// TODO: need to handle board being changed

	Grid() {
		// make grid layout
		setLayout(new GridLayout(rowCount, rowCount, 1, 1));
		// make boarder white
		setBackground(Color.WHITE);

		for (int i = 0; i < rowCount * rowCount; i++) {
			JPanel panel = new JPanel();

			int row = i / rowCount;
			int col = i % rowCount;

			// set name for later parsing
			String name = String.format("[%d,%d]", row, col);
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

				// if (selectedPanel != null) {
				// selectedPanel.setBackground(originalColor);
				// selectedPanel.removeAll();
				// selectedPanel.revalidate();
				// selectedPanel.repaint();
				// }

				JPanel selectedPanel = panel;
				String name = selectedPanel.getName();
				int row = Integer.parseInt(String.valueOf(name.charAt(1)));
				int col = Integer.parseInt(String.valueOf(name.charAt(3)));

				setCellAt(row, col);

				selectedPanel.setBackground(Color.WHITE);

				// selectedPanel.add(new JLabel(name));
				// selectedPanel.add(new JLabel(String.format("[%d,%d]", row, col)));

				selectedPanel.revalidate();
				selectedPanel.repaint();
			}
		});

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

	public void nextCycle() {
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
