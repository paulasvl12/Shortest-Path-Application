import java.io.*;
import java.util.*;

public class Dijkstra2 {

    private static final Graph2.Edge[] GRAPH = {
            new Graph2.Edge(0, 1, 2),
            new Graph2.Edge(0, 7, 2),
            new Graph2.Edge(0, 8, 3),
            new Graph2.Edge(1, 0, 2),
            new Graph2.Edge(1, 2, 2),
            new Graph2.Edge(1, 8, 2),
            new Graph2.Edge(1, 7, 3),
            new Graph2.Edge(1, 9, 3),
            new Graph2.Edge(2, 1, 2),
            new Graph2.Edge(2, 3, 2),
            new Graph2.Edge(2, 9, 2),
            new Graph2.Edge(2, 8, 3),
            new Graph2.Edge(2, 10, 3),
            new Graph2.Edge(3, 2, 2),
            new Graph2.Edge(3, 4, 2),
            new Graph2.Edge(3, 10, 2),
            new Graph2.Edge(3, 9, 3),
            new Graph2.Edge(3, 11, 3),
            new Graph2.Edge(4, 3, 2),
            new Graph2.Edge(4, 5, 2),
            new Graph2.Edge(4, 11, 2),
            new Graph2.Edge(4, 10, 3),
            new Graph2.Edge(4, 12, 3),
            new Graph2.Edge(5, 4, 2),
            new Graph2.Edge(5, 6, 2),
            new Graph2.Edge(5, 12, 2),
            new Graph2.Edge(5, 11, 3),
            new Graph2.Edge(5, 13, 3),
            new Graph2.Edge(6, 5, 2),
            new Graph2.Edge(6, 13, 2),
            new Graph2.Edge(6, 12, 3),
            new Graph2.Edge(7, 0, 2),
            new Graph2.Edge(7, 8, 2),
            new Graph2.Edge(7, 14, 2),
            new Graph2.Edge(7, 1, 3),
            new Graph2.Edge(7, 15, 3),
            new Graph2.Edge(8, 7, 2),
            new Graph2.Edge(8, 9, 2),
            new Graph2.Edge(8, 1, 2),
            new Graph2.Edge(8, 15, 2),
            new Graph2.Edge(8, 0, 3),
            new Graph2.Edge(8, 2, 3),
            new Graph2.Edge(8, 14, 3),
            new Graph2.Edge(8, 16, 3),
            new Graph2.Edge(9, 8, 2),
            new Graph2.Edge(9, 2, 2),
            new Graph2.Edge(9, 10, 2),
            new Graph2.Edge(9, 16, 2),
            new Graph2.Edge(9, 1, 3),
            new Graph2.Edge(9, 3, 3),
            new Graph2.Edge(9, 15, 3),
            new Graph2.Edge(9, 17, 3),
            new Graph2.Edge(10, 9, 2),
            new Graph2.Edge(10, 3, 2),
            new Graph2.Edge(10, 11, 2),
            new Graph2.Edge(10, 17, 2),
            new Graph2.Edge(10, 2, 3),
            new Graph2.Edge(10, 4, 3),
            new Graph2.Edge(10, 16, 3),
            new Graph2.Edge(10, 18, 3),
            new Graph2.Edge(11, 10, 2),
            new Graph2.Edge(11, 4, 2),
            new Graph2.Edge(11, 12, 2),
            new Graph2.Edge(11, 18, 2),
            new Graph2.Edge(11, 3, 3),
            new Graph2.Edge(11, 5, 3),
            new Graph2.Edge(11, 17, 3),
            new Graph2.Edge(11, 19, 3),
            new Graph2.Edge(12, 11, 2),
            new Graph2.Edge(12, 5, 2),
            new Graph2.Edge(12, 13, 2),
            new Graph2.Edge(12, 19, 2),
            new Graph2.Edge(12, 4, 3),
            new Graph2.Edge(12, 6, 3),
            new Graph2.Edge(12, 18, 3),
            new Graph2.Edge(12, 20, 3),
            new Graph2.Edge(13, 6, 2),
            new Graph2.Edge(13, 12, 2),
            new Graph2.Edge(13, 20, 2),
            new Graph2.Edge(13, 5, 3),
            new Graph2.Edge(13, 19, 3),
            new Graph2.Edge(14, 7, 2),
            new Graph2.Edge(14, 15, 2),
            new Graph2.Edge(14, 21, 2),
            new Graph2.Edge(14, 8, 3),
            new Graph2.Edge(14, 22, 3),
            new Graph2.Edge(15, 18, 2),
            new Graph2.Edge(15, 8, 2),
            new Graph2.Edge(15, 16, 2),
            new Graph2.Edge(15, 22, 2),
            new Graph2.Edge(15, 7, 3),
            new Graph2.Edge(15, 9, 3),
            new Graph2.Edge(15, 21, 3),
            new Graph2.Edge(15, 23, 3),
            new Graph2.Edge(16, 15, 2),
            new Graph2.Edge(16, 9, 2),
            new Graph2.Edge(16, 17, 2),
            new Graph2.Edge(16, 23, 2),
            new Graph2.Edge(16, 8, 3),
            new Graph2.Edge(16, 10, 3),
            new Graph2.Edge(16, 22, 3),
            new Graph2.Edge(16, 24, 3),
            new Graph2.Edge(17, 16, 2),
            new Graph2.Edge(17, 10, 2),
            new Graph2.Edge(17, 18, 2),
            new Graph2.Edge(17, 24, 2),
            new Graph2.Edge(17, 9, 3),
            new Graph2.Edge(17, 11, 3),
            new Graph2.Edge(17, 23, 3),
            new Graph2.Edge(17, 25, 3),
            new Graph2.Edge(18, 17, 2),
            new Graph2.Edge(18, 11, 2),
            new Graph2.Edge(18, 19, 2),
            new Graph2.Edge(18, 25, 2),
            new Graph2.Edge(18, 10, 3),
            new Graph2.Edge(18, 12, 3),
            new Graph2.Edge(18, 24, 3),
            new Graph2.Edge(18, 26, 3),
            new Graph2.Edge(19, 18, 2),
            new Graph2.Edge(19, 12, 2),
            new Graph2.Edge(19, 20, 2),
            new Graph2.Edge(19, 26, 2),
            new Graph2.Edge(19, 11, 3),
            new Graph2.Edge(19, 13, 3),
            new Graph2.Edge(19, 25, 3),
            new Graph2.Edge(19, 27, 3),
            new Graph2.Edge(20, 13, 2),
            new Graph2.Edge(20, 19, 2),
            new Graph2.Edge(20, 27, 2),
            new Graph2.Edge(20, 12, 3),
            new Graph2.Edge(20, 26, 3),
            new Graph2.Edge(21, 14, 2),
            new Graph2.Edge(21, 22, 2),
            new Graph2.Edge(21, 28, 2),
            new Graph2.Edge(21, 15, 3),
            new Graph2.Edge(21, 29, 3),
            new Graph2.Edge(22, 21, 2),
            new Graph2.Edge(22, 15, 2),
            new Graph2.Edge(22, 23, 2),
            new Graph2.Edge(22, 29, 2),
            new Graph2.Edge(22, 14, 3),
            new Graph2.Edge(22, 16, 3),
            new Graph2.Edge(22, 28, 3),
            new Graph2.Edge(22, 30, 3),
            new Graph2.Edge(23, 22, 2),
            new Graph2.Edge(23, 16, 2),
            new Graph2.Edge(23, 24, 2),
            new Graph2.Edge(23, 30, 2),
            new Graph2.Edge(23, 15, 3),
            new Graph2.Edge(23, 17, 3),
            new Graph2.Edge(23, 29, 3),
            new Graph2.Edge(23, 31, 3),
            new Graph2.Edge(24, 23, 2),
            new Graph2.Edge(24, 17, 2),
            new Graph2.Edge(24, 25, 2),
            new Graph2.Edge(24, 31, 2),
            new Graph2.Edge(24, 16, 3),
            new Graph2.Edge(24, 18, 3),
            new Graph2.Edge(24, 30, 3),
            new Graph2.Edge(24, 32, 3),
            new Graph2.Edge(25, 24, 2),
            new Graph2.Edge(25, 18, 2),
            new Graph2.Edge(25, 26, 2),
            new Graph2.Edge(25, 32, 2),
            new Graph2.Edge(25, 17, 3),
            new Graph2.Edge(25, 19, 3),
            new Graph2.Edge(25, 31, 3),
            new Graph2.Edge(25, 33, 3),
            new Graph2.Edge(26, 25, 2),
            new Graph2.Edge(26, 19, 2),
            new Graph2.Edge(26, 27, 2),
            new Graph2.Edge(26, 33, 2),
            new Graph2.Edge(26, 18, 3),
            new Graph2.Edge(26, 20, 3),
            new Graph2.Edge(26, 32, 3),
            new Graph2.Edge(26, 34, 3),
            new Graph2.Edge(27, 26, 2),
            new Graph2.Edge(27, 20, 2),
            new Graph2.Edge(27, 34, 2),
            new Graph2.Edge(27, 19, 3),
            new Graph2.Edge(27, 33, 3),
            new Graph2.Edge(28, 21, 2),
            new Graph2.Edge(28, 22, 3),
            new Graph2.Edge(28, 29, 2),
            new Graph2.Edge(29, 28, 2),
            new Graph2.Edge(29, 22, 2),
            new Graph2.Edge(29, 30, 2),
            new Graph2.Edge(29, 21, 3),
            new Graph2.Edge(29, 23, 3),
            new Graph2.Edge(30, 29, 2),
            new Graph2.Edge(30, 23, 2),
            new Graph2.Edge(30, 31, 2),
            new Graph2.Edge(30, 22, 3),
            new Graph2.Edge(30, 24, 3),
            new Graph2.Edge(31, 30, 2),
            new Graph2.Edge(31, 24, 2),
            new Graph2.Edge(31, 32, 2),
            new Graph2.Edge(31, 23, 3),
            new Graph2.Edge(31, 25, 3),
            new Graph2.Edge(32, 31, 2),
            new Graph2.Edge(32, 25, 2),
            new Graph2.Edge(32, 33, 2),
            new Graph2.Edge(32, 24, 3),
            new Graph2.Edge(32, 26, 3),
            new Graph2.Edge(33, 32, 2),
            new Graph2.Edge(33, 26, 2),
            new Graph2.Edge(33, 34, 2),
            new Graph2.Edge(33, 25, 3),
            new Graph2.Edge(33, 27, 3),
            new Graph2.Edge(34, 33, 2),
            new Graph2.Edge(34, 27, 2),
            new Graph2.Edge(34, 26, 3),


    };
    public static int START = 34;
    public static int END = 15;

