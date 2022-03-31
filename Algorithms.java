import java.util.*;

public class Algorithms extends GUIWindow {
    private int source;
    private int end;
    private Graph graphtwo;
    private Node[][] graph;
    private ArrayList<LinkedList<Node>> adjList;

    public int getSource(){
        return source;
    }
    
    public void setSource(int s){
        source = s;
    }
    
    public int getEnd(){
        return end;
    }
    
    public void setEnd(int e){
        end = e;
    }
    
    public Node[][] getGraph(){
        return graph;
    }
    
    public void setGraph(Node[][] g){
        graph = g;
    }

    // start method : given String which is name of the algorithm

    // *******     Fix <Edge> class issue                  ******/
    // public static void start(String algorithm, Node[][] graph, int source, int end, Graph g, Node s, Node e,
    //                          int n){
    //     if(algorithm.equalsIgnoreCase("AStar") || algorithm.equalsIgnoreCase("Select Algorithm") ){
    //         AStar a = new AStar();
    //         a.AStar(graph, source, end);
    //     } else if(algorithm.equalsIgnoreCase("BellmanFord")){
    //       g.updateMatrix();
    //       ArrayList<Edge> edges = g.getEdges();
    //       bellmanfordRunner b = new bellmanfordRunner();
    //       b.runBellmanFordAlgorithm(edges, start.getID(), 35, end.getID());
    //     } else if(algorithm.equalsIgnoreCase("Bidirectional Search")){
    //         BidirectionalSearch b = new BidirectionalSearch();
    //         b.biDirectionalSearch(g, s, e);
    //     } else if(algorithm.equalsIgnoreCase("Breadth-First Search")){
    //         BFS b = new BFS();
    //         b.traversal(g, s, e);
    //     } else if(algorithm.equalsIgnoreCase("Dijkstra")){
    //         Dijkstra1 d = new Dijkstra1();
    //         d.dijkstra(graph, source, end);
    //     }
    // }
    
     public static void start(String algorithm, Node[][] graph, int source, int end, Graph g, Node s, Node e,
                             ArrayList<Node> allCells, int n){
        if(algorithm.equalsIgnoreCase("AStar") || algorithm.equalsIgnoreCase("Select Algorithm") ){
       //     AStar a = new AStar();
         //   a.AStar(source, end);
        } else if(algorithm.equalsIgnoreCase("BellmanFord")){
            // Update matrix with cell information
             g.updateMatrix();
        
           // Get the edges between all the nodes
           ArrayList<Edge> edges = g.getEdges();
        
           // Run Bellman Ford 
           bellmanfordRunner b = new bellmanfordRunner();
           b.runBellmanFordAlgorithm(edges, s.getID(), 35, e.getID());
           bellmanfordRunner bell = new bellmanfordRunner();
           bell.runBellmanFordAlgorithm(edges, source, n, end);
        } else if(algorithm.equalsIgnoreCase("Bidirectional Search")){
            BidirectionalSearch bi = new BidirectionalSearch();
            bi.biDirectionalSearch(s, e, g);
        } else if(algorithm.equalsIgnoreCase("Breadth-First Search")){
            BreadthFirstSearch b = new BreadthFirstSearch();
            b.traversal(s, e, g);
        } else if(algorithm.equalsIgnoreCase("Dijkstra")){
            Dijkstra1 d = new Dijkstra1();
            d.dijkstra(graph, source, end);
	    }
    }
   
    

