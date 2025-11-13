package org.example.app;
import org.example.graph.*;
import org.example.mst.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.addEdge(0,1,6);
        g.addEdge(1,3,5);
        g.addEdge(3,4,4);
        g.addEdge(4,5,7);
        g.addEdge(5,6,3);
        g.addEdge(6,7,8);
        g.addEdge(3,2,2);

        g.addEdge(2,4,6);
        g.addEdge(2,5,9);
        g.addEdge(2,7,11);

        g.addEdge(0,3,10);
        g.addEdge(1,4,12);
        g.addEdge(5,7,13);
        g.addEdge(1,2,14);

        List<Edge> mst = KruskalMST.build(g);
        System.out.println("Original MST:");
        mst.forEach(System.out::println);
        System.out.println("Total weight: " + MSTReconnector.totalWeight(mst));
        Edge removed = null;
        for (Edge e : mst) {
            if ((e.u == 3 && e.v == 2) || (e.u == 2 && e.v == 3)) {
                removed = e;
                break;}}
        System.out.println("\nRemoving edge from MST: " + removed);
        List<List<Integer>> comps =
                MSTComponentFinder.findComponents(g.getVertices(), mst, removed);
        System.out.println("\nComponents after removing the edge:");
        System.out.println("Component 1: " + comps.get(0));
        System.out.println("Component 2: " + comps.get(1));

        Edge replacement =
                MSTReconnector.findReplacement(g, comps.get(0), comps.get(1), removed);
        System.out.println("\nReplacement edge selected: " + replacement);
        mst.remove(removed);
        mst.add(replacement);
        System.out.println("\nUpdated MST after reconnection:");
        mst.forEach(System.out::println);
        System.out.println("Total weight: " + MSTReconnector.totalWeight(mst));
    }
}