    public static void main(String[] args) {
        Graph2 g = new Graph2(GRAPH);
        g.dijkstra(START);
        g.printPath(END);
        //g.printAllPaths();


    }
}

class Graph2 extends Dijkstra2{
    public static ArrayList<Integer> shortestPath = new ArrayList<>();
    private final Map<Integer, Vertex> graph; // mapping of vertex names to Vertex objects, built from a set of Edges

    /** One edge of the graph (only used by Graph constructor) */
    public static class Edge {
        public int v1, v2;
        public final int dist;
        public Edge(int v1, int v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    /** One vertex of the graph, complete with mappings to neighbouring vertices */
    public static class Vertex implements Comparable<Vertex>{
        public int name;
        public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(int name)
        {
            this.name = name;
        }

        private void printPath()
        {

            if (this == this.previous)
            {
                System.out.printf("%s", this.name);
            }
            else if (this.previous == null)
            {
                System.out.printf("%s(unreached)", this.name);
            }
            else
            {
                this.previous.printPath();
                if(!shortestPath.contains(new Integer(START))){
                    shortestPath.add(new Integer(START));
                }
                shortestPath.add(new Integer(this.name));
                System.out.printf(" -> %s(%d)", this.name, this.dist);
                for(int i=0; i < shortestPath.size(); i++){
                    System.out.print(shortestPath.get(i) + "\t");
                }

            }
        }

        public int compareTo(Vertex other)

        {

          if (dist == other.dist) {
              if (name == other.name) {
                  return 0;
              } else if(name < other.name){
                  return -1;
              } else if(name > other.name){
                  return 1;
              }
              //    return name.compareTo((Integer)other.name); }
          }
            return Integer.compare(dist, other.dist);
        }

      /*  @Override public String toString()
        {
            return "(" + name + ", " + dist + ")";
        } */
    }

    /** Builds a graph from a set of edges */
    public Graph2(Edge[] edges) {
        graph = new HashMap<>(edges.length);

        //one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
            if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
            //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    /** Runs dijkstra using a specified source vertex */
    public void dijkstra(int startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap. */
    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void printPath(int endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }
    /** Prints the path from the source to every vertex (output order is not guaranteed) */
    public void printAllPaths() {
        for (Vertex v : graph.values()) {
            v.printPath();
            System.out.println();
        }
    }
}
