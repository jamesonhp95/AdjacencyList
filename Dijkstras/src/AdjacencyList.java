/*
 * Author: Jameson Price
 * This is a class that builds the adjacency list based off of edges that are added from the tester.
 * The class has a boolean array to keep track of which vertices have been visited, and an ArrayList of ArrayLists of edges
 * That correspond to the edges connected with the vertex i.
 * So adj[i] contains all the edges that correspond with the vertex i and isVisited[i] symbolizes if vertex i has been visited.
 */

import java.util.*;

public class AdjacencyList {

    private int numVert;
    private ArrayList<ArrayList<Edge>> adj;
    public AdjacencyList(int V)
    {
        this.numVert = V;
        adj = new ArrayList<>();
        for (int v = 0; v < V; v++)
            adj.add(new ArrayList<>());
    }

    /**
     * The node class is a private inner class used during Dijkstra's algorithm to assist in bundling the data
     * needed for properly storing final distances to individual vertices as well as the index they are located
     * in within the local array in the Dijkstra's method. Additionally, the String 'path' is a traceback to
     * show the route taken to get to the individual vertex. Since these Nodes are stored in a PriorityQueue,
     * I have also implemented Comparable.
     */
    private static class Node implements Comparable
    {
        int vertex;
        int distance;
        int index;
        String path;

        @Override
        public int compareTo(Object o) {
            if(o instanceof Node)
            {
                if(((Node) o).distance > distance)
                    return -1;
                else if(((Node) o).distance < distance)
                    return 1;
                else
                    return 0;
            }
            else
                return -1;
        }
    }

    /**
     * This method grabs a list of all of the unique vertices within the adjacency list
     * and returns them as a sorted ArrayList for Node construction.
     * @return Sorted ArrayList of all unique vertices.
     */
    private ArrayList<Integer> getVertices()
    {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int v = 0; v < numVert; v++){
            for (Edge e : adj.get(v))
            {
                int w = e.other(v);
                if(!ret.contains(w))
                    ret.add(w);
            }
        }
        Collections.sort(ret);
        return ret;
    }

    /**
     * This method first constructs three ArrayLists in memory for utility during computation of the shortest paths.
     * nodeArr is the list of Nodes in the current adjacencyList, allowing for one node per vertex.
     * Q is the Priority Queue that initially contains the set of all vertices.
     * uniqueVerts is a list constructed from the getVertices() method that contains all unique vertices in the AdjacencyList
     * After these ArrayLists are constructed, we go through the Priority Queue until it is empty and remove the minimum Node within
     * the queue. Then we get the source index for that node and iterate through all adjacent edges associated with that vertex.
     * For each adjacent vertex, if the new weight of that edge would be smaller than other choices among the adjacent edges,
     * we replace the distance variable associated with the Node representing the destination vertex with the new key until
     * the smallest distance is found within the set of adjacent edges.
     * After the queue is empty, we know that each vertex has stored the minimum distance, and the path associated with its route,
     * to move from the source vertex to the individual vertex. So we iterate through our nodeArr and print the stored data of each in
     * a readable format for the user.
     * @param src is the source vertex that we will be starting from and computing paths to other vertices.
     */
    public void Dijkstra(int src)
    {
        ArrayList<Node> nodeArr = new ArrayList<>();
        PriorityQueue<Node> Q = new PriorityQueue<>();
        ArrayList<Integer> uniqueVerts = getVertices();
        for(int x = 0; x < uniqueVerts.size(); x++)
        {
            Node n = new Node();
            n.vertex = uniqueVerts.get(x);
            if(uniqueVerts.get(x) == src)
            {
                n.distance = 0;
                n.path = "1";
            }
            else if(uniqueVerts.size()-x == 1)
                n.distance = Integer.MAX_VALUE;
            else
                n.distance = Integer.MAX_VALUE -1;
            n.index = x;
            Q.add(n);
            nodeArr.add(n);
        }

        while (!Q.isEmpty())
        {
            Node n = Q.remove();
            int srcIndex = n.index;
            for(Edge e : adj.get(srcIndex))
            {
                int destIndex = uniqueVerts.indexOf(e.w);
                int nKey = nodeArr.get(srcIndex).distance + e.getWeight();
                int cKey = nodeArr.get(destIndex).distance;
                if(cKey > nKey)
                {
                    nodeArr.get(destIndex).distance = nKey;
                    nodeArr.get(destIndex).path = nodeArr.get(srcIndex).path + e.toString();
                }
            }
        }
        nodeArr.get(uniqueVerts.indexOf(src)).path += " -> " + src;
        System.out.println("I have implemented a Priority Queue to return and remove the smallest object.\nResults: ");
        for(int x = 0; x < nodeArr.size(); x++)
        {
            int pathNum = x+1;
            System.out.println("Path " + pathNum + ") " + "vertex: " + src + " to vertex " + nodeArr.get(x).vertex + ", " + nodeArr.get(x).path + ", length: " + nodeArr.get(x).distance);
        }
    }

    /**
     * This method puts the edge into the right spot for adj.
     */
    public void addEdge(Edge e){
        int v = e.v,  w = e.w;
        adj.get(v-1).add(e);
        adj.get(w-1).add(e);
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
