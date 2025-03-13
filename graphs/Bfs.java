package graphs;
import java.util.*;

/**
 * BFS - Breadth First Search
 * begins with a node, then first traverses all its adjacent nodes. 
 * Once all adjacent are visited, then their adjacent are traversed. .
 * 
 * The `Graph` class is defined inside the `Bfs` class, and the type of graph is controlled using
 * a boolean flag (`isDirected`).
 * 
 * Time Complexity:
 * O(V + E)
 *  O(V): Each vertex is added to the queue once.
    O(E): Each edge is explored once (in adjacency list).

 * Space Complexity:
 *  Queue -> O(V)
 *  Visited Set -> O(V)
 *  Adjacency List -> O(V + E)
 * 
 * @author Stuti Pandey
 * @date   2025-03-13
 */

public class Bfs {
    /**
     * The graph class represents a graph using an adjacency list.
     * It supports both directed and undirected graphs based on the `isDirected` flag.
     */
    static class Graph {
        private Map<Integer, List<Integer>> adjList; // Adjacency List representation
        private boolean isDirected; // Flag for directed or undirected graph

        /**
         * Constructor to initialize the graph type.
         * @param isDirected - If true, the graph is directed, otherwise, it's undirected
         */
        public Graph(boolean isDirected) {
            this.adjList = new HashMap<>();
            this.isDirected = isDirected;
        }

        /**
         * This method adds an edge between two nodes
         * If the graph is undirected, it adds an edge in both directions
         */
        public void addEdge(int src, int dest) {
            adjList.putIfAbsent(src, new ArrayList<>());
            adjList.get(src).add(dest);

            if (!isDirected) {
                adjList.putIfAbsent(dest, new ArrayList<>());
                adjList.get(dest).add(src); // add reverse edge for undirected graphs
            }
        }

        /**
         * This method performs Breadth-First Search (BFS) starting from the given node.
         * Uses a queue to explore nodes level by level
         */
        public void bfs(int start) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            queue.offer(start);
            visited.add(start);

            System.out.println("BFS Traversal: ");

            while(!queue.isEmpty()) {
                int node = queue.poll();
                System.out.println(node + " ");

                for(int neighbor: adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            System.out.println();
        }
        /**
         * Prints the adjacency list represntation of the graph
         */
        public void printGraph() {
            System.out.println("Graph Representation (Adjacency List):");
            for (int node : adjList.keySet()) {
                System.out.println(node + " -> " + adjList.get(node));
            }
        }
    }

    /**
     * Main method to test BFS with both directed and undirected graphs.
     */
    public static void main(String[] args) {

        boolean isDirectedGraph = true;    // Set true for a directed graph, false for undirected
        Graph graph = new Graph(isDirectedGraph); 

        graph.addEdge(0,1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.printGraph();

        // Perform BFS Traversal
        System.out.println("\nStarting BFS from node 0:");
        graph.bfs(1);
    }
}

/**
 * start node -> 0
 * isDirected => false
 *  Graph Representation (Adjacency List):
        0 -> [1, 2]
        1 -> [0, 3, 4]
        2 -> [0, 5]
        3 -> [1, 6]
        4 -> [1, 6]
        5 -> [2, 6]
        6 -> [3, 4, 5]
 *
 * isDirected => true
 * Graph Representation (Adjacency List):
        0 -> [1, 2]
        1 -> [3, 4]
        2 -> [5]
        3 -> [6]
        4 -> [6]
        5 -> [6]

    BFS Traversal: 0 1 2 3 4 5 6
 * 
 * is start node is 1:
 * BFS directed -> 1 -> 3-> 4 -> 6
 * BFS undirected -> 1 → 0 → 3 → 4 → 2 → 6 → 5
    */
