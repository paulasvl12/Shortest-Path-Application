 import java.util.List;
 
 public class Astar_test extends Node {
 public static void main(String[] args) {

        int[][] test1Matrix = {
                  {0, 2},
                  {2, 0},
                  {0, 2},
                  {2, 3},
                  {3, 2},
                  {0, 3},
                  {0, 0},
                  {0, 0},
                  {0, 0},
               };
                              
               Node initialNode = new Node("", 3, 1, 4);
               Node finalNode = new Node("", 4, 1, 4);
               int row = 6;
               int col = 6;
                               
               Graph g1 = new Graph(test1Matrix);
               AStar t = new AStar(test1Matrix, initialNode, finalNode);
                 
                 
                 
               t.setBlocks(test1Matrix);
               List<Node> path = t.findPath();
               for (Node node : path) {
                     System.out.println(node);                
               }
                
       }
}
