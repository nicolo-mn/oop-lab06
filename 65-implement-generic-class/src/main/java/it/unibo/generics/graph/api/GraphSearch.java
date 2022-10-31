package it.unibo.generics.graph.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface GraphSearch<N> {

    List<N> getPath(Map<N, Set<N>> adjList, N source, N target);

}
