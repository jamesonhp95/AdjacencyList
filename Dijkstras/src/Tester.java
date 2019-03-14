/*
 * Author: Jameson Price
 * This is the main Tester class that runs the given test example for the homework.
 */

public class Tester {
    public static void main(String args[])
    {
        AdjacencyList myList = new AdjacencyList(8);

        Edge e0 = new Edge(1,2,9);
        Edge e1 = new Edge(1,6,14);
        Edge e2 = new Edge(1,7,15);

        Edge e3 = new Edge(2,3,24);

        Edge e4 = new Edge(3,5,2);
        Edge e5 = new Edge(3,8,19);

        Edge e6 = new Edge(4,3,6);
        Edge e7 = new Edge(4,8,6);

        Edge e8 = new Edge(5,4,11);
        Edge e9 = new Edge(5,8,16);

        Edge e10 = new Edge(6,3,18);
        Edge e11 = new Edge(6,5,30);
        Edge e12 = new Edge(6,7,5);

        Edge e13 = new Edge(7,5,20);
        Edge e14 = new Edge(7,8,44);

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
        myList.addEdge(e14);

        myList.Dijkstra(1);
    }
}
