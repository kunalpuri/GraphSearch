package io.kunalpuri.graphsearch;

import java.util.LinkedList;

public class Graph {
    
    private boolean weighted;
    private boolean directed;
    private int vertices;
    private LinkedList<Integer> adjacencyList[];
    
    public boolean isWeighted() {
        
        return this.weighted;
        
    }
    
    public boolean isDirected() {
        
        return this.directed;
        
    }
    
    public int numVertices() {
        
        return this.vertices;
        
    }
    
    public LinkedList<Integer> getVertexConnections(int x) {
        
        return adjacencyList[x];
        
    }

    public Graph(int vertices, boolean weighted, boolean directed) {
        
        this.weighted = weighted;
        this.directed = directed;
        
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices + 1];
        
        for (int i = 0; i < adjacencyList.length; i++) {
            
            adjacencyList[i] = new LinkedList<Integer>();
            
        }
        
    }
    
    public void addEdge(int start, int end) {
        
        if (weighted && directed) {
            
            
            
        }
        else if (weighted && !directed) {
            
            
            
        }
        else if (!weighted && directed) {
            
            adjacencyList[start].add(end);
            
        }
        else {
            
            adjacencyList[start].add(end);
            adjacencyList[end].add(start);
            
        }
        
    }
    
    public void printGraph() {
        
        for (int i = 0; i < this.vertices; i++) {
            
            System.out.println("Adjacency List of Vertex: " + i);
            System.out.println("Head: ");
            
            for (int x : this.adjacencyList[i]) {
                
                System.out.print(" -> " + x);
                
            }
            
            System.out.println("\n");
            
        }
        
    }
    
    
    
}
