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

    public int getNumVert()
    {
        return numVert;
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

    /**
     * Iterates through and adds all edges within the AdjacencyList to an array to return at the end.
     * @return array of all edges in AdjacencyList.
     */
    public Edge[] edges()
    {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int v = 0; v < numVert; v++){
            for(Edge e : adj.get(v))
            {
                edges.add(e);
            }
        }
        Edge[] retEdges = new Edge[edges.size()];
        for(int i = 0; i < edges.size(); i++)
            retEdges[i] = edges.get(i);
        return retEdges;
    }
}
