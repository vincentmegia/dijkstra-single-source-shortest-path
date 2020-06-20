package com.vincentmegia;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private Node rootNode;
    private List<Node> unvisited;

    public Graph() {
        this.unvisited = new ArrayList<>();

//        this.rootNode = new Node(1);
//        var node2 = new Node(2);
//        var node3 = new Node(3);
//        var node4 = new Node(4);
//        this.rootNode.addEdge(node2, 24);
//        this.rootNode.addEdge(node3, 3);
//        this.rootNode.addEdge(node4, 20);
//        node3.addEdge(node4, 12);
//
//        this.unvisited.add(rootNode);
//        this.unvisited.add(node2);
//        this.unvisited.add(node3);
//        this.unvisited.add(node4);
    }

    public void removeUnvisited(Node node) {
        this.unvisited.remove(node);
    }

    public void setRoot(Node node) {
        this.rootNode = node;
        this.unvisited.add(this.rootNode);
    }

    public void addEdge(Node node, int cost) {
        if (this.rootNode == null)
            this.rootNode = node;
        else
            this.rootNode.addEdge(node, cost);
        this.unvisited.add(node);
    }

    public Node getRootNode() {
        return this.rootNode;
    }

    public List<Node> getUnvisited() {
        return this.unvisited;
    }
}
