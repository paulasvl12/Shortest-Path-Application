import java.util.LinkedList;
import java.util.ArrayList;
import java.io.IOException;
public class BFSUnitTest{
   public static void main(String[] args) {
   //positive test cases
      //test 1 - example from class there are 5 nodes and only 1 path avaible
        System.out.println("Test 1");
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
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.traversal(start, end, g);
        
      //test 2 - there are multiple paths to reach the destination all of the same length
      System.out.println("Test 2");
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
         t2list0.add(t2start);
         t2list0.add(t2n3);
         t2list0.add(t2n4); //obs
         LinkedList<Node> t2list1 = new LinkedList<Node>();
         t2list1.add(t2n0);
         t2list1.add(t2n2);
         t2list1.add(t2n3);
         t2list1.add(t2n4); //obs
         t2list1.add(t2n5);
         LinkedList<Node> t2list2 = new LinkedList<Node>();
         t2list2.add(t2start);
         t2list2.add(t2n4); //obs
         t2list2.add(t2n5);
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
         t2list6.add(t2n4); //obs
         t2list6.add(t2end);
         LinkedList<Node> t2list7 = new LinkedList<Node>();
         t2list7.add(t2n3);
         t2list7.add(t2n4); //obs
         t2list7.add(t2n5);
         t2list7.add(t2n6);
         t2list7.add(t2n8);
         LinkedList<Node> t2list8 = new LinkedList<Node>();
         t2list8.add(t2n4); //obs
         t2list8.add(t2n5);
         t2list8.add(t2end);
         
         ArrayList<LinkedList<Node>> t2AdjList = new ArrayList<LinkedList<Node>>();
         t2AdjList.add(t2list0);
         t2AdjList.add(t2list1);
         t2AdjList.add(t2list2);
         t2AdjList.add(t2list3);
         t2AdjList.add(t2list4);
         t2AdjList.add(t2list5);
         t2AdjList.add(t2list6);
         t2AdjList.add(t2list7);
         t2AdjList.add(t2list8);
         
         Graph t2g = new Graph(t2AdjList);
        BreadthFirstSearch t2bfs = new BreadthFirstSearch();
        t2bfs.traversal(t2start, t2end, t2g);
         

         
      //test 3 - there are multiple paths to reach the destination each of different lengths
      System.out.println("Test 3");
         Node t3start = new Node("Start", 0);
         Node t3end = new Node("End", 6);
         Node t3n1 = new Node("", 1);
         Node t3n2 = new Node("", 2);
         Node t3n3 = new Node("", 3);
         Node t3n4 = new Node("", 4);
         Node t3n5 = new Node("", 5);
         
         LinkedList<Node> t3list0 = new LinkedList<Node>();
         t3list0.add(t3n1);
         t3list0.add(t3n3);
         t3list0.add(t3n4); 
         LinkedList<Node> t3list1 = new LinkedList<Node>();
         t3list1.add(t3start);
         t3list1.add(t3n2);
         t3list1.add(t3n3);
         t3list1.add(t3n4);
         t3list1.add(t3n5);
         LinkedList<Node> t3list2 = new LinkedList<Node>();
         t3list2.add(t3n1);
         t3list2.add(t3n4);
         t3list2.add(t3n5);
         t3list2.add(t3end);
         LinkedList<Node> t3list3 = new LinkedList<Node>();
         t3list3.add(t3start);
         t3list3.add(t3n1);
         t3list3.add(t3n4);
         LinkedList<Node> t3list4 = new LinkedList<Node>();
         t3list4.add(t3start);
         t3list4.add(t3n1);
         t3list4.add(t3n2);
         t3list4.add(t3n3);
         t3list4.add(t3n5);
         LinkedList<Node> t3list5 = new LinkedList<Node>();
         t3list5.add(t3n1);
         t3list5.add(t3n2);
         t3list5.add(t3n4);
         t3list5.add(t3end);
         LinkedList<Node> t3list6 = new LinkedList<Node>();
         t3list6.add(t3n2);
         t3list6.add(t3n5);
         ArrayList<LinkedList<Node>> t3AdjList = new ArrayList<LinkedList<Node>>();
         t3AdjList.add(t3list0);
         t3AdjList.add(t3list1);
         t3AdjList.add(t3list2);
         t3AdjList.add(t3list3);
         t3AdjList.add(t3list4);
         t3AdjList.add(t3list5);
         t3AdjList.add(t3list6);
         
         
         Graph t3g = new Graph(t3AdjList);
         BreadthFirstSearch t3bfs = new BreadthFirstSearch();
         t3bfs.traversal(t3start, t3end, t3g);
        
         
         //negative test cases
      //test 4 - there is no path between the source and end point (Obs blocking the way)
       System.out.println("Test 4 - No Path to be found");
         Node t4start = new Node("Start", 0);
         Node t4end = new Node("End", 6);
         Node t4n1 = new Node("Obs", 1);
         Node t4n2 = new Node("Obs", 2);
         Node t4n3 = new Node("Obs", 3);
         Node t4n4 = new Node("Obs", 4);
         Node t4n5 = new Node("Obs", 5);
         
         LinkedList<Node> t4list0 = new LinkedList<Node>();
         t4list0.add(t4n1);
         t4list0.add(t4n3);
         t4list0.add(t4n4); 
         LinkedList<Node> t4list1 = new LinkedList<Node>();
         t4list1.add(t4start);
         t4list1.add(t4n2);
         t4list1.add(t4n3);
         t4list1.add(t4n4);
         t4list1.add(t4n5);
         LinkedList<Node> t4list2 = new LinkedList<Node>();
         t4list2.add(t4n1);
         t4list2.add(t4n4);
         t4list2.add(t4n5);
         t4list2.add(t4end);
         LinkedList<Node> t4list3 = new LinkedList<Node>();
         t4list3.add(t4start);
         t4list3.add(t4n1);
         t4list3.add(t4n4);
         LinkedList<Node> t4list4 = new LinkedList<Node>();
         t4list4.add(t4start);
         t4list4.add(t4n1);
         t4list4.add(t4n2);
         t4list4.add(t4n3);
         t4list4.add(t4n5);
         LinkedList<Node> t4list5 = new LinkedList<Node>();
         t4list5.add(t4n1);
         t4list5.add(t4n2);
         t4list5.add(t4n4);
         t4list5.add(t4end);
         LinkedList<Node> t4list6 = new LinkedList<Node>();
         t4list6.add(t4n2);
         t4list6.add(t4n5);
         ArrayList<LinkedList<Node>> t4AdjList = new ArrayList<LinkedList<Node>>();
         t4AdjList.add(t4list0);
         t4AdjList.add(t4list1);
         t4AdjList.add(t4list2);
         t4AdjList.add(t4list3);
         t4AdjList.add(t4list4);
         t4AdjList.add(t4list5);
         t4AdjList.add(t4list6);
         
         
         Graph t4g = new Graph(t4AdjList);
         BreadthFirstSearch t4bfs = new BreadthFirstSearch();
         t4bfs.traversal(t4start, t4end, t4g);

      //test 5 - the graph is empty
       System.out.println("Test 5 - No Path to be found");
         Node t5start = new Node("Start", 0);
         Node t5end = new Node("End", 6);
         ArrayList<LinkedList<Node>> t5AdjList = new ArrayList<LinkedList<Node>>();
         Graph t5g = new Graph(t5AdjList);
         BreadthFirstSearch t5bfs = new BreadthFirstSearch();
         t5bfs.traversal(t5start, t5end, t5g);
   }

}
