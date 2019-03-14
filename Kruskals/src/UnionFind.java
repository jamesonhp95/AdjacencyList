/*
Author: Jameson Price
I utilized the article found here, and adjusted some of the code to fit
with my AdjacencyList class instead of their Graph class in order to further
understand this logical idea.
        https://www.geeksforgeeks.org/union-find/
 */
public class UnionFind {
    int[] parent;

    public UnionFind(int n)
    {
        parent = new int[n];
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
    }

    /**
     * Recursively goes through the current numbers in the tree until finding an element whose parent is itself.
     * @param v is the vertex
     * @return is the element whose parent is itself.
     */
    public int find(int v)
    {
        if(parent[v] != v)
            return find(parent[v]);
        return v;
    }

    /**
     * Unites the two sets defined by the indices x and y.
     * @param x is the source vertex
     * @param y is the destination vertex
     */
    public void unite(int x, int y)
    {
        int xSetPar = find(x);
        int ySetPar = find(y);
        parent[ySetPar] = xSetPar;
    }
}
