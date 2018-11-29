package io.kunalpuri.graphsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    private static boolean weighted = false;
    private static boolean directed = false;
    
    private static int numVert = 0;

    public static void main(String[] args) {   
        
        Scanner sc = new Scanner(System.in);
        Scanner vertexChooser = new Scanner(System.in);
        
        System.out.println("Enter the file name with extension: ");
        
        File file = new File(sc.nextLine());
        
        try {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e) {            
            e.printStackTrace();
        }
        
        if (sc.nextLine().equals("Y")) {
            
            System.out.println("--- This graph is WEIGHTED ---");
            weighted = true;
            
        }
        else {
            
            System.out.println("--- This graph is NOT WEIGHTED ---");
            
        }
        
        
        if (sc.nextLine().equals("Y")) {
            
            System.out.println("--- This graph is DIRECTED ---");
            directed = true;
            
        }
        else {
            
            System.out.println("--- This graph is NOT DIRECTED ---");
            
        }
        
        numVert = sc.nextInt();
        
        System.out.println("--- This graph has " + numVert + " vertices ---");
        
        if (weighted && directed) {
            
            
            
        }
        else if (weighted && !directed) {
            
            WeightedGraph graph = new WeightedGraph(numVert, directed);
            
            while (sc.hasNextLine()) {
                
                graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
                
            }
            
            graph.printGraph();
            
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("What vertex would you like to begin the searches from?");
            System.out.println("");
            System.out.println("-----------------------------------");
            
            int startVertex = vertexChooser.nextInt();
            
            Dijkstras.performDijsktras(graph, startVertex);                    
            
        }
        else if (!weighted && directed) {
            
            System.out.println("Input a pair of integer vertices: ");
            System.out.println("Ex: 3 5 ... creates an edge between 3 and 5");
            
            UnweightedGraph graph = new UnweightedGraph(numVert, directed);
            
            while (sc.hasNextLine()) {
                
                graph.addEdge(sc.nextInt(), sc.nextInt());
                
            }
            
            graph.printGraph();
            
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("What vertex would you like to begin the searches from?");
            System.out.println("");
            System.out.println("-----------------------------------");
            
            int startVertex = vertexChooser.nextInt();
            
            BFS.performBFS(graph, startVertex);
            DFS.performDFS(graph, startVertex);
            
        }
        else {
            
            System.out.println("Input a pair of integer vertices: ");
            System.out.println("Ex: 3 5 ... creates an edge between 3 and 5");
            
            UnweightedGraph graph = new UnweightedGraph(numVert, directed);
            
            while (sc.hasNextLine()) {
                
                graph.addEdge(sc.nextInt(), sc.nextInt());
                
            }
                    
            graph.printGraph();
            
            System.out.println("----------------------------------------------------------------------");
            System.out.println("");
            System.out.println("What vertex would you like to begin the searches from?");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------");
            
            int startVertex = vertexChooser.nextInt();
            
            BFS.performBFS(graph, startVertex);
            DFS.performDFS(graph, startVertex);
            
            System.out.println("----------------------------------------------------------------------");
            System.out.println("");
            System.out.println("Dijsktras and Prims cannot be run on an undirected, unweighted graph.");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------");
            
        }
        
        vertexChooser.close();
        sc.close();
        
    }
    
}
