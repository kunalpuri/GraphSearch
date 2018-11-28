package io.kunalpuri.graphsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
    
    public static void performBFS(UnweightedGraph graph, int startVertex) {
        
        if (graph.isDirected()) {
            
            ArrayList<Integer> traversal = new ArrayList<Integer>();
            
            boolean[] visited = new boolean[graph.numVertices() + 1];
            
            LinkedList<Integer> queue = new LinkedList<Integer>();
            
            visited[startVertex] = true;
            queue.add(startVertex);
            
            while(!queue.isEmpty()) {
                
                int current = queue.poll();
                traversal.add(current);
                
                for (int x : graph.getVertexConnections(current)) {
                    
                    if (!visited[x]) {
                        
                        visited[x] = true;
                        queue.add(x);
                        
                    }
                    
                }
                
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("[");
            
            for (int i = 0; i < traversal.size(); i++) {
                
                sb.append(" " + traversal.get(i) + " ");
                
                if (i != traversal.size() - 1) {
                    
                    sb.append("->");
                    
                }
                
            }
            
            sb.append("]");
            
            System.out.println("---------- BFS TRAVERSAL ----------");
            System.out.println(sb.toString());
            System.out.println("-----------------------------------");
            
        }
        else {
            
            ArrayList<Integer> traversal = new ArrayList<Integer>();
            
            boolean[] visited = new boolean[graph.numVertices() + 1];
            
            LinkedList<Integer> queue = new LinkedList<Integer>();
            
            visited[startVertex] = true;
            queue.add(startVertex);
            
            while(!queue.isEmpty()) {
                
                int current = queue.poll();
                traversal.add(current);
                
                for (int x : graph.getVertexConnections(current)) {
                    
                    if (!visited[x]) {
                        
                        visited[x] = true;
                        queue.add(x);
                        
                    }
                    
                }
                
            }
            
            StringBuilder sb = new StringBuilder();
            
            sb.append("[");
            
            for (int i = 0; i < traversal.size(); i++) {
                
                sb.append(" " + traversal.get(i) + " ");
                
                if (i != traversal.size() - 1) {
                    
                    sb.append("->");
                    
                }
                
            }
            
            sb.append("]");
            
            System.out.println("---------- BFS TRAVERSAL ----------");
            System.out.println(sb.toString());
            System.out.println("-----------------------------------");
            
        }
        
    }

}
