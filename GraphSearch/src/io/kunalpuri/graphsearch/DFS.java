package io.kunalpuri.graphsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    public static void performDFS(UnweightedGraph graph, int startVertex) {
        
        if (graph.isDirected()) {
            
            
            
        }
        else {
            
            ArrayList<Integer> traversal = new ArrayList<Integer>();
            
            boolean[] visited = new boolean[graph.numVertices() + 1];
            
            Stack<Integer> stack = new Stack<Integer>();
            
            stack.push(startVertex);            
            
            System.out.println("This is working.");
            
            while (!stack.isEmpty()) {
                
                int current = stack.pop();
                                             
                if (!visited[current]) {
                    
                    traversal.add(current);                                       
                    visited[current] = true;  
                    
                    for (int x : graph.getVertexConnections(current)) {
                        
                        stack.push(x);
                        
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
            
            System.out.println("---------- DFS TRAVERSAL ----------");
            System.out.println(sb.toString());
            System.out.println("-----------------------------------");
            
        }
        
    }
    
}
