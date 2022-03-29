import java.util.LinkedList;
import java.util.ArrayList;
import java.io.IOException;
public class BFSUnitTest{
   public static void main(String[] args) {
   //positive test cases
      //test 1 - example from class there are 5 nodes and only 1 path avaible
        Node start = new Node("Start", 0);
        Node end = new Node("End", 4);
        Node n = new Node("", 1);
        Node n2 = new Node("", 2);
        Node n3 = new Node("", 3);
        LinkedList<Node> list0 = new LinkedList<Node>();
        list0.add(n);
        list0.add(n2);
        list0.add(n3);
        
        LinkedList<Node> list1 = new LinkedList<Node>();
        list1.add(start);
        list1.add(n2);
        list1.add(n3);
        
        LinkedList<Node> list2 = new LinkedList<Node>();
        list2.add(start);
        list2.add(n);
        list2.add(n3);
        
        LinkedList<Node> list3 = new LinkedList<Node>();
        list3.add(start);
        list3.add(n);
        list3.add(n2);
        list3.add(end);
        
        LinkedList<Node> list4 = new LinkedList<Node>();
        list4.add(n3);
     
        ArrayList<LinkedList<Node>> group = new ArrayList<LinkedList<Node>>();
        group.add(list0);
        group.add(list1);
        group.add(list2);
        group.add(list3);
        group.add(list4);
        
        Graph g = new Graph(group);
        g.getAdjList();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.traversal(start, end, g);
      //test 2 - there are multiple paths to reach the destination all of the same length
         Node t2start = new Node("Start", 1);
         Node t2end = new Node("End", 7);
         Node t2n0 = new Node("", 0);
         Node t2n2 = new Node("", 2);
         Node t2n3 = new Node("", 3);
         Node t2n4 = new Node("Obs", 4);
         Node t2n5 = new Node("", 5);
         Node t2n6 = new Node("", 6);
         Node t2n8 = new Node("", 8);
         
         LinkedList<Node> t2list0 = new LinkedList<Node>();
         t2list0.add(t2n3);
         t2list0.add(t2start);
         t2list0.add(t2n4); //obs
         LinkedList<Node> t2list1 = new LinkedList<Node>();
         t2list1.add(t2n0);
         t2list1.add(t2n2);
         t2list1.add(t2n3);
         t2list1.add(t2n4); //obs
         t2list1.add(t2n5);
         LinkedList<Node> t2list3 = new LinkedList<Node>();
         t2list3.add(t2n0); 
         t2list3.add(t2start);
         t2list3.add(t2n4); //obs
         t2list3.add(t2n6);
         t2list3.add(t2end);
         LinkedList<Node> t2list4 = new LinkedList<Node>();
         t2list4.add(t2n0);
         t2list4.add(t2start);
         t2list4.add(t2n2);
         t2list4.add(t2n3);
         t2list4.add(t2n5);
         t2list4.add(t2n6);
         t2list4.add(t2end);
         t2list4.add(t2n8);
         LinkedList<Node> t2list5 = new LinkedList<Node>();
         t2list5.add(t2start);
         t2list5.add(t2n2);
         t2list5.add(t2n4); //obs
         t2list5.add(t2end);
         t2list5.add(t2n8);
         LinkedList<Node> t2list6 = new LinkedList<Node>();
         t2list6.add(t2n3);
         t2list6.add(t2end);
         t2list6.add(t2n4); //obs
         LinkedList<Node> t2list7 = new LinkedList<Node>();
         t2list7.add(t2n3);
         t2list7.add(t2n4); //obs
         t2list7.add(t2n5);
         t2list7.add(t2n6);
         t2list7.add(t2n8);
         LinkedList<Node> t2list8 = new LinkedList<Node>();
         t2list8.add(t2n5);
         t2list8.add(t2end);
         t2list8.add(t2n4); //obs
         ArrayList<LinkedList<Node>> t2adjList = new ArrayList<LinkedList<Node>>();
         t2adjList.add(t2list0);
         t2adjList.add(t2list1);
         t2adjList.add(t2list2);
         t2adjList.add(t2list3);
         t2adjList.add(t2list4);
         t2adjList.add(t2list5);
         t2adjList.add(t2list6);
         t2adjList.add(t2list7);
         t2adjList.add(t2list8);

         

         
      //test 3 - there are multiple paths to reach the destination each of different lengths
         Node t3start = new Node("Start", 1);
         Node t3end = new Node("End", 7);
         Node t3n0 = new Node("", 0);
         Node t3n2 = new Node("", 2);
         Node t3n3 = new Node("", 3);
         Node t3n4 = new Node("Obs", 4);
         Node t3n5 = new Node("", 5);
         Node t3n6 = new Node("", 6);
         Node t3n8 = new Node("", 8);
   //negative test cases
      //test 1 - there is no path between the source and end point
      //test 2 - 
   
   }

}
