package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import it.unibo.generics.graph.api.Graph;
import it.unibo.generics.graph.api.GraphSearch;

public class GraphImpl<N> implements Graph<N>{

    private final Map<N, Set<N>> adjList;
    private final GraphSearch<N> searchStrategy;

    public GraphImpl(GraphSearch<N> searchStrategy) {    
        this.adjList = new HashMap<>();
        this.searchStrategy = searchStrategy;
    }

    @Override
    public void addNode(N node) {
        if (node != null && !this.adjList.keySet().contains(node)) {
            this.adjList.put(node, new HashSet<N>());
        }
    }

    @Override
    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            this.adjList.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return Set.copyOf(this.adjList.keySet());
    }

    @Override
    public Set<N> linkedNodes(N node) {
        return Set.copyOf(this.adjList.get(node));
    }

    @Override
    public List<N> getPath(N source, N target) {
        return this.searchStrategy.getPath(adjList, source, target);
    }
}
