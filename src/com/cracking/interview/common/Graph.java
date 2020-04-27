package com.cracking.interview.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Harshada Sawant
 */
public class Graph {
    private final Set<Node> nodes = new HashSet<Node>();

    public Set<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    // returns whether or not a node was removed
    public boolean removeNode(Node node) {
        return nodes.remove(node);
    }
}
