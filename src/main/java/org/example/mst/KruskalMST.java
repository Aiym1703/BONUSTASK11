package org.example.mst;
import org.example.graph.*;
import org.example.core.*;
import java.util.*;
public class KruskalMST {

    public static List<Edge> build(Graph g){
        List<Edge> mst=new ArrayList<>();
        List<Edge> edges=new ArrayList<>(g.getEdges());
        Collections.sort(edges);
        UnionFind uf=new UnionFind(g.getVertices());

        for(Edge e:edges){
            if(uf.union(e.u,e.v)) mst.add(e);
        }
        return mst;
    }

}
