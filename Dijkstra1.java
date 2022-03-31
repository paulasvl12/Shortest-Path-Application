import java.util.*;
public class Dijkstra1 extends Node{




    public static void dijkstra(Node[][] graph, int sourceVertex, int destination){
        LinkedList<Integer> shortestPath = new LinkedList();
         try{
        int vertexCount = graph.length;
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++){
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0; // distance of source vertex to itself is zero
        for (int i = 0; i < vertexCount; i++){
            //find the neighbouring unvisited vertex having  minimum distance from source vertex
            //for the first time u will be the source vertex and the distance array will be updated with the neighbouring vertex distance of source vertex
            //returns the vertex at which we found the minimum distance from source
            int u = findMinDistance(distance, visitedVertex);
            //mark the vertex with min distance as visited
            visitedVertex[u] = true;
            //now update all the neighbor vertex distances
            for (int v =0 ; v < vertexCount; v++){
                //graph[u][v] != 0 -> there should be a direct edge
                // in here we are only looking at unvisited notes that have a direct edge with source or neighbors of node
                // or neighbors of neighbors and so on. etc
                if(!visitedVertex[v] && graph[u][v].getDistance() != 0 && (distance[u] + graph[u][v].getDistance() < distance[v])){
                    // every vertex has its distance from the previous node (where they came from, not source) saved
                    distance[v] = distance[u] + graph[u][v].getDistance();
                    // making sure there are no repetitions
                    if(!shortestPath.contains(distance[u])) {
                        shortestPath.add(distance[u]);
                    }
                }
            }
        }
        // adding the endpoint to the path although this could go away since we don't need to color
        // the endpoint. Endpoint should always be red
        shortestPath.add(destination);

        for(int i=0; i < shortestPath.size(); i++){
            System.out.println(shortestPath.get(i));
        }
        System.out.println(String.format("Distance from source vertex " + sourceVertex + " to destination " + destination +
                " is " +  distance[destination]));
            if(distance[destination] == 0){
                System.out.println("Path not found");
            }
            }catch(IndexOutOfBoundsException exception){
         System.out.println("Index Out of Bounds Error");
      }
    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i =0; i < distance.length; i++){
            //the vertex should not be visited and the distance should be the minimum.
            //this is similar to finding the min element of an array
            // Used as minimum priority queue: out of all neighbors which one has the smallest distance
            // Criteria: ENCOUNTERED FIRST
            if(!visitedVertex[i] && distance[i] < minDistance){
                minDistance = distance[i];
                //update to save the vertex at which we found the smallest distance
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
/*
        Node[][] graph = new Node[][] { { new Node(0, 0, "start"), new Node(2, 1, ""), new Node(2,2, ""), new Node(3, 3, ""), new Node(0, 4, "end") },
                                      { new Node(2, 5, ""), new Node(0, 6, ""), new Node(3, 7, ""), new Node(2, 8, ""), new Node(0, 9, "") },
                                      { new Node(2, 10, ""), new Node(3, 11, ""), new Node(0, 12, ""), new Node(2, 13, ""), new Node(0, 14, "")},
                                      { new Node(3, 15, ""), new Node(2, 16, ""), new Node(2, 17, ""), new Node(0, 18, ""), new Node(3, 19, "") },
                                      { new Node(0, 20, ""), new Node(0, 21, ""), new Node(0, 22, ""), new Node(3, 23, ""), new Node(0, 24, "") } };

int sourceVertex=0;
int destination=0;
        Graph g = new Graph(graph);
        Dijkstra1 t = new Dijkstra1();
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                if(graph[i][j].getState().equalsIgnoreCase("start")) {
                    sourceVertex = graph[i][j].getID();
                }
                else if(graph[i][j].getState().equalsIgnoreCase("end")){
                    destination = graph[i][j].getID();
                }
            }
        }

        t.dijkstra(graph, sourceVertex,destination);

        // Test cases : Out of Bounds exception thrown when given destination 5,6,7 --> write test case
        // that validates that the destination exists and isn't out of bounds
   */
    }
}
