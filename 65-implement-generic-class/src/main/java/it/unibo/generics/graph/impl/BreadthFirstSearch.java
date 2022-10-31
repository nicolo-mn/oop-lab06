package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import it.unibo.generics.graph.api.AbstractGraphSearch;

public class BreadthFirstSearch<N> extends AbstractGraphSearch<N>{

    @Override
    public List<N> getPath(Map<N, Set<N>> adjList, N source, N target) {
        Map<N,N> parent = new HashMap<>();
        Map<N,Integer> color = new HashMap<>();
        for (N node: adjList.keySet()) {
            parent.put(node, null);
            color.put(node, WHITE);
        }
        color.put(source, GRAY);
        Queue<N> queue = new LinkedList<>();
        queue.add(source);
        N head;

        while(!queue.isEmpty()) {
            head = queue.element();
            for (N node : adjList.get(head)) {
                if (color.get(node) == WHITE) {
                    color.put(node, GRAY);
                    parent.put(node, head);
                    queue.add(node);
                }
                queue.remove();
                color.put(head, BLACK);
            }
        }
        return getNodesPathList(parent, target);
    }
}
