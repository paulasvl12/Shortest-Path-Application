import java.util.*;
public class Node {

     private int g;
     private int f;
     private int h;
     public int row;
     public int col;
     private boolean isBlock;
     private Node parent;
     private boolean visited;
     private Node prev;   //used in bfs to trace the path at the end
     private Node next;  
     private String state; //start end or obstacle "Start" "End" "Obs" 
     private int distance; //used for dijstar and other weighted graphs
     private int id; //number associated with the matrix?


    public void calculateHeuristic(Node finalNode) {
        this.h = Math.abs(finalNode.getRow() - getRow()) + Math.abs(finalNode.getCol() - getCol());
    }

    public void setNodeData(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        setParent(currentNode);
        setG(gCost);
        calculateFinalCost();
    }

    public boolean checkBetterPath(Node currentNode, int cost) {
        int gCost = currentNode.getG() + cost;
        if (gCost < getG()) {
            setNodeData(currentNode, cost);
            return true;
        }
        return false;
    }

    private void calculateFinalCost() {
        int finalCost = getG() + getH();
        setF(finalCost);
    }

    @Override
    public boolean equals(Object arg0) {
        Node other = (Node) arg0;
        return this.getRow() == other.getRow() && this.getCol() == other.getCol();
    }

    @Override
    public String toString() {
        return "Node [row=" + row + ", col=" + col + "]";
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean isBlock) {
        this.isBlock = isBlock;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
 
   	  public Node()
   	  {
   	     visited = false;  //no nodes have been visited yet
   	     prev  = null;      
           next = null;
           state = "";
           distance = Integer.MAX_VALUE; //sets edges to ininifty
           
           this.row = row;
           this.col = col;
           
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
           g = 0;
           h = 0;
           f = 0;
           this.row = row;
           this.col = col;
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
        
        public void setDistance(int dis)
        {
          distance = dis;
        }

                
        public boolean equals(Node n){
         if(this.visited == n.visited && this.state.equals(n.state))
            return true;
         else
            return false;
        }
}