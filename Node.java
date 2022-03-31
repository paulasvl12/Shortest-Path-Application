import java.util.*;
public class Node implements Comparable<Node>
       {
      	  private boolean visited;
           private Node prev;   //used in bfs to trace the path at the end
           private Node next;
           private String state; //start end or obstacle "Start" "End" "Obs" .
           private String gridCoor; //how we will connect it to our visual represenation
           private int distance; //used for dijstar and other weighted graphs
           public int id; //number associated with the matrix?
           public List<Graph> neighbors;
           private static int idCounter = 0;
           public Node parent = null;
           public double f = Double.MAX_VALUE;
           public double g = Double.MAX_VALUE;
           public double h;
           
           public Node(double h){
               this.h = h;
               this.id = idCounter++;
               this.neighbors = new ArrayList<>();
           
           }


      	  public Node()
      	  {
      	     visited = false;  //no nodes have been visited yet
      	     prev  = null;
              next = null;
              state = "";
              gridCoor = "";
              distance = Integer.MAX_VALUE; //sets edges to ininifty
              //allCells++;
      	  }

           public Node(String type, String coor, int id)
           {
              visited = false;  //no nodes have been visited yet
      	     prev  = null;
              next = null;
              state = type;

              gridCoor = coor;
              this.id = id;
              distance = Integer.MAX_VALUE; //sets edges to ininifty
           }

           public Node(int dis, int id){
              distance = dis;
              visited = false;  //no nodes have been visited yet
      	     prev  = null;
              next = null;
              state = "";
              //allCells++;
              gridCoor = "";
              this.id = id;
           }
           public String getGridCoor(){
            return gridCoor;
           }
           public void setGridCoor(String n){
            gridCoor = n;
           }

           public int getID(){
            return id;
           }

           public void setID(int n){
            id = n;
           }

           public boolean getVisited(){
            return visited;
           }

           public void setVisited(boolean b){
            visited = b;
           }
           public String getState(){
            return state;
           }
           public void setState(String s){
            state = s;
           }
           public Node getNext(){
            return next;
           }
           public void setNext(Node n){
            next = n;
           }

           public Node getPrev(){
            return prev;
           }
           public void setPrev(Node n){
            prev = n;
           }

           public int getDistance()
           {
             return distance;
           }

           public boolean equals(Node n){
            if(this.visited == n.visited && this.state.equals(n.state) && this.gridCoor.equals(n.gridCoor))
               return true;
            else
               return false;
           }
           
           public int compareTo(Node n){
               return Double.compare(this.f, n.f);
           }
           
           public void addBranch(int weight, Node node){
               Graph newGraph = new Graph(weight, node);
               neighbors.add(newGraph);
                         
          }
          
          public double calculateHeuristic(Node target){
            return this.h;
          }
}
