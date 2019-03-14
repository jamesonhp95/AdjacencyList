/**
 * Author: Jameson Price
 * This is the main Tester class that runs the given test example for the homework.
 */

public class Tester {
    public static void main(String args[])
    {
        AdjacencyList myList = new AdjacencyList(8);
        Edge e0 = new Edge(0, 1, 4);
        Edge e1 = new Edge(0, 2, 6);
        Edge e2 = new Edge(0, 3, 16);

        Edge e3 = new Edge(1, 7, 24);

        Edge e4 = new Edge(2, 7, 23);
        Edge e5 = new Edge(2, 5, 5);
        Edge e6 = new Edge(2, 3, 8);

        Edge e7 = new Edge(3, 5, 10);
        Edge e8 = new Edge(3, 4, 21);

        Edge e9 = new Edge(4, 5, 14);
        Edge e10 = new Edge(4, 6, 7);

        Edge e11 = new Edge(5, 6, 11);
        Edge e12 = new Edge(5, 7, 18);

        Edge e13 = new Edge(6, 7, 9);

        myList.addEdge(e0);
        myList.addEdge(e1);
        myList.addEdge(e2);
        myList.addEdge(e3);
        myList.addEdge(e4);
        myList.addEdge(e5);
        myList.addEdge(e6);
        myList.addEdge(e7);
        myList.addEdge(e8);
        myList.addEdge(e9);
        myList.addEdge(e10);
        myList.addEdge(e11);
        myList.addEdge(e12);
        myList.addEdge(e13);

        myList.BFS(0);

    }
}
