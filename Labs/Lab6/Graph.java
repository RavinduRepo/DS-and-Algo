// e20280
// lab 6

import java.util.*;

class Graph {
    private Map<String, List<Edge>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Add a new node to the graph
    public void addNode(String nodeName) {
        adjacencyList.putIfAbsent(nodeName, new ArrayList<>());
    }

    // Add an edge between two nodes with a given cost
    public void addEdge(String source, String destination, double cost) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>()); // Ensure destination exists
        adjacencyList.get(source).add(new Edge(destination, cost));
    }

    // Get adjacency list
    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    // Print the adjacency list
    public void printGraph() {
        System.out.println("Graph:");
        for (var entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Edge edge : entry.getValue()) {
                System.out.print("(" + edge.destination + ", " + edge.cost + ") ");
            }
            System.out.println();
        }
    }

    // Print the distenses from given source node
    public static void printDistances(int source, Map<String, Double> distances) {
        System.out.println("Distances from S" + source + ":");
        for (Map.Entry<String, Double> entry : distances.entrySet()) {
            String value = (entry.getValue() == Double.MAX_VALUE) ? "-" : String.format("%.2f", entry.getValue());
            System.out.printf("  %-3s : %s%n", entry.getKey(), value);
        }
        System.out.println();
    }

    // inner class to represent an edge
    static class Edge {
        String destination;
        double cost;

        public Edge(String destination, double cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode("S0");
        graph.addNode("S1");

        // add nodes named D2 to D11
        for (int i = 2; i < 12; i++) {
            graph.addNode("D" + i);
        }

        // Add edges
        graph.addEdge("S0", "D2", 1);
        graph.addEdge("S0", "D8", 5);

        graph.addEdge("S1", "D3", 6);

        graph.addEdge("D2", "D3", 11);
        graph.addEdge("D2", "D5", 10);
        graph.addEdge("D2", "D10", 7);
        graph.addEdge("D2", "D11", 2);

        graph.addEdge("D3", "D9", 4);
        graph.addEdge("D3", "D4", 9);

        graph.addEdge("D4", "D5", 4);
        graph.addEdge("D4", "S1", 10);
        graph.addEdge("D4", "D7", 1);

        graph.addEdge("D5", "S0", 3);
        graph.addEdge("D5", "D7", 7);

        graph.addEdge("D6", "D4", 2);

        graph.addEdge("D7", "D6", 12);

        graph.addEdge("D8", "D7", 7);

        graph.addEdge("D9", "S1", 12);

        graph.addEdge("D10", "D3", 5);

        // Print the graph
        graph.printGraph();

        // variable to store which source should pick for each node and the cost to reach that node (destination node, (source node, cost))
        Map<String, Map<String, Double>> allDistances = new HashMap<>();

        // count the number of source nodes
        int sourceCount = 0;
        for (String node : graph.getAdjacencyList().keySet()) {
            if (node.startsWith("S")) {
                sourceCount++;
            }
        }

        System.out.println("distences from all source nodes:");
        // loop through all 'S' nodes as source nodes and save the distances to all other nodes(directly access source nodes using 'S' + i as key)(replace with shortest path and source in each iteration)
        for (int i = 0; i < sourceCount; i++) {
            // get the distances from source node 'S' + i to all other nodes
            Map<String, Double> distances = dijkstra(graph, "S" + i);
            // Print all distances from the current source in a structured format
            printDistances(i, distances);

            // store the shortest path and source for each node (check if in allDistances the dest as key exists, and check if the cost is smaller than the current cost)
            for (String dest : distances.keySet()) {
                // if the destination node is not in the map or the cost is smaller than the current cost(allDistences), update the cost and source
                if (!allDistances.containsKey(dest) || distances.get(dest) < allDistances.get(dest).values().iterator().next()) {
                    allDistances.put(dest, Map.of("S" + i, distances.get(dest)));
                }
            }
        }

        // print the shortest path and source for each destination node
        System.out.println("Shortest path and source for each destination node:");
        for (int i = 2; i < 12; i++) {
            System.out.println("D" + i + ": " + allDistances.get("D" + i));
        }
    }

    // dijsktra function to get the graph and source and output the least cost distences to all other nodes
    public static Map<String, Double> dijkstra (Graph gaph, String source) {
        // implement dijkstra algorithm
        Map<String, List<Edge>> adjList = gaph.getAdjacencyList();
        
        // create a map to store the distance from source to each node
        Map<String, Double> dist = new HashMap<>();
        // // create a map to store the previous node of each node
        // Map<String, String> prev = new HashMap<>();
        // create a priority queue to store the nodes
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            // Double.compare(dist.get(o1), dist.get(o2)): Uses Double.compare to compare the distances of the two nodes. 
            // This ensures that the node with the smallest distance is given the highest priority in the queue.
            @Override
            public int compare(String o1, String o2) {
                return Double.compare(dist.get(o1), dist.get(o2));
            }
        });
        // add all the nodes to the priority queue
        for (String node : adjList.keySet()) {
            // set the distance of each node to infinity(Double.MAX_VALUE is the largest value of double to represent infinity)
            dist.put(node, Double.MAX_VALUE);
            // prev.put(node, null); // null is the previous node of the node
        }
        // set the distance of the source node to 0(the distance from source to source is 0)
        dist.put(source, 0.0);
        // add the source node to the priority queue
        pq.add(source);

        
        while (!pq.isEmpty()) {
            // get the node with the smallest distance(pq.poll() will remove the node from the priority queue)
            String current = pq.poll();
            // iterate through all the neighbors of the current node(adjList.get(current) return the list of neighbors of the current node)
            for (Edge edge : adjList.get(current)) {

                ////// skip all source nodes (source nodes starts with 'S') ////// not nessesory
                ////// System.out.println(edge);
                ////// if (edge.destination.startsWith("S")) {
                //////     // skip the source node
                //////     System.out.println("continue");
                //////     continue;
                ////// }
                ////// System.out.println("not cont");
            
                // calculate the new distance from source to the neighbor node
                double newDist = dist.get(current) + edge.cost;
                // if the new distance is smaller than the current distance of the neighbor node(dist.get(edge.destination) return the distance from source to the neighbor node)
                if (newDist < dist.get(edge.destination)) {
                    // update the distance of the neighbor node
                    dist.put(edge.destination, newDist);
                    // // update the previous node of the neighbor node as the current node
                    // prev.put(edge.destination, current);
                    // add the neighbor node to the priority queue(visiting the neighbor node in next iteration)
                    pq.add(edge.destination);
                }
            }
        }
        // return the distance from source to all destinations
        return dist;

    }
}
