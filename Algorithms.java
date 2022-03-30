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
         int[][] array = new int[35][35];
         int count = 0;
         
         
         
         array[0][0] = 0;
         array[1][0] = 1;
         array[2][0] = 2;
         array[3][0] = 3;
         array[4][0] = 4;
         array[5][0] = 5;
         array[6][0] = 6;
         array[7][0] = 7; 
         array[8][0] = 8;
         array[9][0] = 9;
         array[10][0] = 10;
         array[11][0] = 11;
         array[12][0] = 12;
         array[13][0] = 13;
         array[14][0] = 14;
         array[15][0] = 15;
         array[16][0] = 16;
         array[17][0] = 17;
         array[18][0] = 18;
         array[18][0] = 19;
         array[20][0] = 20;
         array[21][0] = 21;
         array[22][0] = 22;
         array[23][0] = 23;
         array[24][0] = 24;
         array[25][0] = 25;
         array[26][0] = 26;
         array[27][0] = 27;
         array[28][0] = 28;
         array[29][0] = 29;
         array[30][0] = 30;
         array[31][0] = 31;
         array[32][0] = 32;
         array[33][0] = 33;
         array[34][0] = 34;
         
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
