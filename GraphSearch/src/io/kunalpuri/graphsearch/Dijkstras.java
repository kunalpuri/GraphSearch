package io.kunalpuri.graphsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstras {

    public static void performDijsktras(WeightedGraph graph, Node startVertex) {
        
        if (graph.isDirected()) {
            
            
            
        }
        else {
            
            startVertex.setDistance(0);
            
            Set<Node> settledNodes = new HashSet<>();
            Set<Node> unsettledNodes = new HashSet<>();
            
            unsettledNodes.add(startVertex);
            
            while (!unsettledNodes.isEmpty()) {
                
                Node current = getClosestNode(unsettledNodes);
                unsettledNodes.remove(current);
                
                for (Entry < Node, Integer> pair : current.getAdjacentNodes().entrySet()) {
                    
                    Node adjacent = pair.getKey();
                    int weight = pair.getValue();
                    
                    if (!settledNodes.contains(adjacent)) {
                        
                        findMinimumDistance(adjacent, weight, current);
                        unsettledNodes.add(adjacent);
                        
                    }
                    
                }
                
                settledNodes.add(current);
                
            }
            
            Iterator<Node> itr = settledNodes.iterator();
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("[");
            
            while (itr.hasNext()) {
                
                Node curr = itr.next();
                
                sb.append(" " + curr.getName() + "(" + curr.getDistance() + ")" + " ");            
                
                if (itr.hasNext()) {
                    
                    sb.append("->");
                    
                }
                
            }
            
            sb.append("]");
            
            System.out.println("------- DIJSKTRAS TRAVERSAL -------");
            System.out.println(sb.toString());
            System.out.println("-----------------------------------");
            
        }
        
    }
    
    private static void findMinimumDistance(Node adjacent, int weight, Node current) {
        
        int source = current.getDistance();
        
        if (source + weight < adjacent.getDistance()) {
            
            adjacent.setDistance(source + weight);
            LinkedList<Node> shortestPath = new LinkedList<>(current.getShortestPath());
            shortestPath.add(current);
            adjacent.setShortestPath(shortestPath);
            
        }
        
    }

    private static Node getClosestNode(Set<Node> unsettledNodes) {
        
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        
        for (Node node : unsettledNodes) {
            
            int nodeDistance = node.getDistance();
            
            if (nodeDistance < lowestDistance) {
                
                lowestDistanceNode = node;
                lowestDistance = nodeDistance;
                
            }
            
        }
        
        return lowestDistanceNode;
    }

    
}
