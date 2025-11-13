package org.example.mst;
import org.example.graph.*;
import java.util.*;
public class MSTReconnector {
    public static Edge findReplacement(Graph g, List<Integer> c1, List<Integer> c2, Edge removed){
        Edge best=null;
        for(Edge e:g.getEdges()){
            if(e.u==removed.u && e.v==removed.v && e.weight==removed.weight) continue;
            boolean in1_u = c1.contains(e.u);
            boolean in1_v = c1.contains(e.v);
            if(in1_u == in1_v) continue;
            if(best==null || e.weight<best.weight) best=e;
        }
        return best;
    }
    public static int totalWeight(List<Edge> mst){
        return mst.stream().mapToInt(e->e.weight).sum();
    }
}
