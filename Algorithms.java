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
            a.AStar(source, end);
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


     }
    
}