import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.ArrayList;

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
    
    /*
    
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
        
    }*/
    
   public static void main(String[] args) {
        
   // Create adjList graph
      Node n0 = new Node("",0, 0, 0);
      Node n1 = new Node("",1, 0, 1);
      Node n2 = new Node("",2, 0, 2);
      Node n3 = new Node("",3, 0, 3);
      Node n4 = new Node("",4, 0, 4);
      Node n5 = new Node("",5, 0, 5);
      Node n6 = new Node("",6, 0, 6);
      Node n7 = new Node("",7, 1, 0);
      Node n8 = new Node("",8, 1, 1);
      Node n9 = new Node("",9, 1, 2);
      Node n10 = new Node("",10, 1, 3);
      Node n11 = new Node("",11, 1, 3);
      Node n12 = new Node("",12, 1, 3);
      Node n13 = new Node("",13, 1, 3);
      Node n14 = new Node("",14, 2, 0);
      Node n15 = new Node("",15, 2, 1);
      Node n16 = new Node("",16, 2, 2);
      Node n17 = new Node("",17, 2, 3);
      Node n18 = new Node("",18, 2, 4);
      Node n19 = new Node("",19, 2, 5);
      Node n20 = new Node("",20, 2, 6);
      Node n21 = new Node("",21, 3, 0);
      Node n22 = new Node("",22, 3, 1);
      Node n23 = new Node("",23, 3, 2);
      Node n24 = new Node("",24, 3, 3);
      Node n25 = new Node("",25, 3, 4);
      Node n26 = new Node("",26, 3, 5);
      Node n27 = new Node("",27, 3, 6);
      Node n28 = new Node("",28, 4, 0);
      Node n29 = new Node("",29, 4, 1);
      Node n30 = new Node("",30, 4, 2);
      Node n31 = new Node("",31, 4, 3);
      Node n32 = new Node("",32, 4, 4);
      Node n33 = new Node("",33, 4, 5);
      Node n34 = new Node("",34, 4, 6);
      
      ArrayList<Node> cellArr = new ArrayList<Node>();
         cellArr.add(n0);
         cellArr.add(n1);
         cellArr.add(n2);
         cellArr.add(n3);
         cellArr.add(n4);
         cellArr.add(n5);
         cellArr.add(n6);
         cellArr.add(n7);
         cellArr.add(n8);
         cellArr.add(n9);
         cellArr.add(n10);
         cellArr.add(n11);
         cellArr.add(n12);
         cellArr.add(n13);
         cellArr.add(n14);
         cellArr.add(n15);
         cellArr.add(n16);
         cellArr.add(n17);
         cellArr.add(n18);
         cellArr.add(n19);
         cellArr.add(n20);
         cellArr.add(n21);
         cellArr.add(n22);
         cellArr.add(n23);
         cellArr.add(n24);
         cellArr.add(n25);
         cellArr.add(n26);
         cellArr.add(n27);
         cellArr.add(n28);
         cellArr.add(n29);
         cellArr.add(n30);
         cellArr.add(n31);
         cellArr.add(n32);
         cellArr.add(n33);
         cellArr.add(n34);
         
      LinkedList<Node> list0 = new LinkedList<Node>();
         list0.add(n1);
         list0.add(n7);
         list0.add(n8);
      LinkedList<Node> list1 = new LinkedList<Node>();
         list1.add(n0);
         list1.add(n2);
         list1.add(n7);
         list1.add(n8);
         list1.add(n9);
      LinkedList<Node> list2 = new LinkedList<Node>();
         list2.add(n1);
         list2.add(n3);
         list2.add(n8);
         list2.add(n9);
         list2.add(n10);
      LinkedList<Node> list3 = new LinkedList<Node>();
         list3.add(n2);
         list3.add(n4);
         list3.add(n9);
         list3.add(n10);
         list3.add(n11);
      LinkedList<Node> list4 = new LinkedList<Node>();
         list4.add(n3);
         list4.add(n5);
         list4.add(n10);
         list4.add(n11);
         list4.add(n12);
      LinkedList<Node> list5 = new LinkedList<Node>();
         list5.add(n4);
         list5.add(n6);
         list5.add(n11);
         list5.add(n12);
         list5.add(n13);
      LinkedList<Node> list6 = new LinkedList<Node>();
         list6.add(n5);
         list6.add(n12);
         list6.add(n13);
      LinkedList<Node> list7 = new LinkedList<Node>();
         list7.add(n0);
         list7.add(n1);
         list7.add(n8);
         list7.add(n14);
         list7.add(n15);
      LinkedList<Node> list8 = new LinkedList<Node>();
         list8.add(n0);
         list8.add(n1);
         list8.add(n2);
         list8.add(n7);
         list8.add(n9);
         list8.add(n14);
         list8.add(n15);
         list8.add(n16);
      LinkedList<Node> list9 = new LinkedList<Node>();
         list9.add(n1);
         list9.add(n2);
         list9.add(n3);
         list9.add(n8);
         list9.add(n10);
         list9.add(n15);
         list9.add(n16);
      LinkedList<Node> list10 = new LinkedList<>();
         list10.add(n2);
         list10.add(n3);
         list10.add(n4);
         list10.add(n9);
         list10.add(n11);
         list10.add(n16);
         list10.add(n17);
         list10.add(n18);
      LinkedList<Node> list11 = new LinkedList<>();
         list11.add(n3);
         list11.add(n4);
         list11.add(n5);
         list11.add(n10);
         list11.add(n12);
         list11.add(n17);
         list11.add(n18);
         list11.add(n19);
      LinkedList<Node> list12 = new LinkedList<>();
         list12.add(n4);
         list12.add(n5);
         list12.add(n6);
         list12.add(n11);
         list12.add(n13);
         list12.add(n18);
         list12.add(n19);
         list12.add(n20);
      LinkedList<Node> list13 = new LinkedList<>();
         list13.add(n5);
         list13.add(n6);
         list13.add(n12);
         list13.add(n19);
         list13.add(n20);
      LinkedList<Node> list14 = new LinkedList<>();
         list14.add(n7);
         list14.add(n8);
         list14.add(n15);
         list14.add(n21);
         list14.add(n22);
      LinkedList<Node> list15 = new LinkedList<>();
         list15.add(n7);
         list15.add(n8);
         list15.add(n9);
         list15.add(n14);
         list15.add(n16);
         list15.add(n21);
   		list15.add(n22);
   		list15.add(n23);
      LinkedList<Node> list16 = new LinkedList<>();
         list16.add(n8);
         list16.add(n9);
         list16.add(n10);
         list16.add(n15);
         list16.add(n17);
         list16.add(n22);
         list16.add(n23);
         list16.add(n24);
      LinkedList<Node> list17 = new LinkedList<>();
         list17.add(n9);
         list17.add(n10);
         list17.add(n11);
         list17.add(n16);
         list17.add(n18);
         list17.add(n23);
         list17.add(n24);
         list17.add(n25);
      LinkedList<Node> list18 = new LinkedList<>();
         list18.add(n10);
         list18.add(n11);
         list18.add(n12);
         list18.add(n17);
		   list18.add(n19);
		   list18.add(n24);
		   list18.add(n25);
		   list18.add(n26);
		LinkedList<Node> list19 = new LinkedList<>();
         list19.add(n11);
         list19.add(n12);
         list19.add(n13);
         list19.add(n18);
         list19.add(n20);
         list19.add(n25);
         list19.add(n26);
         list19.add(n27);
      LinkedList<Node> list20 = new LinkedList<>();
         list20.add(n12);
         list20.add(n13);
         list20.add(n19);
         list20.add(n26);
         list20.add(n27);
      LinkedList<Node> list21 = new LinkedList<>();
         list21.add(n14);
         list21.add(n15);
         list21.add(n22);
         list21.add(n28);
         list21.add(n29);
      LinkedList<Node> list22 = new LinkedList<>();
         list22.add(n14);
         list22.add(n15);
         list22.add(n16);
         list22.add(n21);
         list22.add(n23);
         list22.add(n28);
         list22.add(n29);
         list22.add(n30);
      LinkedList<Node> list23 = new LinkedList<>();
         list23.add(n15);
         list23.add(n16);
         list23.add(n17);
         list23.add(n22);
         list23.add(n24);
         list23.add(n29);
         list23.add(n30);
         list23.add(n31);
      LinkedList<Node> list24 = new LinkedList<>();
         list24.add(n16);
         list24.add(n17);
         list24.add(n18);
         list24.add(n23);
         list24.add(n25);
         list24.add(n30);
         list24.add(n31);
         list24.add(n32);
      LinkedList<Node> list25 = new LinkedList<>();
         list25.add(n17);
         list25.add(n18);
         list25.add(n19);
         list25.add(n24);
         list25.add(n26);
         list25.add(n31);
         list25.add(n32);
		   list25.add(n33);
      LinkedList<Node> list26 = new LinkedList<>();
         list26.add(n18);
         list26.add(n19);
		   list26.add(n20);
		   list26.add(n25);
		   list26.add(n27);
		   list26.add(n32);
		   list26.add(n33);
		   list26.add(n34);
		LinkedList<Node> list27 = new LinkedList<>();
		   list27.add(n19);
		   list27.add(n20);
		   list27.add(n26);
		   list27.add(n33);
		   list27.add(n34);
		LinkedList<Node> list28 = new LinkedList<>();
		   list28.add(n21);
		   list28.add(n22);
		   list28.add(n29);
		LinkedList<Node> list29 = new LinkedList<>();
		   list29.add(n21);
		   list29.add(n22);
		   list29.add(n23);
		   list29.add(n28);
		   list29.add(n30);
		LinkedList<Node> list30 = new LinkedList<>();
		   list30.add(n22);
		   list30.add(n23);
		   list30.add(n24);
		   list30.add(n29);
		   list30.add(n31);
		LinkedList<Node> list31 = new LinkedList<>();
		   list31.add(n23);
		   list31.add(n24);
		   list31.add(n25);
		   list31.add(n30);
		   list31.add(n32);
		LinkedList<Node> list32 = new LinkedList<>();
		   list32.add(n24);
		   list32.add(n25);
		   list32.add(n26);
		   list32.add(n31);
		   list32.add(n33);
		LinkedList<Node> list33 = new LinkedList<>();
		   list33.add(n25);
		   list33.add(n26);
		   list33.add(n27);
		   list33.add(n32);
		   list33.add(n33);
		   list33.add(n34);
		LinkedList<Node> list34 = new LinkedList<>();
		   list34.add(n26);
		   list34.add(n27);
		   list34.add(n33);
         
      ArrayList<LinkedList<Node>> adjList = new ArrayList<LinkedList<Node>>();
         adjList.add(list0);
         adjList.add(list1);
         adjList.add(list2);
         adjList.add(list3);
         adjList.add(list4);
         adjList.add(list5);
         adjList.add(list6);
         adjList.add(list7);
         adjList.add(list8);
         adjList.add(list9);
         adjList.add(list10);
         adjList.add(list11);
         adjList.add(list12);
         adjList.add(list13);
         adjList.add(list14);
         adjList.add(list15);
         adjList.add(list16);
         adjList.add(list17);
         adjList.add(list18);
         adjList.add(list19);
         adjList.add(list20);
         adjList.add(list21);
         adjList.add(list22);
         adjList.add(list23);
         adjList.add(list24);
         adjList.add(list25);
         adjList.add(list26);
         adjList.add(list27);
         adjList.add(list28);
         adjList.add(list29);
         adjList.add(list30);
         adjList.add(list31);
         adjList.add(list32);
         adjList.add(list33);
         adjList.add(list34);

         Graph adjGraph = new Graph(adjList, cellArr);
        Node[][] graphDijkstra = new Node[][] {   { n0, n1, n2, n3, n4, n5, n6 },
                                                        {n7, n8, n9, n10, n11, n12, n13 },
                                                        { n14, n15, n16, n17, n18, n19, n20},
                                                        { n21, n22, n23, n24, n25, n26, n27 },
                                                        { n28, n29, n30, n31, n32, n33, n34 } };
                                                        
        int[][] graphAStar = {
        {0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2, 3, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 2, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 3, 2},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 0, 0, 0, 0, 2, 0, 2},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 0, 0, 0, 0, 0, 2, 0}
      };
        
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
           
         //Cell currentCell;
         //left click action listener for grid
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
               //only change the value if it doesn't already have a set state
               if(cellArr.get(cell).getState().equals("")){
                  //if they haven't selected a start
                  if(startCell == false)
                  {
                     //set the state of the node in the graph to Start
                     cellArr.get(cell).setState("Start");
                             
                             
                     //add to counter (they have selected something)
                     counter++;
                     //set that the start has now been selected
                     startCell = true;
                     //color in the cell green
                     //  currentCell = cellClicked.colorCell(cell, Color.GREEN);
                  }
                  //if they already had a start but not an end
                  else if(endCell == false){
                     //set the state of the node in the graph to End
                     cellArr.get(cell).setState("End");
                     //add to counter (they have selected something)
                     counter++;
                     //set that they have selected a start
                     endCell = true;
                     //color the cell red
                     // currentCell = cellClicked.colorCell(cell, Color.RED);
                  }
                  //already have start and end
                  else{
                     //set the state of the node in the graph to Obs
                     cellArr.get(cell).setState("Obs");
                     //add to counter (they have selected something)
                     counter++;
                     //color in the cell orange
                     // currentCell = cellClicked.colorCell(cell, Color.ORANGE);
                  }
   
               }
            }

         });
            
         //right click action listener for grid
         cells.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               //right click
               if(e.isMetaDown()){
                  int x = e.getX();
                  int y = e.getY();
                  // So that we can see on the console where the user is clicking
                  //System.out.println(x + "," + y);
                  int cell = translateToCell(x,y);
                       
   
                  //get the state of the node and store it
                  String s = cellArr.get(cell).getState();
                  //if it was start or end reset the boolean for selected
                  if(s.equals("Start"))
                  {
                     startCell = false;
                  }
                  if(s.equals("End"))
                  {
                     endCell = false;
                  }
                  counter--;
                        
                  //reset the state of associated node to ""
                  cellArr.get(cell).setState("");
                  //color the cell white again/remove the color
               }
                
            }
      });

             startButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(startCell && endCell){
                    startButton.setEnabled(false);
                  resizeButton.setEnabled(false);
                  dropdown_menu.setEnabled(false);
                    Node start = null;
                    Node end = null;
                    //get the start and end node
                    for(int i = 0; i < cellArr.size(); i++){
                        if(!cellArr.get(i).getState().equals("") && !cellArr.get(i).getState().equals("Obs")){
                             if(cellArr.get(i).getState().equals("Start")){
                                 start = cellArr.get(i);
                             }
                             else {
                                 end = cellArr.get(i);
                             }
                        }
                    }
                    //get the algorithm selected
                    String algo = (String) dropdown_menu.getSelectedItem();
                   Algorithms a = new Algorithms();
                   //drop-down selection, graph for Dijkstra, start node id, end node id, graph that hold adj list, start node, end node, arraylist of all the node, and size of graph
                    a.start(algo, graphDijkstra, start.getID(), end.getID(), adjGraph, start, end, cellArr, 34, graphAStar);
                    
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
          dropdown_menu.setEnabled(true);
           //enable the start and resize buttons again
           startButton.setEnabled(true);
           resizeButton.setEnabled(true);
         //reset the grid
                  
         //reset the counter start and end varibales
         counter = 0;
         startCell = false; 
         endCell = false;
         rows = 5;
         cols = 7;
         
        
          //reset all points on the graph
             for(int i = 0; i < cellArr.size(); i++){
                    cellArr.get(i).setState("");
                    cellArr.get(i).setDistance(Integer.MAX_VALUE);
                    cellArr.get(i).setPrev(null);
                    cellArr.get(i).setNext(null);
                    cellArr.get(i).setVisited(false);
              }

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

      //not working currently
      resizeButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
            
            window.remove(cells);

            GridResized gridResized = new GridResized();
            window.add(gridResized);
            gridResized.addMouseListener(new MouseAdapter() {
               @Override
               public void mousePressed(MouseEvent e) {
                  int clickCounter = 0;
                  int x = e.getX();
                  int y = e.getY();
                  // So that we can see on the console where the user is clicking
                  // System.out.println(x + "," + y);
                  // Call to translateToCell()
                  int cell = translateToCell(x,y);
                  System.out.println(cell);

                  //GUIWindow cellClicked = new GUIWindow();
                 // Cell currentCell;
                  if(startCell == false)
                  {
                     counter++;
                     startCell = true;
                     // currentCell = cellClicked.colorCell(cell, Color.GREEN);
                  }
                  else if(endCell == false){
                  counter++;
                  endCell = true;
                  // currentCell = cellClicked.colorCell(cell, Color.RED);
                  }
                  else{
                     counter++;
                     // currentCell = cellClicked.colorCell(cell, Color.ORANGE);
                  }


               }

            });
         }
      });
   }
}