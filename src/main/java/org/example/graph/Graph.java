package org.example.graph;
import java.util.*;
public class Graph {
    private int vertices;
    private List<Edge> edges = new ArrayList<>();

    public Graph(int vertices){
        this.vertices=vertices; }
    public void addEdge(int u,int v,int w){
        edges.add(new Edge(u,v,w)); }

    public int getVertices(){
        return vertices; }

    public List<Edge> getEdges(){
        return edges; }
}
