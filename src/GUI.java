import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GUI extends JFrame {


    GUI() {
        // set the title
        super("Conway's Game of Life");

        // set bounds
        setBounds(100,100,800,600);
        // disable resize
        setResizable(true);
        // make background black
//        setBackground(Color.BLACK);

        Grid grid = new Grid();
        // add grid
        add(grid);
//        this.pack();

//        setBackground(Color.BLACK);

        // show window
        setVisible(true);
        // allow for closing
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
