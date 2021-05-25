import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {
    private Board gameboard = new Board(10, 10);

    Grid() {
//        make a grid layout
        setLayout(new GridLayout(25, 25));

        // loop through board
        for (int i = 0; i < gameboard.getBoard().length; i++) {
            for (int j = 0; j < gameboard.getBoard()[i].length; j++) {
                // add board item to grid
//                grid.add(new JLabel("" + i + " " + j));
                add(new JLabel("" + gameboard.getCellAt(i, j)));
            }
        }
    }
}