    public static void main(String[] args){

        // calls start
        // start(algorithm_selected, Node[][] graph, int source, int end, Graph g, Node s, Node e,
        //         ArrayList<Edge> edges, int n);
    }
}

    /* public class mat{
    public static void main(String[] args) {
      
      Node[][] array = new int[35][35];
         
      state, id, row, column
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

      Comment for example
         array[0][0] = n0;
         array[1][0] = n1;
         array[2][0] = n2;
         array[3][0] = n3;
         array[4][0] = n4;
         array[5][0] = n5;
         array[6][0] = n6;
         array[7][0] = n7; 
         array[8][0] = n8;
         array[9][0] = n9;
         array[10][0] = n10;
         array[11][0] = n11;
         array[12][0] = n12;
         array[13][0] = n13;
         array[14][0] = n14;
         array[15][0] = n15;
         array[16][0] = n16;
         array[17][0] = n17;
         array[18][0] = n18;
         array[18][0] = n19;
         array[20][0] = n20;
         array[21][0] = n21;
         array[22][0] = n22;
         array[23][0] = n23;
         array[24][0] = n24;
         array[25][0] = n25;
         array[26][0] = n26;
         array[27][0] = n27;
         array[28][0] = n28;
         array[29][0] = n29;
         array[30][0] = n30;
         array[31][0] = n31;
         array[32][0] = n32;
         array[33][0] = n33;
         array[34][0] = n34;
                  
         array[0][1] = 35;
         array[1][1] = 36;
         array[2][1] = 37;
         array[3][1] = 38;
         array[4][1] = 39;
         array[5][1] = 40;
         array[6][1] = 41;
         array[7][1] = 42;
         array[8][1] = 43;
         array[9][1] = 44;
         array[10][1] = 45;
         array[11][1] = 46;
         array[12][1] = 47;
         array[13][1] = 48;
         array[14][1] = 49;
         array[15][1] = 50;
         array[16][1] = 51;
         array[17][1] = 52;
         array[18][1] = 53;
         array[19][1] = 54;
         array[20][1] = 55;
         array[21][1] = 56;
         array[22][1] = 57;
         array[23][1] = 58;
         array[24][1] = 59;
         array[25][1] = 60;
         array[26][1] = 61;
         array[27][1] = 62;
         array[28][1] = 63;
         array[29][1] = 64;
         array[30][1] = 65;
         array[31][1] = 66;
         array[32][1] = 67;
         array[33][1] = 68;
         array[34][1] = 69; 
                  
         array[0][2] = 70;
         array[1][2] = 71;
         array[2][2] = 72;
         array[3][2] = 73;
         array[4][2] = 74;
         array[5][2] = 75;
         array[6][2] = 76;
         array[7][2] = 77;
         array[8][2] = 78;
         array[9][2] = 79;
         array[10][2] = 80;
         array[11][2] = 81;
         array[12][2] = 82;
         array[13][2] = 83;
         array[14][2] = 84;
         array[15][2] = 85;
         array[16][2] = 86;
         array[17][2] = 87;
         array[18][2] = 88;
         array[19][2] = 89;
         array[20][2] = 90;
         array[21][2] = 91;
         array[22][2] = 92;
         array[23][2] = 93;
         array[24][2] = 94;
         array[25][2] = 95;
         array[26][2] = 96;
         array[27][2] = 97;
         array[28][2] = 98;
         array[29][2] = 99;
         array[30][2] = 100;
         array[31][2] = 101;
         array[32][2] = 102;
         array[33][2] = 103;
         array[34][2] = 104;    
                  
         System.out.print(array[34][0]); */     
         
         
        /* for (int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
               //System.out.print(array[34][0]);
      
               System.out.println();
            }
         } */
         
         /*
         Node n1 = new Node(0,0,"start");
         Node n2 = new Node(0, 0, "");
         Node n3 = new Node(0, 0, "");
         Node n4 = new Node(0,0, "");
         Node n5 = new Node(0,0,"end");
         Node n6= new Node(0, 0, "");
         Node n7 = new Node(0, 0, "");
         Node n8 = new Node(0,0, "");
         Node n9 = new Node(0,0,"");
         Node n10 = new Node(0, 0, "");
         Node n11= new Node(0, 0, "");
         Node n12= new Node(0,0, "");
         Node n13= new Node(0,0,"");
         Node n14= new Node(0, 0, "");
         Node n15= new Node(0, 0, "");
         Node n16 = new Node(0,0, "");
         Node n17= new Node(0,0,"");
         Node n18= new Node(0, 0, "");
         Node n19= new Node(0, 0, "");
         Node n20 = new Node(0,0, "");
         Node n21= new Node(0,0, "");
         Node n22 = new Node(0,0,"");
         Node n23= new Node(0, 0, "");
         Node n24= new Node(0, 0, "");
         Node n25= new Node(0,0, "");
         Node n26= new Node(0,0,"");
         Node n27= new Node(0, 0, "");
         Node n28= new Node(0, 0, "");
         Node n29= new Node(0,0, "");
         Node n30= new Node(0,0,"");
         Node n31= new Node(0, 0, "");
         Node n32= new Node(0, 0, "");
         Node n33 = new Node(0,0, "");
         Node n34= new Node(0,0,"");
         Node n35= new Node(0, 0, "");
         */
         
//      }
    
// }