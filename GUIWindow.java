import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GUIWindow extends JPanel {
    private static int rows = 5;
    private static int cols = 7;
    private static int counter = 0; //number of clicks on the grid
    private static boolean startCell = false; //true means the start has been selected false means it hasn'y
    private static boolean endCell = false;//true means the end has been selected false means it hasn'y
    

    public static class Grid extends JPanel {
        public Grid() {
            setSize(400, 400);
           setVisible(true);
        }

        public void paint(Graphics g) {
            for (int x = 30; x <= 30*cols; x += 30)
                for (int y = 30; y <= 30*rows; y += 30)
                    g.drawRect(x,y, 30, 30);
        }
    }

    public static class GridResized extends JPanel{
        int x;
        int y;
        Color color;
        public GridResized() {
            setSize(400*3, 400*3);
            setVisible(true);
        }

        // resizes by a factor of 3
        public void paintResized(Graphics g){
            for (int x = 30; x <= 30*cols*3; x += 30)
                for (int y = 30; y <= 30*rows*3; y += 30)
                    g.drawRect(x,y, 30, 30);
        }

        public void paintComponent(Graphics g) {
            // System.out.println("here");
            // super.paintComponent(g);
            // Graphics2D g2d = (Graphics2D) g;

            g.setColor(color);
            g.drawRect(x,y, 30, 30);

            g.setColor(color);
            g.fillRect(x,y,30,30);


        }
    }


    public static int translateToCell(int x, int y){
        int xOrigin = 30;
        int yOrigin = 30;

        int width = 400;
        int height = 400;

        int ansX = ((x % width ) /30) -1 ;
        // idea: if click was on second row and beyond : add the result in ans (cell) plus whatever number
        // (0-6) the cell is
        int ansY = ((y % height) / 30) -1;
        // int counter = 0;
        int cellNumber = 0;


        if(ansY > 0 ){
            cellNumber = cols*ansY + ansX;
        }
        else {
            return ansX;
        }

        return cellNumber;
    }
    
    
    
    //this method will be used to color the cell assoicated with it on the graph
    //input: the cell's id number
    public Cell colorCell(int cell, Color color){
       int gridTopX = 33;
       int gridTopY = 33;
       int cellX;
       int cellY;
       
       System.out.println("HERE");
       
       int counter = 0; //row
       int holder = cell; //column
       while(holder > 7){
         holder -= 7; //subtract 7
         counter++; //increment counter
       }
       //once that is done we have the row and column -1 each
       holder++;
       counter++;
       
       cellX = 33 + (30 *holder);
       cellY = 33 + (30*counter);
       
       //now we have the x and y for the cell we want to color
       //create the cell
       Cell cellToColor = new Cell(cellX,cellY, color);
       return cellToColor;
    }
    
    
    //inner class for cell to make and color them
    public static class Cell extends JPanel {
      int x;
      int y;
      Color color;
        public Cell(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
            setVisible(true);
            
        }
        
        public void paintComponent(Graphics g) {
          System.out.println("here");
          super.paintComponent(g);
          Graphics2D g2d = (Graphics2D) g;
          g2d.setColor(color);
          g2d.drawRect(x,y, 30, 30);
          g2d.setColor(color);
          g2d.fillRect(x,y,30,30);
        }
        
    }
    
    
        public static void main(String[] args) {
            JFrame window = new JFrame("Shortest Path Application");
             window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //end the program when closed

            //dropdown menu
            String[] algorithms = {"Select Algorithm", "AStar", "BellmanFord", "Bidirectional Search", "Breadth-First Search", "Dijkstra"};
            JComboBox<String> dropdown_menu = new JComboBox<>(algorithms);
            //holds the name of the algorithm the user wants to use
            String algorithm_selected = dropdown_menu.getItemAt(dropdown_menu.getSelectedIndex()).toString();
            // This wrapper ensures that the dropdown menu does not take up entire screen space
            
            //start button
            JButton startButton = new JButton("Start");
            startButton.setBounds(50,100,95,30); 
          
            //reset button
            JButton resetButton = new JButton("Reset");
            resetButton.setBounds(50,100,95,30);
    
            //resize button
            JButton resizeButton = new JButton("Resize");
            resizeButton.setBounds(50,100,95,30);
              
            JPanel buttons = new JPanel();
            buttons.add(startButton);
            buttons.add(resetButton);
            buttons.add(resizeButton);
            


            //BorderLayout gives a north, south, west, east layout for the screen

            // dimensions of the GUI window
            window.setLayout(new BorderLayout());
            window.setSize(600, 600);
            window.setVisible(true);

            JPanel menuWrapper = new JPanel();
            menuWrapper.add(dropdown_menu);
            window.add(menuWrapper, BorderLayout.NORTH);
            //add start button and reset button
            window.add(buttons, BorderLayout.SOUTH);
            Grid cells = new Grid();
            window.add(cells);
           
            
            cells.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                
                    int x = e.getX();
                    int y = e.getY();
                    // So that we can see on the console where the user is clicking
                    //System.out.println(x + "," + y);
                    int cell = translateToCell(x,y);
                    System.out.println(cell);
                    
                    GUIWindow cellClicked = new GUIWindow();
                    //if they haven't selected a start
                    if(startCell == false)
                    {
                    //set the state of the node in the graph to Start
                    //add to counter (they have selected something)
                     counter++;
                     //set that the start has now been selected
                     startCell = true;
                     //color in the cell green
                     currentCell = cellClicked.colorCell(cell, Color.GREEN);
                    }
                    //if they already had a start but not an end
                    else if(endCell == false){
                    //set the state of the node in the graph to End
                    //add to counter (they have selected something)
                     counter++;
                     //set that they have selected a start
                     endCell = true;
                     //color the cell red
                     currentCell = cellClicked.colorCell(cell, Color.RED);
                    }
                    //already have start and end
                    else{
                    //set the state of the node in the graph to Obs
                    //add to counter (they have selected something)
                     counter++;
                     //color in the cell orange
                     currentCell = cellClicked.colorCell(cell, Color.ORANGE);
                    }
                }
            });
            
             start.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(startCell && endCell){
                        Algorithms a = new Algorithms();
                        a.start(String algorithm, Node[][] graph, int source, int end, Graph g, Node s, Node e,
                                ArrayList<Edge> edges, int n);
                    } else {
                        System.out.println("Select start and end points");
                    }

                }
            });
            
            //did they click the reset button
            
            resetButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                 //reset dropdown menu
                 dropdown_menu.setSelectedIndex(0);
                 //reset the grid
                 window.remove(cells);
                 Grid cells2 = new Grid();
                 window.add(cells2);

                  //reset all points on the graph
                  
                  //reset the counter start and end varibales
                  counter = 0;
                  startCell = false; 
                  endCell = false;
                  rows = 5;
                  cols = 7;
  

                  }
            });
            
            // Instruction box
            Border blackline = BorderFactory.createLineBorder(Color.black);
            JLabel instructions = new JLabel("<html>Select Algorithm from dropdown menu. Left click to select source and endpoint. Source is green, endpoint is red. Drag with left click to place obstacle. Obstacles are orange. Left click to de-select. Click start.</html>", SwingConstants.CENTER);
            instructions.setPreferredSize(new Dimension(300, 500));
            instructions.setBorder(blackline);
            instructions.setBackground(Color.lightGray);
            //instructions.setAlignment(Pos.NORTH);
            window.add(instructions, BorderLayout.EAST);


            resizeButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    GridResized g = new GridResized();

                }
            });

    }
    
}
