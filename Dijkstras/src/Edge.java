/*
 * Author: Jameson Price
 * This class holds the source vertex (v) and the destination vertex (w) of an edge constructed in memory.
 * It also holds a variable for the weight of said edge.
 */

public class Edge implements Comparable<Edge>{
    public int v,  w;
    private final int weight;
    public Edge(int v, int w, int weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getWeight()
    {
        return weight;
    }

    public int other(int vertex){
        if (vertex == v)
            return w;
        else
            return v;
    }
    public int compareTo(Edge that)
    {
        if      (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return +1;
        else				      			return  0;
    }

    @Override
    public String toString()
    {
        return " -> " + this.w;
    }

}
