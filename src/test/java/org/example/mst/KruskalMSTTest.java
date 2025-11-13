package org.example.mst;
import org.example.graph.*;
import org.example.mst.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class KruskalMSTTest {
    @Test
    void testMSTSize(){
        Graph g=new Graph(4);
        g.addEdge(0,1,3);
        g.addEdge(1,2,4);
        g.addEdge(2,3,1);
        g.addEdge(3,0,2);
        List<Edge> mst=KruskalMST.build(g);
        assertEquals(3,mst.size());
    }
    @Test
    void testNoCycles() {
        Graph g = new Graph(5);
        g.addEdge(0,1,10);
        g.addEdge(1,2,5);
        g.addEdge(2,3,7);
        g.addEdge(3,4,1);
        g.addEdge(4,0,2);
        List<Edge> mst = KruskalMST.build(g);
        assertEquals(4, mst.size());
    }
    @Test
    void testDeterministicMST() {
        Graph g = new Graph(5);
        g.addEdge(0,1,3);
        g.addEdge(1,2,1);
        g.addEdge(2,3,4);
        g.addEdge(3,4,2);
        g.addEdge(0,4,6);
        List<Edge> mst1 = KruskalMST.build(g);
        List<Edge> mst2 = KruskalMST.build(g);
        assertEquals(mst1.toString(), mst2.toString());
    }
    @Test
    void testRemovedEdgeNotUsed() {
        Graph g = new Graph(4);
        g.addEdge(0,1,1);
        g.addEdge(1,2,2);
        g.addEdge(2,3,3);
        g.addEdge(0,3,100);
        List<Edge> mst = KruskalMST.build(g);
        Edge removed = mst.get(0);
        List<List<Integer>> comps = MSTComponentFinder.findComponents(4, mst, removed);
        Edge rep = MSTReconnector.findReplacement(g, comps.get(0), comps.get(1), removed);
        assertNotNull(rep, "Replacement edge must exist");
        assertFalse(rep.equals(removed), "Replacement edge must not be the removed edge");
        assertTrue(
                comps.get(0).contains(rep.u) && comps.get(1).contains(rep.v) ||
                        comps.get(1).contains(rep.u) && comps.get(0).contains(rep.v),
                "Replacement edge must connect the two components"
        );
    }

    @Test
    void testMSTCorrectness() {
        Graph g = new Graph(8);
        g.addEdge(3,2,2);
        g.addEdge(5,6,3);
        g.addEdge(3,4,4);
        g.addEdge(1,3,5);
        g.addEdge(0,1,6);
        g.addEdge(4,5,7);
        g.addEdge(6,7,8);
        g.addEdge(2,4,6);
        g.addEdge(1,2,10);
        List<Edge> mst = KruskalMST.build(g);
        assertEquals(7, mst.size(), "MST must contain V-1 edges");
        int total = MSTReconnector.totalWeight(mst);
        assertEquals(35, total, "Incorrect total weight for MST");
    }

    @Test
    void testComponentsAfterRemoval() {
        Graph g = new Graph(8);
        g.addEdge(3,2,2);
        g.addEdge(5,6,3);
        g.addEdge(3,4,4);
        g.addEdge(1,3,5);
        g.addEdge(0,1,6);
        g.addEdge(4,5,7);
        g.addEdge(6,7,8);
        g.addEdge(2,4,6);
        List<Edge> mst = KruskalMST.build(g);
        Edge removed = mst.get(0);
        List<List<Integer>> comps = MSTComponentFinder.findComponents(8, mst, removed);
        assertEquals(2, comps.size(), "Graph must split into 2 components");
        assertTrue(comps.stream().anyMatch(c -> c.size() == 1 && c.contains(2)),
                "One component must contain only vertex 2");
        assertTrue(comps.stream().anyMatch(c -> c.size() == 7),
                "Other component must contain the remaining 7 vertices");
    }

}

