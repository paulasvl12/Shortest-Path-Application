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

        // add end node to queue and set it as visited
        e_queue.add(e);

            // run BFS from s -> e and from e -> s
            Adj = g.getAdjList();

            ArrayList<Node> SList = BFS(s_queue, s, e);
            // set all adjacent nodes to unvisited
            for(int i = 0; i < Adj.size(); i++)
            {
                for(int j = 0; j < Adj.get(i).size(); j++)
                Adj.get(i).get(j).setVisited(false);
            }
            ArrayList<Node> EList = BFS(e_queue, e, s);

            s.setVisited(true);
            e.setVisited(true);

            if(EList == null || SList == null)
            {
                // null - cannot find path
            }
            else {
                int j = EList.size() / 2;
                intersectNode = EList.get(j);
                System.out.println("Intersect Node: " + intersectNode.getID());
            }

            System.out.print("");
            if(SList != null){
               this.print(SList, EList, intersectNode);
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
        // return the path
        return list;
    }

    public void print(ArrayList<Node> a, ArrayList<Node> b, Node intersectNode)
    {
        for(int i = 0; i < a.size(); i++)
        {
            if(a.get(i).getID() == intersectNode.getID() || b.get(i).getID() == intersectNode.getID())
            {
                System.out.print(a.get(i).getID());
                if(b.size() %2 == 0)
                {
                    System.out.print(b.get(i).getID());
                }
                break;
            }
            System.out.print(a.get(i).getID());
            System.out.print(b.get(i).getID());
        }
    }

    public static void main(String[] args)
    {

    }
}
