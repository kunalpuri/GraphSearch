package io.kunalpuri.graphsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

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
        
        if (weighted && directed) {
            
            WeightedGraph graph = new WeightedGraph(directed);
            LinkedList<Node> nodes = new LinkedList<Node>();
            
            while (sc.hasNextLine()) {
                
                Node source = new Node(Integer.toString(sc.nextInt()));
                Node destination = new Node(Integer.toString(sc.nextInt()));
                
                int weight = sc.nextInt();
                
                source.addDestination(destination, weight);
                
                graph.addNode(source);
                graph.addNode(destination);
                
                nodes.add(source);
                nodes.add(destination);
                
            }
            
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("What vertex would you like to begin the searches from?");
            System.out.println("");
            System.out.println("-----------------------------------");
            
            Node toStart = null;
            String startVertex = Integer.toString(vertexChooser.nextInt());
            
            for (Node n : nodes) {
                
                if (n.getName().equals(startVertex)) {
                    
                    toStart = n;
                    
                }
                
            }
            
            Dijkstras.performDijsktras(graph, toStart); 
            
        }
        else if (weighted && !directed) {
            
            WeightedGraph graph = new WeightedGraph(directed);
            LinkedList<Node> nodes = new LinkedList<Node>();
            
            while (sc.hasNextLine()) {
                
                Node source = new Node(Integer.toString(sc.nextInt()));
                Node destination = new Node(Integer.toString(sc.nextInt()));
                
                int weight = sc.nextInt();
                
                source.addDestination(destination, weight);
                destination.addDestination(source, weight);
                
                graph.addNode(source);
                graph.addNode(destination);
                
                nodes.add(source);
                nodes.add(destination);
                
            }
            
            System.out.println("-----------------------------------");
            System.out.println("");
            System.out.println("What vertex would you like to begin the searches from?");
            System.out.println("");
            System.out.println("-----------------------------------");
            
            Node toStart = null;
            String startVertex = Integer.toString(vertexChooser.nextInt());
            
            for (Node n : nodes) {
                
                if (n.getName().equals(startVertex)) {
                    
                    toStart = n;
                    
                }
                
            }
            
            Dijkstras.performDijsktras(graph, toStart);                    
            
        }
        else if (!weighted && directed) {
            
            numVert = sc.nextInt();
            
            System.out.println("--- This graph has " + numVert + " vertices ---");
            
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
            
            numVert = sc.nextInt();
            
            System.out.println("--- This graph has " + numVert + " vertices ---");
            
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
