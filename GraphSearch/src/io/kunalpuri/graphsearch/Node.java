package io.kunalpuri.graphsearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {

    private String name;
    
    private List<Node> shortestPath = new LinkedList<>();
     
    private Integer distance = Integer.MAX_VALUE;
     
    Map<Node, Integer> adjacentNodes = new HashMap<>();
 
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
  
    public Node(String name) {
        this.name = name;
    }
     
    public String getName() {
        
        return this.name;
        
    }
    
    public void setDistance(int d) {
        
        this.distance = d;
        
    }
    
    public int getDistance() {
        
        return this.distance;
        
    }
    
    public void setShortestPath(List<Node> d) {
        
        this.shortestPath = d;
        
    }
    
    public List<Node> getShortestPath() {
        
        return this.shortestPath;
        
    }
    
    public Map<Node, Integer> getAdjacentNodes() {
        
        return this.adjacentNodes;
        
    }
    
    
    
}