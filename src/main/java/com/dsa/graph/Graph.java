package com.dsa.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    private final List<List<Edge>> adjacency;

    public Graph(int vertices) {
        if (vertices < 0) throw new IllegalArgumentException("vertices cannot be negative");
        adjacency = new ArrayList<>(vertices);
        for (int index = 0; index < vertices; index++) adjacency.add(new ArrayList<>());
    }

    public void addEdge(int from, int to, int weight) {
        checkVertex(from); checkVertex(to);
        if (weight < 0) throw new IllegalArgumentException("Dijkstra requires non-negative weights");
        adjacency.get(from).add(new Edge(to, weight));
    }

    public List<Integer> bfs(int start) {
        checkVertex(start);
        boolean[] visited = new boolean[adjacency.size()];
        List<Integer> order = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start); visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.remove(); order.add(current);
            for (Edge edge : adjacency.get(current)) if (!visited[edge.to]) { visited[edge.to] = true; queue.add(edge.to); }
        }
        return order;
    }

    public List<Integer> dfs(int start) {
        checkVertex(start);
        List<Integer> order = new ArrayList<>();
        dfs(start, new boolean[adjacency.size()], order);
        return order;
    }

    public int[] dijkstra(int source) {
        checkVertex(source);
        int[] distance = new int[adjacency.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        queue.add(new Edge(source, 0));
        while (!queue.isEmpty()) {
            Edge current = queue.remove();
            if (current.weight != distance[current.to]) continue;
            for (Edge edge : adjacency.get(current.to)) {
                long candidate = (long) current.weight + edge.weight;
                if (candidate < distance[edge.to]) { distance[edge.to] = (int) candidate; queue.add(new Edge(edge.to, distance[edge.to])); }
            }
        }
        return distance;
    }

    private void dfs(int vertex, boolean[] visited, List<Integer> order) {
        visited[vertex] = true; order.add(vertex);
        for (Edge edge : adjacency.get(vertex)) if (!visited[edge.to]) dfs(edge.to, visited, order);
    }

    private void checkVertex(int vertex) { if (vertex < 0 || vertex >= adjacency.size()) throw new IndexOutOfBoundsException(vertex); }

    private record Edge(int to, int weight) { }
}
