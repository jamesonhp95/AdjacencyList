# Kruskal's Algorithm
This assignment implements Kruskal's Algorithm to calculate and print the correct Minimum Spanning Tree for the given AdjacencyList.
This is completed using a UnionFind class that keeps track of whether adding a specific edge to the MST would create a cycle.
If this would occur, it skips over this edge and continues until we have N edges within our minimum spanning tree where N = (|V|-1) where V is the number of vertices within the AdjacencyList.
