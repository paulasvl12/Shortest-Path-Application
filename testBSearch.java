import java.util.ArrayList;
import java.util.LinkedList;

public class testBSearch extends Node {

    public static void main(String[] args)
    {
        Node start = new Node("Start", 0);
        Node end = new Node("End", 5);
        Node n = new Node("", 1);
        Node n2 = new Node("", 2);
        Node n3 = new Node("", 3);
        Node n4 = new Node("", 4);

        LinkedList<Node> list0 = new LinkedList<>();
        list0.add(n);
        list0.add(n2);
        list0.add(n3);

        LinkedList<Node> list1 = new LinkedList<>();
        list1.add(start);
        //list1.add(n2);
        //list1.add(n3);

        LinkedList<Node> list2 = new LinkedList<>();
        list2.add(start);
        //list2.add(n);
        list2.add(n3);
        list2.add(n4);

        LinkedList<Node> list3 = new LinkedList<>();
        list3.add(start);
        //list3.add(n);
        list3.add(n2);
        list3.add(n4);

        LinkedList<Node> list4 = new LinkedList<>();
        list4.add(n2);
        list4.add(n3);
        list4.add(end);

        LinkedList<Node> list5 = new LinkedList<>();
        list5.add(n4);

        ArrayList<LinkedList<Node>> group = new ArrayList<>();
        group.add(list0);
        group.add(list1);
        group.add(list2);
        group.add(list3);
        group.add(list4);
        group.add(list5);

        Graph g = new Graph(group);

        BidirectionalSearch bds = new BidirectionalSearch();
        bds.biDirectionalSearch(start, end, g);

        System.out.println();

    }
}
