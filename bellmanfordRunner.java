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

         // Used to check whether start and end are in bounds
         int start = source;
         int end = destination;

         if (start < 0 || start >= n)
         {
            System.out.println("Your start point is out of bounds");
         }
         else if (end < 0 || end >= n)
         {
            System.out.println("Your end point is out of bounds");
         }
         else {
           try {
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
               System.out.println("The distance of vertex " + source + " to vertex " + destination + " is " + distance[destination]);
               System.out.println("It's path is " + path);
            }
            // If not path found, let the user know
            else if (destination != source && distance[destination] == Integer.MAX_VALUE)
            {
               System.out.println("There is no path between " + source + " and " + destination);
            }

           }
           catch (Exception error) {
             System.out.println("Something went wrong");
           }
         }
      }
 }
