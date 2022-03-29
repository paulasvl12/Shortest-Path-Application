import java.util.*;
public class Node
       {
      	  private boolean visited;   
           private Node prev;   //used in bfs to trace the path at the end
           private Node next;  
           private String state; //start end or obstacle "Start" "End" "Obs" .
           private int distance; //used for dijstar and other weighted graphs
           private int id; //number associated with the matrix?
      
            
      	  public Node()
      	  {
      	     visited = false;  //no nodes have been visited yet
      	     prev  = null;      
              next = null;
              state = "";
              gridCoor = "";
              distance = Integer.MAX_VALUE; //sets edges to ininifty
              allCells++;
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
              allCells++;
              gridCoor = "";
              this.id = id;
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
}
