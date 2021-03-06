import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GUIWindow {
    private static int rows = 5;
    private static int cols = 7;

    public static class Grid extends JPanel {
        public Grid() {
            setSize(400, 400);
           setVisible(true);
        }

        public void paint(Graphics g) {
            for (int x = 30; x <= 150; x += 30)
                for (int y = 30; y <= 150; y += 30)
                    g.drawRect(x, y, 30, 30);
        }
    }

        public static void main(String[] args) {
            JFrame window = new JFrame("Shortest Path Application");

            //dropdown menu
            String[] algorithms = {"Select Algorithm", "AStar", "BellmanFord", "Bidirectional Search", "Breadth-First Search", "Dijkstra"};
            JComboBox<String> dropdown_menu = new JComboBox<>(algorithms);
            //holds the name of the algorithm the user wants to use
            String algorithm_selected = dropdown_menu.getItemAt(dropdown_menu.getSelectedIndex()).toString();
            // This wrapper ensures that the dropdown menu does not take up entire screen space


            //grid cell
            /*JPanel grid = new JPanel();
            // Creates outline for the grid cell
            grid.setBorder(BorderFactory.createLineBorder(Color.black));
            grid.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    // So that we can see on the console where the user is clicking
                    System.out.println(x + "," + y);

                }
            });*/


            //BorderLayout gives a north, south, west, east layout for the screen

            // dimensions of the GUI window
            window.setLayout(new BorderLayout());
            window.setSize(600, 600);
            window.setVisible(true);

            JPanel menuWrapper = new JPanel();
            menuWrapper.add(dropdown_menu);
            window.add(menuWrapper, BorderLayout.NORTH);

            Grid cells = new Grid();
            window.add(cells);
            cells.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    int x = e.getX();
                    int y = e.getY();
                    // So that we can see on the console where the user is clicking
                    System.out.println(x + "," + y);

                }


            });

            // Instruction box
            String html = "<html><body style='width: %1spx'>%1s";
            JLabel instructions = new JLabel("Select Algorithm from dropdown menu. Left click to select source and endpoint. "
            + "Source is green, endpoint is red. Drag with left click to place obstacle. Obstacles are orange. Left click to de-select. " +
                    "Click start.");
            instructions.setPreferredSize(new Dimension(300, 500));
            instructions.setBackground(Color.lightGray);
            window.add(String.format(html,300,instructions), BorderLayout.WEST);




    }
}

