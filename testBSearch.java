import java.util.ArrayList;
import java.util.LinkedList;

public class testBSearch extends Node {

    public static void main(String[] args)
    {
        Node start = new Node("Start", 0);
        Node end = new Node("End", 4);
        Node n = new Node("", 1);
        Node n2 = new Node("", 2);
        Node n3 = new Node("", 3);

        LinkedList<Node> list0 = new LinkedList<>();
        list0.add(n);
        list0.add(n2);
        list0.add(n3);

        LinkedList<Node> list1 = new LinkedList<>();
        list1.add(start);
        list1.add(n2);
        list1.add(n3);

        LinkedList<Node> list2 = new LinkedList<>();
        list2.add(start);
        list2.add(n);
        list2.add(n3);

        LinkedList<Node> list3 = new LinkedList<>();
        list3.add(start);
        list3.add(n);
        list3.add(n2);
        list3.add(end);

        LinkedList<Node> list4 = new LinkedList<>();
        list4.add(end);


        ArrayList<LinkedList<Node>> group = new ArrayList<>();
        group.add(list0);
        group.add(list1);
        group.add(list2);
        group.add(list3);
        group.add(list4);

        Graph g = new Graph(group);

        Node startg2 = new Node("Start", 0);
        Node endg2 = new Node("End", 5);
        Node n1g2 = new Node("", 1);
        Node n2g2 = new Node("", 2);
        Node n3g2 = new Node("", 3);
        Node n4g2 = new Node("", 4);

        LinkedList<Node> list0g2 = new LinkedList<>();
        list0g2.add(n1g2);
        list0g2.add(n2g2);
        list0g2.add(n3g2);

        LinkedList<Node> list1g2 = new LinkedList<>();
        list1g2.add(startg2);

        LinkedList<Node> list2g2 = new LinkedList<>();
        list2g2.add(startg2);
        list2g2.add(n3g2);
        list2g2.add(n4g2);

        LinkedList<Node> list3g2 = new LinkedList<>();
        list3g2.add(startg2);
        list3g2.add(n2g2);
        list3g2.add(n4g2);

        LinkedList<Node> list4g2 = new LinkedList<>();
        list4g2.add(n2g2);
        list4g2.add(n3g2);
        list4g2.add(endg2);

        LinkedList<Node> list5g2 = new LinkedList<>();
        list5g2.add(n4g2);

        ArrayList<LinkedList<Node>> group2 = new ArrayList<>();
        group2.add(list0g2);
        group2.add(list1g2);
        group2.add(list2g2);
        group2.add(list3g2);
        group2.add(list4g2);
        group2.add(list5g2);

        Graph g2 = new Graph(group2);

        ArrayList<LinkedList<Node>> group3 = new ArrayList<>();
        Graph g3 = new Graph(group3);
        //empty graph

        BidirectionalSearch bds = new BidirectionalSearch();
        bds.biDirectionalSearch(start, end, g2);

        System.out.println();

    }
}
