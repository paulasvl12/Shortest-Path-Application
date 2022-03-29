package com.example.ideaprojects;

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
        list4.add(n3);


        ArrayList<LinkedList<Node>> group = new ArrayList<>();
        group.add(list0);
        group.add(list1);
        group.add(list2);
        group.add(list3);
        group.add(list4);

        Graph g = new Graph(group);
        //g.getAdjList();
        BidirectionalSearch bds = new BidirectionalSearch();
        bds.biDirectionalSearch(start, end, g);

        //g.getAdjList();
        for(int i = 0; i < g.getAdjList().size(); i++)
        {
            System.out.println(" ");
            System.out.print(i + ": ");
            for(int j = 0; j < g.getAdjList().get(i).size(); j++)
                System.out.print(g.getAdjList().get(i).get(j).getID());
        }
        System.out.println();
    }
}