import javax.swing.JFrame;

public class GUI extends JFrame {
    GUI() {
        // set the title of the
        super("Conway's Game of Life");

        // set bounds
        this.setBounds(100,100,600,400);
        // disable resize
        this.setResizable(false);

        // show window
        this.setVisible(true);
        // allow for closing
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
