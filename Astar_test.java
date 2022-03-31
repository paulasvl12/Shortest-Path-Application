 import java.util.List;
 
 public class Astar_test extends AStar {
 public static void main(String[] args) {

       try {
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
                              
               Node initialNode = new Node(0, 0);
               Node finalNode = new Node(0, 4);
               int row = 3;
               int col = 3;
                               
               Graph g1 = new Graph(test1Matrix);
               AStar t = new AStar();
                 
                 
                 
               t.setBlocks(test1Matrix);
               List<Node> path = t.findPath();
               for (Node node : path) {
                     System.out.println(node);                
               }
                
       }catch (Exception e) {
         System.out.println("Something went wrong");
       
    }                
       }
}
