/**
 * Author: Jameson Price
 * This is a class that builds the adjacency list based off of edges that are added from the tester.
 * The class has a boolean array to keep track of which vertices have been visited, and an ArrayList of ArrayLists of edges
 * That correspond to the edges connected with the vertex i.
 * So adj[i] contains all the edges that correspond with the vertex i and isVisited[i] symbolizes if vertex i has been visited.
 */

import java.util.*;

public class AdjacencyList {

    private int numVert;
    private boolean[] isVisited;
    private ArrayList<ArrayList<Edge>> adj;
    public AdjacencyList(int V)
    {
        this.numVert = V;
        adj = new ArrayList();
        isVisited = new boolean[V];
        for (int v = 0; v < V; v++)
            adj.add(new ArrayList<>());
        for(int x = 0; x < V; x++)
            isVisited[x] = false;
    }

    /**
     * This method puts the edge into the right spot for adj.
     */
    public void addEdge(Edge e){
        int v = e.v,  w = e.w;
        adj.get(v).add(e);
        adj.get(w).add(e);
    }

    /**
     * This method prints the BFS traversal of the current adjacencyList in memory by using a LinkedList as a queue
     * Then I instantiate a new ArrayList to hold the values in the order they should be printed.
     * While the LinkedList isn't empty, we check the edges adjacent to the last vertex we visited and if that vertex
     * has not been visited, we add that vertex into our list to print.
     * @param start is the vertex where we will begin our BFS traversal.
     */
    public void BFS(int start)
    {
        LinkedList q = new LinkedList();
        ArrayList<Integer> toPrint = new ArrayList();
        int x;
        q.addFirst(start);
        isVisited[start] = true;
        while(!q.isEmpty())
        {
            int v = (Integer)q.removeLast();
            toPrint.add(v);
            for(Edge e : adj.get(v))
            {
                int w = e.other(v);
                if(!isVisited[w])
                {
                    isVisited[w] = true;
                    q.addFirst(w);
                }
            }
        }
        System.out.println("The result of the BFS traversal starting from vertex " + start + " is:");
        for(x = 0; x < toPrint.size()-1; x++)
            System.out.print(toPrint.get(x) + " -> ");
        System.out.println(toPrint.get(x));
    }

    /**
     * This is a simple method I used to check if the graph was correct in memory.
     */
    public void printGraph()
    {
        for (int v = 0; v < numVert; v++){
            System.out.println();
            for (Edge e : adj.get(v))
            {
                int w = e.other(v);
                System.out.print(w + " ");
            }
        }
    }
}
