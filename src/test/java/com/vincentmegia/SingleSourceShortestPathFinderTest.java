package com.vincentmegia;

import org.junit.Test;

public class SingleSourceShortestPathFinderTest {
    //@Test
    public void test() {
        var graph = new Graph();
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);
        graph.setRoot(node1);
        graph.addEdge(node2, 24);
        graph.addEdge(node3, 3);
        graph.addEdge(node4, 20);
        node3.addEdge(node4, 12);

        var sssp = new SingleSourceShortestPathFinder(graph);
        var result = sssp.find(graph);
        System.out.println(result);
    }

    @Test public void test2() {
        var graph = new Graph();
        var nodeA = new Node("A");
        var nodeB = new Node("B");
        var nodeC = new Node("C");
        var nodeD = new Node("D");
        var nodeE = new Node("E");
        var nodeF = new Node("F");
        var nodeG = new Node("G");
        var nodeH = new Node("H");

        nodeA.addEdge(nodeB, 8);
        nodeA.addEdge(nodeC, 2);
        nodeA.addEdge(nodeD, 5);
        graph.setRoot(nodeA);

        nodeB.addEdge(nodeD, 2);
        nodeB.addEdge(nodeF, 13);
        nodeB.addEdge(nodeA, 8);

        nodeC.addEdge(nodeA, 2);
        nodeC.addEdge(nodeD, 2);
        nodeC.addEdge(nodeE, 5);

        nodeD.addEdge(nodeA, 5);
        nodeD.addEdge(nodeB, 2);
        nodeD.addEdge(nodeC, 2);
        nodeD.addEdge(nodeF, 6);
        nodeD.addEdge(nodeG, 3);
        nodeD.addEdge(nodeE, 1);

        nodeE.addEdge(nodeC, 5);
        nodeE.addEdge(nodeD, 1);
        nodeE.addEdge(nodeG, 1);

        nodeF.addEdge(nodeB, 13);
        nodeF.addEdge(nodeD, 6);
        nodeF.addEdge(nodeG, 2);
        nodeF.addEdge(nodeH, 3);

        nodeG.addEdge(nodeD, 3);
        nodeG.addEdge(nodeE, 1);
        nodeG.addEdge(nodeF, 2);
        nodeG.addEdge(nodeH, 6);

        nodeH.addEdge(nodeF, 3);
        nodeH.addEdge(nodeG, 6);

        graph.getUnvisited().add(nodeB);
        graph.getUnvisited().add(nodeC);
        graph.getUnvisited().add(nodeD);
        graph.getUnvisited().add(nodeE);
        graph.getUnvisited().add(nodeF);
        graph.getUnvisited().add(nodeG);
        graph.getUnvisited().add(nodeH);

        //error in FGH values and all subscripts are wrong
        var sssp = new SingleSourceShortestPathFinder(graph);
        var result = sssp.find(graph);
        System.out.println(result);
    }
}
