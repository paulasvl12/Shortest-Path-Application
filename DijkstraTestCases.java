import java.util.LinkedList;

public class DijkstraTestCases extends Dijkstra1{


    public static void main(String[] args) {
        //positive test case
        Node[][] graph = new Node[][] { { new Node(0, 0, "start"), new Node(2, 1, ""), new Node(2,2, ""), new Node(3, 3, ""), new Node(0, 4, "end") },
                { new Node(2, 5, ""), new Node(0, 6, ""), new Node(3, 7, ""), new Node(2, 8, ""), new Node(0, 9, "") },
                { new Node(2, 10, ""), new Node(3, 11, ""), new Node(0, 12, ""), new Node(2, 13, ""), new Node(0, 14, "")},
                { new Node(3, 15, ""), new Node(2, 16, ""), new Node(2, 17, ""), new Node(0, 18, ""), new Node(3, 19, "") },
                { new Node(0, 20, ""), new Node(0, 21, ""), new Node(0, 22, ""), new Node(3, 23, ""), new Node(0, 24, "") } };
        Node[][] graph2 = new Node[][]{{}};

        //negative test cases

        //no path found

        Graph g = new Graph(graph);
        Dijkstra1 t1 = new Dijkstra1();
        try{
        t1.dijkstra(graph, 0, 7);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Endpoint doesn't exist in this graph");
        }

        // invalid input : not given starting (and ending) point at all
        //Graph g = new Graph(graph2);
        Dijkstra1 t2 = new Dijkstra1();
       try{
            t2.dijkstra(graph2, 1, 2);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid input / Source and end are the same ");
        }
    }
}
