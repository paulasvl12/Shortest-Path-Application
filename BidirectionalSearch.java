<<<<<<< Updated upstream
package com.example.ideaprojects;

import java.util.ArrayList;
import java.util.LinkedList;


public class BidirectionalSearch extends Node {

    // initialize adjacency list
    ArrayList<LinkedList<Node>> Adj;

    public void biDirectionalSearch(Node s, Node e, Graph g) {
        // create queues for start and end
        ArrayList<Node> s_queue = new ArrayList<>();
        ArrayList<Node> e_queue = new ArrayList<>();

        //set intersectNode to null, currently has no value
        Node intersectNode = null;

        // add start node to queue and set it as visited
        s_queue.add(s);
        s.setVisited(true);

        // add end node to queue and set it as visited
        e_queue.add(e);
        e.setVisited(true);

        while (!s_queue.isEmpty() && !e_queue.isEmpty() && intersectNode == null) {
            // run BFS from s -> e and from e -> s
            Adj = g.getAdjList();

            ArrayList<Node> SList = BFS(s_queue, s, e);
            for(int i = 0; i < Adj.size(); i++)
            {
                for(int j = 0; j < Adj.get(i).size(); j++)
                Adj.get(i).get(j).setVisited(false);
            }
            ArrayList<Node> EList = BFS(e_queue, e, s);

            if(EList == null || SList == null)
            {
                // null - cannot find path
            }
            else {

                int i = 0;
                int j = EList.size() - 1;
                while (i < SList.size()) {
                    if (SList.get(i).getID() == EList.get(j).getID()) {
                        intersectNode = SList.get(i);
                        System.out.println("Intersect Node: " + intersectNode.getID());
                        break;
                    }
                    i++;
                    if (SList.get(i).getID() == EList.get(j).getID()) {
                        intersectNode = SList.get(i);
                        System.out.println("Intersect Node: " + intersectNode.getID());
                        break;
                    }
                    j--;
                    if (SList.get(i).getID() == EList.get(j).getID()) {
                        intersectNode = SList.get(i);
                        System.out.println("Intersect Node: " + intersectNode.getID());
                        break;
                    }
                }
            }
        }
    }


    //building and arraylist
    public ArrayList<Node> BFS(ArrayList<Node> queue, Node s, Node e) {
        boolean endFound = false;
        ArrayList<Node> list = new ArrayList<>();
        Node current = null;
        LinkedList<Node> neighbors = null;
        while(!queue.isEmpty()){
            try {
                current = queue.remove(0);
                list.add(current);
                neighbors = Adj.get(current.getID());
                for (int i = 0; i < neighbors.size(); i++) {

                    if (!neighbors.get(i).getVisited() && !neighbors.get(i).getState().equals("Obs")) {
                        // if neighbors are an obstacle or haven't been visited, add them to the queue and set them to visited
                        // set a new current node
                        queue.add(neighbors.get(i));
                        neighbors.get(i).setPrev(current);
                        neighbors.get(i).setVisited(true);


                        if (neighbors.get(i).getID() == (e.getID())) {
                            queue.clear();
                            endFound = true;
                            break;
                        }
                    }
                }
            }
            catch(IndexOutOfBoundsException E){
                System.out.println("Exception caught: Node ID is negative");
            }
        }
        //if the queue never reaches the end node, no path exists
        if(!endFound)
        {
            System.out.println("No path exists between the selected start and end points");
            return null;

        }
        else{
            Node finalNode = e;
            list.add(e);
            // find the node before the end node and continue cycling back until the start node
            while(finalNode != null && !finalNode.getState().equals(s.getState())){
                if(!finalNode.getState().equals(e.getState())){
                    list.add(finalNode);
                }
                finalNode = finalNode.getPrev();
            }
            list.add(s);
        }

        // return the path
        return list;
    }

