import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private Board gameboard = new Board(10, 10);

    GUI() {
        // set the title
        super("Conway's Game of Life");

        // set bounds
        this.setBounds(100,100,600,400);
        // disable resize
        this.setResizable(false);

        // new grid
        JPanel grid = new JPanel();
        // set gridlayout for the grid
        grid.setLayout(new GridLayout(25, 25));

        // loop through board
        for (int i = 0; i < gameboard.getBoard().length; i++) {
            for (int j = 0; j < gameboard.getBoard()[i].length; j++) {
                // add board item to grid
                grid.add(new JLabel("" + i + " " + j));
            }
        }

        // add grid
        this.add(grid);
//        this.pack();

        // show window
        this.setVisible(true);
        // allow for closing
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
