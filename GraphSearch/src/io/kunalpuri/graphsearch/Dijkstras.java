package io.kunalpuri.graphsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Dijkstras {

    public static void performDijsktras(WeightedGraph graph, int startVertex) {
        
        if (graph.isDirected()) {
            
            
            
        }
        else {
            
            int[] distance = new int[graph.numVertices() + 1];
            int[] traversal = new int[graph.numVertices() + 1];
            boolean[] visited = new boolean[graph.numVertices() + 1];
            
            for (int i = 0; i < distance.length; i++) {
                
                distance[i] = Integer.MAX_VALUE;
                
            }
            
            distance[startVertex] = 0;
            
            for (int i = 0; i < distance.length; i++) {
                
                int next = findMinVertex(distance, visited);
                
                visited[next] = true;
                
                LinkedList<Integer[]> values = graph.getVertexConnections(next);
                
                for (int j = 0; j < values.size(); j++) {
                    
                    int v = values.get(j)[1];
                    int d = distance[next] + values.get(j)[0];
                    
                    if (distance[v] > d) {
                        
                        distance[v] = d;
                        traversal[v] = next;
                        
                    }
                    
                }
                
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("[");
            
            for (int i = 0; i < traversal.length; i++) {
                
                sb.append(" " + traversal[i] + " ");
                
                if (i != traversal.length - 1) {
                    
                    sb.append("->");
                    
                }
                
            }
            
            sb.append("]");
            
            System.out.println("------- DIJSKTRAS TRAVERSAL -------");
            System.out.println(sb.toString());
            System.out.println("-----------------------------------");
            
        }
        
    }

    private static int findMinVertex(int[] distance, boolean[] visited) {
        
        int x = Integer.MAX_VALUE;
        int y = -1;
        
        for (int i = 0; i < distance.length; i++) {
            
            if (!visited[i] && distance[i] < x) {
                
                y = i;
                x = distance[i];
                
            }
            
        }
        
        return y;
    }
    
}