    public static void main(String[] args)
    {

    }
=======
import java.util.ArrayList;
import java.util.LinkedList;


public class BidirectionalSearch extends Node {

    // initialize adjacency list
    ArrayList<LinkedList<Node>> Adj;

    public void biDirectionalSearch(Node s, Node e, Graph g) {
        // create queues for start and end
        ArrayList<Node> s_queue = new ArrayList<>();
        ArrayList<Node> e_queue = new ArrayList<>();

        //set intersectNode to null, currently has no value
        Node intersectNode = null;

        // add start node to queue and set it as visited
        s_queue.add(s);
        s.setVisited(true);

        // add end node to queue and set it as visited
        e_queue.add(e);
        e.setVisited(true);

        while (!s_queue.isEmpty() && !e_queue.isEmpty() && intersectNode == null) {
            // run BFS from s -> e and from e -> s
            Adj = g.getAdjList();

            ArrayList<Node> SList = BFS(s_queue, s, e);
            for(int i = 0; i < Adj.size(); i++)
            {
                for(int j = 0; j < Adj.get(i).size(); j++)
                    Adj.get(i).get(j).setVisited(false);
            }
            ArrayList<Node> EList = BFS(e_queue, e, s);

            if(EList == null || SList == null)
            {
                // null - cannot find path
            }
            else {

                int i = 0;
                int j = EList.size() - 1;
                while (i < SList.size()) {
                    if (SList.get(i).getID() == EList.get(j).getID()) {
                        intersectNode = SList.get(i);
                        System.out.println("Intersect Node: " + intersectNode.getID());
                        break;
                    }
                    i++;
                    if (SList.get(i).getID() == EList.get(j).getID()) {
                        intersectNode = SList.get(i);
                        System.out.println("Intersect Node: " + intersectNode.getID());
                        break;
                    }
                    j--;
                    if (SList.get(i).getID() == EList.get(j).getID()) {
                        intersectNode = SList.get(i);
                        System.out.println("Intersect Node: " + intersectNode.getID());
                        break;
                    }
                }
            }
        }
    }


    //building and arraylist
    public ArrayList<Node> BFS(ArrayList<Node> queue, Node s, Node e) {
        boolean endFound = false;
        ArrayList<Node> list = new ArrayList<>();
        Node current = null;
        LinkedList<Node> neighbors = null;
        while(!queue.isEmpty()){
            try {
                current = queue.remove(0);
                //list.add(current);
                neighbors = Adj.get(current.getID());
                for (int i = 0; i < neighbors.size(); i++) {

                    if (!neighbors.get(i).getVisited() && !neighbors.get(i).getState().equals("Obs")) {
                        // if neighbors are an obstacle or haven't been visited, add them to the queue and set them to visited
                        // set a new current node
                        queue.add(neighbors.get(i));
                        neighbors.get(i).setPrev(current);
                        neighbors.get(i).setVisited(true);


                        if (neighbors.get(i).getID() == (e.getID())) {
                            queue.clear();
                            endFound = true;
                            break;
                        }
                    }
                }
            }
            catch(IndexOutOfBoundsException E){
                System.out.println("Exception caught: Node ID is out of bounds");
            }
        }
        //if the queue never reaches the end node, no path exists
        if(!endFound)
        {
            System.out.println("No path exists between the selected start and end points");
            return null;

        }
        else{
            Node finalNode = e;
            list.add(e);
            finalNode = finalNode.getPrev();
            // find the node before the end node and continue cycling back until the start node
            while(finalNode != null && !finalNode.getState().equals(s.getState())){
                if(!finalNode.getState().equals(e.getState())){
                    list.add(finalNode);
                }
                finalNode = finalNode.getPrev();
            }
            list.add(s);
        }
        for(int x = 0; x < list.size(); x++){
            System.out.print(list.get(x).getID());
        }
        System.out.println();
        // return the path
        return list;
    }

    public static void main(String[] args)
    {

    }
>>>>>>> Stashed changes
}