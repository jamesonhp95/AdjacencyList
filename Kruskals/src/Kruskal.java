/*
Author: Jameson Price
This class is a Java implementation of Kruskal's Algorithm, given an AdjacencyList.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Kruskal {
    private ArrayList<Edge> mst = new ArrayList<>();

    /**
     * This class takes an AdjacencyList and creates an Minimum Spanning Tree from it
     * by adding Edges from an AdjacencyList that are sorted by weight. Then, it utilizes
     * the UnionFind class to determine whether adding the edge to the current MST would
     * create a cycle, if not it adds the edge, otherwise it skips the edge. This is continued
     * until we have added edges equal to the number of vertices in the AdjacencyList minus 1,
     * at which point we know we have computed the correct MST.
     * @param G The AdjacencyList that we create the Minimum Spanning Tree from.
     */
    public Kruskal(AdjacencyList G)
    {
        Edge[] edges = G.edges();
        Arrays.sort(edges, Edge.BY_WEIGHT);
        UnionFind uf = new UnionFind(G.getNumVert());
        int index = 0;
        int cnt = 0;
        while(index < G.getNumVert()-1)
        {
            Edge e = edges[cnt];
            int xSet = uf.find(e.v);
            int ySet = uf.find(e.w);

            if(xSet != ySet)
            {
                mst.add(e);
                index++;
                uf.unite(xSet, ySet);
            }
            cnt++;
        }
    }

    /**
     * Prints the MST in memory.
     */
    public void printMST()
    {
        System.out.println("The MST contains the following edges: ");
        for(Edge e : mst)
        {
            System.out.println(e.v + " -> " + e.w);
        }
    }
}
