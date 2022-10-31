package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.AbstractGraphSearch;

public class DepthFirstSearch<N> extends AbstractGraphSearch<N>{

    private final Map<N,N> parent;
    private final Map<N,Integer> color;
    
    public DepthFirstSearch() {
        this.parent = new HashMap<>();
        this.color = new HashMap<>();
    }

    @Override
    public List<N> getPath(Map<N, Set<N>> adjList, N source, N target) {
        for (N node: adjList.keySet()) {
            parent.put(node, null);
            color.put(node, WHITE);
        }
        visitDFS(adjList, source);
        return getNodesPathList(this.parent, target);
    }

    private void visitDFS(Map<N, Set<N>> adjList, N discoveredNode) {
        color.put(discoveredNode, GRAY);
        for (N node : adjList.get(discoveredNode)) {
            if (color.get(node) == WHITE) {
                parent.put(node,discoveredNode);
                visitDFS(adjList, node);
            }
        }
        color.put(discoveredNode, BLACK);
    }
    
}
