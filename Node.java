import java.util.*;
public class Node
       {
      	  private boolean visited;   
           private Node prev;   //used in bfs to trace the path at the end
           private Node next;  
           private String state; //start end or obstacle "Start" "End" "Obs" 
           private int distance; //used for dijstar and other weighted graphs
           private int id; //number associated with the matrix?
           private int currentCost;
           private int heuristicCost;
           private int finalCost;
           private int row;
           private int column;
      
            
      	  public Node()
      	  {
      	     visited = false;  //no nodes have been visited yet
      	     prev  = null;      
              next = null;
              state = "";
              distance = Integer.MAX_VALUE; //sets edges to ininifty
              
      	  }
           //USE THIS CONSTRUCTOR
           public Node(String type, int id, int row, int column)
           {
              visited = false;  //no nodes have been visited yet
      	     prev  = null;      
              next = null;
              state = type;
              this.id = id;
              distance = Integer.MAX_VALUE; //sets edges to ininifty
              currentCost = 0;
              heuristicCost = 0;
              finalCost = 0;
              this.row = row;
              this.column = column;
           }
           
           public Node(int dis, int id){
              distance = dis;
              visited = false;  //no nodes have been visited yet
      	     prev  = null;      
              next = null;
              state = "";
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
            if(this.visited == n.visited && this.state.equals(n.state))
               return true;
            else
               return false;
           }
}
