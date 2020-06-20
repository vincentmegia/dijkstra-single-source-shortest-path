package com.vincentmegia;

import java.util.*;

public class Node {
    private String id;
    private Map<String, Integer> costStore;
    private List<Node> edges;
    private Node subscript;

    public Node(int id) {
        this(String.valueOf(id));
    }

    public Node(String id){
        this.id = id;
        this.costStore = new HashMap<>();
        this.edges = new ArrayList<>();
    }

    public int getCost(Node node) {
        var key = this.getId() + "-" + node.getId();
        return getCost(key);
    }

    public void setSubscript(Node node) {
        this.subscript = node;
    }

    public int getCost(String key) {
        return costStore.get(key);
    }

    public void addEdge(Node node, int cost) {
        var key = this.id + "-" + node.getId();
        this.costStore.put(key, cost);
        this.edges.add(node);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId(int id) { this.id = String.valueOf(id); }

    public List<Node> getEdges() {
        return edges;
    }


    @Override
    public boolean equals(Object o) {
        Node node = (Node)o;
        if (node.getId() == this.id) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id='" + id + '\'' +
                '}';
    }
}
