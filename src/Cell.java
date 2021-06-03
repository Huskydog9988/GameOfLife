import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Cell  extends Rectangle {
    private int row;
    private int col;
//    private Rectangle2D.Double cell;
    private int side = 10;

    Cell(int row, int col) {
        super(row * 20, col * 20);
        this.row = row;
        this.col = col;

//        cell = new Rectangle2D.Double(row * side, col * side, side, side);
    }
}
