package org.example.mst;
import org.example.graph.*;
import java.util.*;
public class MSTComponentFinder {
    public static List<List<Integer>> findComponents(int n, List<Edge> mst, Edge removed){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(Edge e:mst){
            if(e.u==removed.u && e.v==removed.v && e.weight==removed.weight) continue;
            adj.get(e.u).add(e.v);
            adj.get(e.v).add(e.u);
        }

        boolean[] vis=new boolean[n];
        List<Integer> c1=new ArrayList<>();
        dfs(removed.u,adj,vis,c1);

        List<Integer> c2=new ArrayList<>();
        dfs(removed.v,adj,vis,c2);

        return Arrays.asList(c1,c2);
    }
    private static void dfs(int u,List<List<Integer>> adj,boolean[] vis,List<Integer> comp){
        vis[u]=true;
        comp.add(u);
        for(int nxt:adj.get(u)){
            if(!vis[nxt]) dfs(nxt,adj,vis,comp);
        }
    }
}
