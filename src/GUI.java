import javax.swing.*;

public class GUI extends JFrame {
    GUI() {
        // set the title
        super("Conway's Game of Life");

        // set bounds
        this.setBounds(100,100,800,600);
        // disable resize
        this.setResizable(true);

        // new grid
        Grid grid = new Grid();
        // add grid
        add(grid);
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
