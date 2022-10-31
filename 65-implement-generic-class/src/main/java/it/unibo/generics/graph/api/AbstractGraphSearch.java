package it.unibo.generics.graph.api;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractGraphSearch<N> implements GraphSearch<N> {
    protected static final int WHITE = 0;
    protected static final int GRAY = 1;
    protected static final int BLACK = 2;

    @Override
    abstract public List<N> getPath(Map<N, Set<N>> adjList, N source, N target);

    protected List<N> getNodesPathList(Map<N,N> parent, N target) {
        LinkedList<N> pathList = new LinkedList<>();
        N current = target;
        while (current != null) {
            pathList.addFirst(current);
            current = parent.get(current);
        }
        return pathList;
    }
    
}
