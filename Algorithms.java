import java.util.*;

public class Algorithms extends GUIWindow{
    private int source;
    private int end;
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
    public static void start(String algorithm, Node[][] graph, int source, int end, Graph g, Node s, Node e,
                             ArrayList<Edge> edges, int n){
        if(algorithm.equalsIgnoreCase("AStar") || algorithm.equalsIgnoreCase("Select Algorithm") ){
            AStar a = new AStar();
            a.AStar(graph, source, end);
        } else if(algorithm.equalsIgnoreCase("BellmanFord")){
            bellmanfordRunner b = new bellmanfordRunner();
            b.runBellmanFordAlgorithm(edges, source, n, end);
        } else if(algorithm.equalsIgnoreCase("Bidirectional Search")){
            BidirectionalSearch b = new BidirectionalSearch();
            b.biDirectionalSearch(g, s, e);
        } else if(algorithm.equalsIgnoreCase("Breadth-First Search")){
            BFS b = new BFS();
            b.traversal(g, s, e);
        } else if(algorithm.equalsIgnoreCase("Dijkstra")){
            Dijkstra1 d = new Dijkstra1();
            d.dijkstra(graph, source, end);
        }


    }


    public static void main(String[] args){

        // calls start
        start(algorithm_selected, Node[][] graph, int source, int end, Graph g, Node s, Node e,
                ArrayList<Edge> edges, int n);
    }
}

public class mat{
     public static void main(String[] args) {
         Node[][] array = new int[35][35];
         
         //state, id, row, column
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
         
         System.out.print(array[34][0]);     
         
         
        /* for (int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
               //System.out.print(array[34][0]);
      
               System.out.println();
            }
         } */       
     }
    
}
