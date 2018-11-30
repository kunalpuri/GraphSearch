package io.kunalpuri.graphsearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class WeightedGraph {

    private boolean directed;
    private Set<Node> nodes = new HashSet<>();
    
    public boolean isDirected() {
        
        return this.directed;
        
    }

    public WeightedGraph(boolean directed) {
        
        this.directed = directed;       
        
    }      
    
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
    
    public Set<Node> getNodes() {
        
        return this.nodes;
        
    }
    
    
}
