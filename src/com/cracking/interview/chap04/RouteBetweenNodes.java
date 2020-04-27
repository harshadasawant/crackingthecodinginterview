package com.cracking.interview.chap04;

import com.cracking.interview.common.Graph;
import com.cracking.interview.common.Node;

import java.util.*;

/**
 * @author Harshada Sawant
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
                System.out.println("i="+curr.data);
                System.out.println("j= "+end.data);
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
//    Set<Node> nodes = new HashSet<>();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node1.addAdjacent(node2);
        node2.addAdjacent(node3);
//        nodes.add(node1);
//        nodes.add(node2);
//        nodes.add(node3);
        Graph g = new Graph();
        g.addNode(node1);
        System.out.println("Route exists? (should be true): " + RouteBetweenNodes.search(g, node1, node2));
    }
}


