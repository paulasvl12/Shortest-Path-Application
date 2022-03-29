import java.util.*;
import java.lang.*;
import java.io.*;
public class bellmanfordRunner extends Graph {

      // Recursive function to print path from given vertex to source vertex
      static void getPath(int parent[], int vertex, List<Integer> path)
      {
         if (vertex < 0)
         {
            return;
         }

         getPath(parent, parent[vertex], path);
         path.add(vertex);
      }

      // Function to run Bellman-Ford algorithm from a given source
      public static void runBellmanFordAlgorithm(ArrayList<Edge> edges, int source, int n, int destination)
      {
         // distance[] and parent[] stores the shortest path
         int distance[] = new int[n];
         int parent[] = new int[n];

         // Initialize distance[] and parent[]
         // Source is set to 0, all other vertices are set to infinity and no parent
         Arrays.fill(distance, Integer.MAX_VALUE);
         distance[source] = 0;

         Arrays.fill(parent, -1);

         // Relaxation step (runs V-1 times)
         for (int i = 0; i < n - 1; i++)
         {
            for (Edge edge: edges)
            {
               int u = edge.source;
               int v = edge.dest;
               int w = edge.weight;

               // Check for shorter distance
               if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v])
               {
                  // Update distance to new lower value
                  distance[v] = distance[u] + w;

                  // Set v's parent as u
                  parent[v] = u;
               }
            }
         }

         // Run once more to check for negative-weight cycles
         for (Edge edge: edges)
         {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;

            // If the distance to u can be shortened more, negative-weight cycle present
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v])
            {
               System.out.println("Negative-weight cycle is found!");
               return;
            }
         }

         // Print the distance between given source and destination as well as the path
         if (destination != source && distance[destination] < Integer.MAX_VALUE)
         {
            List<Integer> path = new ArrayList<>();
            getPath(parent, destination, path);
            System.out.println("The distance of vertex " + destination + " from vertex " + source + " is " + distance[destination] + ". It's path is " + path);
         }
         // To add: add a statement in case source and destination never connect

      }

      public static void main(String[] args)
      {
         // Matrix used for testing the algorithm.
         int[][] matrix = {
            {0, 2, 2, 3, 0},
            {0, 0, 3, 2, 0},
            {0, 0, 0, 2, 0},
            {0, 0, 0, 0, 3},
            {0, 0, 0, 0, 0}
         };

         //Create a graph using that test matrix
         Graph testGraph = new Graph(matrix);

         ArrayList<Edge> edges = testGraph.getEdges();

         // Printing edges for testing purposes
         // System.out.println(edges);

         int n = 5;                 // Max nodes
         int destination = 4;       // Destination node
         int source = 0;            // Source node

         // Run Bellman-Ford algorithm and print path for given source to destination
         bellmanfordRunner.runBellmanFordAlgorithm(edges, source, n, destination);
      }

 }
