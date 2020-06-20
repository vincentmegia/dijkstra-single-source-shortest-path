package com.vincentmegia;

import java.util.*;

public class SingleSourceShortestPathFinder {
    private Map<Node, Integer> table;
    private Graph graph;
    private Set<Node> visited;

    public SingleSourceShortestPathFinder(Graph graph) {
        this.table = new HashMap<>();
        this.graph = graph;
        this.visited = new HashSet<>();
    }

    public Map<Node, Integer> find(Graph graph) {
        var node = graph.getRootNode();
        var currentNode = node; //set to node for now
        node.setSubscript(node);
        table.put(node, 0);
        while(graph.getUnvisited().size() != 0) {
            for (var edge : currentNode.getEdges()) {
                if (this.visited.contains(edge)) continue;
                if (!table.containsKey(node))
                    table.put(node, Integer.MAX_VALUE);
                if (!table.containsKey(edge))
                    table.put(edge, Integer.MAX_VALUE);

                var start = table.get(currentNode);
                var end = table.get(edge);
                var cost = currentNode.getCost(edge);
                var value = Math.min(start + cost, end);
                edge.setSubscript(currentNode);
                table.put(edge, value);
            }

            this.visited.add(currentNode);
            this.graph.removeUnvisited(currentNode);
            //gredy method, find minValue unvisisted node
            var minValue = Integer.MAX_VALUE;
            for (var entry : table.entrySet()) {
                if (this.visited.contains(entry.getKey())) continue;
                if (entry.getValue() < minValue) {
                    minValue = entry.getValue();
                    currentNode = entry.getKey();
                }
            }
        }
        print(currentNode);
        return table;
    }

    /**
     * Recurse until start = start
     * @param node
     */
    public void print(Node node) {
        System.out.println(node.getId());
        if (node.equals(node.getSubscript())) return;
        print(node.getSubscript());
    }
}
