import java.util.*;
import java.lang.*;
import java.io.*;

public class bellmanFordTest extends bellmanfordRunner {

   public static void main(String[] args)
      {

         // Test Cases for Bellman Ford Algorithm

         // base matrix for all test cases
         /*
         int[][] matrix = {
            {0, 2, 0, 2, 3, 0, 0, 0, 0},
            {2, 0, 2, 3, 2, 3, 0, 0, 0},
            {0, 2, 0, 0, 3, 2, 0, 0, 0},
            {2, 3, 0, 0, 2, 0, 2, 3, 0},
            {3, 2, 3, 2, 0, 2, 3, 2, 3},
            {0, 3, 2, 0, 2, 0, 0, 3, 2},
            {0, 0, 0, 3, 2, 0, 0, 2, 0},
            {0, 0, 0, 3, 2, 3, 2, 0, 2},
            {0, 0, 0, 0, 3, 2, 0, 2, 0},
         };
         */

         // Base nodes, source and destination
         int nodes;             // Max nodes
         int source;            // Source node
         int destination;       // Destination node


         // Positive Test Cases

            // Positive Test Case #1 - Graph with a path between start and end point
            System.out.println("Test case #1 - Graph with a path between start and end point");

               // Matrix used for testing the algorithm.
               int[][] test1Matrix = {
                  {0, 2, 0, 2, 3, 0, 0, 0, 0},
                  {2, 0, 2, 3, 2, 3, 0, 0, 0},
                  {0, 2, 0, 0, 3, 2, 0, 0, 0},
                  {2, 3, 0, 0, 2, 0, 2, 3, 0},
                  {3, 2, 3, 2, 0, 2, 3, 2, 3},
                  {0, 3, 2, 0, 2, 0, 0, 3, 2},
                  {0, 0, 0, 3, 2, 0, 0, 2, 0},
                  {0, 0, 0, 3, 2, 3, 2, 0, 2},
                  {0, 0, 0, 0, 3, 2, 0, 2, 0},
               };

               //Create a graph using that test matrix
               Graph testGraph1 = new Graph(test1Matrix);

               ArrayList<Edge> testEdges1 = testGraph1.getEdges();

               // Printing edges for testing purposes
               System.out.println("Edges: " + testEdges1);

               nodes = 9;
               source = 0;
               destination = 8;


               // Run Bellman-Ford algorithm and print path for given source to destination
               bellmanfordRunner.runBellmanFordAlgorithm(testEdges1, source, nodes, destination);
               System.out.println();


            // Positive Test Case #2 - Graph with no path between start and end point
            System.out.println("Test case #2 - Graph with no path between start and end point");

               // Matrix used for testing the algorithm.
               int[][] test2Matrix = {
                  {0, 2, 0, 2, 3, 0, 0, 0, 0},
                  {2, 0, 2, 3, 2, 3, 0, 0, 0},
                  {0, 2, 0, 0, 3, 2, 0, 0, 0},
                  {2, 3, 0, 0, 2, 0, 2, 3, 0},
                  {3, 2, 3, 2, 0, 2, 3, 2, 0},
                  {0, 3, 2, 0, 2, 0, 0, 3, 0},
                  {0, 0, 0, 3, 2, 0, 0, 2, 0},
                  {0, 0, 0, 3, 2, 3, 2, 0, 0},
                  {0, 0, 0, 0, 0, 0, 0, 0, 0},
               };

               //Create a graph using that test matrix
               Graph testGraph2 = new Graph(test2Matrix);

               ArrayList<Edge> testEdges2 = testGraph2.getEdges();

               // Printing edges for testing purposes
               System.out.println("Edges: " + testEdges2);

               nodes = 9;             // Max nodes
               source = 0;            // Source node
               destination = 8;       // Destination node


               // Run Bellman-Ford algorithm and print path for given source to destination
               bellmanfordRunner.runBellmanFordAlgorithm(testEdges2, source, nodes, destination);
               System.out.println();


         // Negative Test Cases

            // Negative Test Case #1 - Selected start point is not in bounds of graph
            System.out.println("Test case #3 - Selected start point is not in bounds of graph");

               // Matrix used for testing the algorithm.
               int[][] test3Matrix = {
                  {0, 2, 0, 2, 3, 0, 0, 0, 0},
                  {2, 0, 2, 3, 2, 3, 0, 0, 0},
                  {0, 2, 0, 0, 3, 2, 0, 0, 0},
                  {2, 3, 0, 0, 2, 0, 2, 3, 0},
                  {3, 2, 3, 2, 0, 2, 3, 2, 3},
                  {0, 3, 2, 0, 2, 0, 0, 3, 2},
                  {0, 0, 0, 3, 2, 0, 0, 2, 0},
                  {0, 0, 0, 3, 2, 3, 2, 0, 2},
                  {0, 0, 0, 0, 3, 2, 0, 2, 0},
               };

               //Create a graph using that test matrix
               Graph testGraph3 = new Graph(test3Matrix);

               ArrayList<Edge> testEdges3 = testGraph3.getEdges();

               // Printing edges for testing purposes
               System.out.println("Edges: " + testEdges3);

               nodes = 9;
               source = -1;
               destination = 8;


               // Run Bellman-Ford algorithm and print path for given source to destination
               bellmanfordRunner.runBellmanFordAlgorithm(testEdges3, source, nodes, destination);
               System.out.println();


            // Negative Test Case #2 - Selected end point is not in bounds of graph
            System.out.println("Test case #4 - Selected end point is not in bounds of graph");

               // Matrix used for testing the algorithm.
               int[][] test4Matrix = {
                  {0, 2, 0, 2, 3, 0, 0, 0, 0},
                  {2, 0, 2, 3, 2, 3, 0, 0, 0},
                  {0, 2, 0, 0, 3, 2, 0, 0, 0},
                  {2, 3, 0, 0, 2, 0, 2, 3, 0},
                  {3, 2, 3, 2, 0, 2, 3, 2, 3},
                  {0, 3, 2, 0, 2, 0, 0, 3, 2},
                  {0, 0, 0, 3, 2, 0, 0, 2, 0},
                  {0, 0, 0, 3, 2, 3, 2, 0, 2},
                  {0, 0, 0, 0, 3, 2, 0, 2, 0},
               };

               //Create a graph using that test matrix
               Graph testGraph4 = new Graph(test4Matrix);

               ArrayList<Edge> testEdges4 = testGraph4.getEdges();

               // Printing edges for testing purposes
               System.out.println("Edges: " + testEdges4);

               nodes = 9;
               source = 0;
               destination = 10;


               // Run Bellman-Ford algorithm and print path for given source to destination
               bellmanfordRunner.runBellmanFordAlgorithm(testEdges4, source, nodes, destination);
               System.out.println();
      }

}
