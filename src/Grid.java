import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Grid extends JPanel{
    private static final int rowCount = 10;
    private static final int width = 60;
    private static final Dimension size = new Dimension(width, width);
//    private JPanel selectedPanel = null;
    private Color originalColor = Color.WHITE;
    private Board gameboard = new Board(rowCount, rowCount);

//    TODO: need to handle board being changed
    
    Grid() {
//        make grid layout
        setLayout(new GridLayout(rowCount, rowCount, 1, 1));
//        make boarder white
        setBackground(Color.WHITE);

        for (int i = 0; i < rowCount * rowCount; i++) {
            JPanel panel = new JPanel();

            int row = i / rowCount;
            int col = i % rowCount;

//            set name for later parsing
            String name = String.format("[%d,%d]", row, col);
            panel.setName(name);

//            if (i == 0) {
//                originalColor = panel.getBackground();
//            }

//            get whether cell is alive or dead
            Boolean alive = gameboard.getCellAt(row, col);

            if (alive) {
                panel.setBackground(Color.WHITE);
            } else {
                panel.setBackground(Color.BLACK);
            }

//            set size
            panel.setPreferredSize(size);
            add(panel);
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
//                get panel where mouse clicks
//                e.getComponent() does not work, no idea why
                JPanel panel = (JPanel) getComponentAt(e.getPoint());
//                if null, grid, or other component
                if (panel == null || panel == Grid.this || panel == getParent()) {
                    return;
                }

//                if (selectedPanel != null) {
//                    selectedPanel.setBackground(originalColor);
//                    selectedPanel.removeAll();
//                    selectedPanel.revalidate();
//                    selectedPanel.repaint();
//                }

                JPanel selectedPanel = panel;

                String name = selectedPanel.getName();
                int row = Integer.parseInt(String.valueOf(name.charAt(1)));
                int col = Integer.parseInt(String.valueOf(name.charAt(3)));

                gameboard.setCellAt(row, col);

                selectedPanel.setBackground(Color.WHITE);

//                selectedPanel.add(new JLabel(name));
//                selectedPanel.add(new JLabel(String.format("[%d,%d]", row, col)));

                selectedPanel.revalidate();
                selectedPanel.repaint();
            }
        });

    }
}
