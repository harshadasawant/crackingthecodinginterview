package com.cracking.interview.chap04;

import com.cracking.interview.common.Graph;
import com.cracking.interview.common.Node;

import java.util.*;

/**
 * @author Harshada Sawant
 * Q 4.1:-> Route Between Nodes : Given a directed graph, design an algorith to find out whether there is a route between two node.
 */
enum state{
    Unvisited,
    Visited,
    Visiting
}
public class RouteBetweenNodes {
    public static boolean search (Graph g, Node start, Node end){
        if (start == end) {
            return true;
        }


        LinkedList<Node> queue = new LinkedList<Node>(); // use linkedList as a queue
        start.visit();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            if (curr == end) {
                return true;
            }
            Iterator<Node> nodeIterator = curr.getAdjacent().iterator();

            while (nodeIterator.hasNext()) {
                Node neighbor = nodeIterator.next();
                if (!neighbor.visited) {
                    neighbor.visit();
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.addAdjacent(node2);
        node1.addAdjacent(node3);
        node1.addAdjacent(node4);
        node3.addAdjacent(node5);
        Graph g = new Graph();
        g.addNode(node1);
        System.out.println("Is Route exists : " + RouteBetweenNodes.search(g, node1, node4));
    }
}


