import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Grid extends JPanel{
    private final int ROWS = 29;
    private final int COLS = 29;
    private Board gameboard = new Board(ROWS, COLS);
    private ArrayList<Cell> cells = new ArrayList<>();
    private static final int W = 60;
    private static final int H = W;
    private static final Dimension PREF_SIZE = new Dimension(W, H);
    private Color originalColor = null;
    private JPanel selectedPanel = null;
    protected static final Color SELECTION_COLOR = Color.pink;

    Grid() {
        setLayout(new GridLayout(ROWS, COLS, 1, 1));

        // loop through board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                Cell cell = new Cell(i, j);

//                String name = String.format("[%d, %d]", i, j);
//                cell.setName(name);

//                if (i == 0) {
//                    originalColor = cell.getBackground();
//                }

//                cell.setBackground(Color.BLUE);
//                cell.setPreferredSize(PREF_SIZE);
//                add(cell);
                cells.add(cell);
            }
        }

        setBackground(Color.BLACK);

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
////                Cell panel = (Cell) getComponentAt(e.getPoint());
//                Component panel = getComponentAt(e.getPoint());
//
//                System.out.println(e.getPoint());
//                System.out.println(panel.getName());
//
////                getComponentAt(e.getPoint());
//
//                if (panel == null || panel.equals(Grid.this)) {
//                    return;
//                }
//                if (selectedPanel != null) {
//                    selectedPanel.setBackground(originalColor);
//                    selectedPanel.removeAll();
//                    selectedPanel.revalidate();
//                    selectedPanel.repaint();
//                }
////                selectedPanel = panel;
////                assert selectedPanel != null;
//                selectedPanel.setBackground(SELECTION_COLOR);
//                selectedPanel.add(new JLabel(selectedPanel.getName()));
//                selectedPanel.revalidate();
//                selectedPanel.repaint();
//            }
//        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent( g );

//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, 200, 200);

//        can do cell checking here

        // paint the grid
        for( Rectangle r : cells ) {

            g.setColor(Color.WHITE);
            g.drawRect( r.x, r.y, r.width, r.height );
        }
    }
}
