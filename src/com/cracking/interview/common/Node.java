package com.cracking.interview.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Harshada Sawant
 */
public class Node<T> {
    public T data;
    public boolean visited;
    private Set<Node<T>> adjacent = new HashSet();

    public Set<Node<T>> getAdjacent() {
        return adjacent;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    // returns if the node was added, false if already there
    public boolean addAdjacent(Node<T> node) {
        return adjacent.add(node);
    }

    // returns true if any were added
    public boolean addAdjacents(Set<Node<T>> nodes) {
        return adjacent.addAll(nodes);
    }
    public void visit() {
        visited = true;
    }
}
