package graphs;
import java.util.*;

/**
 * DFS - Depth First Search
 * traverse all adjacent vertices one by one.
 * there can be more than one DFS Traversals of a Graph
 * 
 * 
 * @author Stuti Pandey
 * @date   2025-03-12
 */
public class Dfs {
    
    // Nested graph class inside DFS
    static class Graph {
        private Map<Integer, List<Integer>> adjList;    // Adjacency list representation
        private boolean isDirected;     // Flag to differentiate between directed & undirected graph

        /**
         * Constructor to initialize the graph type.
         * @param isDirected - If true, the graph is directed; otherwise, it's undirected.
         */
        public Graph(boolean isDirected) {
            this.adjList = new HashMap<>();
            this.isDirected = isDirected;
        }

        /**
         * Adds an edge between two nodes.
         * If the graph is undirected, it adds an edge in both directions.
         */
        public void addEdge(int src, int des) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(des);
            if (!isDirected) {
                adjList.putIfAbsent(des, new ArrayList<>());
                adjList.get(des).add(src);
            }
        }

        /**
         * Performs Depth-First Search (DFS) using recursion.
         * Starts DFS from a given node.
         */
        public void dfsRecursive(int start) {
            Set<Integer> visited = new HashSet<>();
            System.out.println("DFS Recursive Traversal: ");
            dfsHelper(start, visited);
            System.out.println();
        }

        public void dfsHelper(int node, Set<Integer> visited) {
            if (visited.contains(node)) {
                return;
            }
            
            visited.add(node);
            System.out.print(node + " ");
            
            for(int neighbour : adjList.getOrDefault(node, new ArrayList<>())) {
                dfsHelper(neighbour, visited);
            }
        }

        /**
         * Performs Depth-First Search (DFS) using an iterative approach (Stack).
         */
        public void dfsIterative(int start) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> visited = new HashSet<>();

            stack.push(start);

            System.out.println("DFS Iterative Traversal:");

            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!visited.contains(node)) {
                    visited.add(node);
                    System.out.print(node + " ");
                    
                    // Push all unvisited neighbors onto the stack (reverse order for correct output)
                    List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
                    Collections.reverse(neighbors); // Optional: Maintain order similar to recursion
                    for (int neighbor: neighbors) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }

                }
            }
            System.out.println();
        }

            /**
         * Prints the adjacency list of the graph.
         */
        public void printGraph() {
            System.out.println("Graph Representation (Adjacency List):");
            for (int node : adjList.keySet()) {
                System.out.println(node + " -> " + adjList.get(node));
            }
        }

    }

    // main method inside dfs class
    public static void main(String[] args) {
        Graph graph = new Graph(true);     // false -> undirected, true -> directed
        graph.addEdge(0,1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.printGraph();

        System.out.println("\nDFS Starting from Node 0:\n");
        graph.dfsRecursive(0);

        graph.dfsIterative(0);

    }
}

/**
 * How This Works
    ✅ The Graph constructor takes isDirected as a parameter to determine the graph type.
    ✅ addEdge() method adds edges in both directions for an undirected graph and only one direction for a directed graph.
    ✅ DFS Recursive (dfsRecursive) - Uses a helper method to traverse recursively.
    ✅ DFS Iterative (dfsIterative) - Uses a stack (LIFO) for traversal.
 */

 /*
  * isDirected -> false
  Graph Representation (Adjacency List):
    0 -> [1, 2]
    1 -> [0, 3, 4]
    2 -> [0, 5]
    3 -> [1, 6]
    4 -> [1, 6]
    5 -> [2, 6]
    6 -> [3, 4, 5]

    DFS Recursive Traversal: 0 1 3 6 4 5 2
    DFS Iterative Traversal: 0 1 3 6 4 5 2


        0
        / \
        1   2
        / \   \
        3   4   5
        \ /     \
        6 ----- 6

        isDirected -> true

        0 → 1 → 3 → 6
        |    ↓  
        ↓    4 → 6
        2 → 5 → 6

        Graph Representation (Adjacency List):
            0 -> [1, 2]
            1 -> [3, 4]
            2 -> [5]
            3 -> [6]
            4 -> [6]
            5 -> [6]

        DFS Recursive Traversal: 0 1 3 6 4 5 2
        DFS Iterative Traversal: 0 1 3 6 4 5 2
    */