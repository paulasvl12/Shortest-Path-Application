import java.util.LinkedList;
import java.util.ArrayList;

public class BreadthFirstSearch extends Node{

   //inner queue class = basically a dll but with a few special methods
   public class Queue extends Node{
  
      public Node head;
      public Node tail;
      
      //constructor
      public Queue(){
         head = null;
         tail = null;
      }
      
      //is the queue empty?
      public boolean isEmpty(){
         return head == null;
      }
      
      //return top node without removing it from queue
      public Node peek(){
         return head;
      }
      
      //add node to end of queue
      public void enqueue(Node n){
      Node newNode = n;
         if(tail != null){
            tail.setNext(newNode);
         }
         
         tail = newNode;
         if(head == null){
            head = newNode;
         }
            
       }
       //clear the queue
       public void clear(){
         head = null;
         tail = null;
       }
       
       //remove and return top node from queue 
       public Node dequeue(){
       //find the head
       Node topNode = head;
       //replace the head with what is next in the queue
       head = head.getNext();
       //if what is next is null rest tail to null
       if(head == null){
         tail = null;
       }
       //return the previously retrieved head
       return topNode;
       }
   }
   
   //traverse the path
   public void traversal(Node s, Node e, Graph g){
   //run through all options and return a path
   
      try{
   
      //make a queue to store data
      Queue q = new Queue();
      ArrayList<LinkedList<Node>> adj = g.getAdjList(); // adjacency list of graph
      
      //add the start to the queue
      q.enqueue(s);
      s.setVisited(true);
      
      Node n = null; // node to be used to track traversal
      Node last = new Node();
      LinkedList<Node> neighbors;
      while(!q.isEmpty())  //while there is something in the queue
      {
         n = q.dequeue(); //set n to the top node of queue and remove that node from the queue
         //get and store all its neighbors 
       
                  
        neighbors = adj.get(n.getID()); //get the linked list associated with the node we just dequeued
        
         //reset color assocaited with n unless n.getState().equals("Start");
        
         for(int k=0; k < neighbors.size(); k++){  //loop through all the neighbors
           
            if(!neighbors.get(k).getVisited() && !neighbors.get(k).getState().equals("Obs")){
               q.enqueue(neighbors.get(k));	//add it to the queue
               neighbors.get(k).setPrev(n); //set the previous node to n
               neighbors.get(k).setVisited(true);
               
               if(neighbors.get(k).getState().equals("End")){
                     
                     last = neighbors.get(k);  //set n to the end point
                     q.clear(); 		//clear the queue = stop the while loop 
                     break;
                     
               }
               
               
               //color the cell associated with next yellow
            }
   
         }

      }
      
      //if n doesn't equal end print error message to user
      if(!last.getState().equals(e.getState()))
      {
         System.out.println("No path exists between the selected start and end points");
      }
      else
      {
         
         //else trace the path back
         Node finalNode = last;
         
         //while there is still another node to look at and it isn't the start
         while(finalNode != null && !finalNode.getState().equals(s.getState()))
         {
            //if it isn't the last node in the path
            if(!finalNode.getState().equals(e.getState())){
               //change the color of the cell associated with it
               System.out.print(finalNode.getID() + " ");
            }
            finalNode = finalNode.getPrev();
            
         }
      }
      }catch(IndexOutOfBoundsException exception){
         System.out.println("Graph Invalid");
      }
   }
   



}
