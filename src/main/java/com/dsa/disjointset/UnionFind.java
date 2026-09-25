package com.dsa.disjointset;

public class UnionFind {
    private final int[] parent;
    private final byte[] rank;

    public UnionFind(int size) {
        if (size < 0) throw new IllegalArgumentException("size cannot be negative");
        parent = new int[size]; rank = new byte[size];
        for (int index = 0; index < size; index++) parent[index] = index;
    }

    public int find(int value) {
        check(value);
        if (parent[value] != value) parent[value] = find(parent[value]);
        return parent[value];
    }

    public boolean union(int first, int second) {
        int firstRoot = find(first), secondRoot = find(second);
        if (firstRoot == secondRoot) return false;
        if (rank[firstRoot] < rank[secondRoot]) parent[firstRoot] = secondRoot;
        else { parent[secondRoot] = firstRoot; if (rank[firstRoot] == rank[secondRoot]) rank[firstRoot]++; }
        return true;
    }

    public boolean connected(int first, int second) { return find(first) == find(second); }
    private void check(int value) { if (value < 0 || value >= parent.length) throw new IndexOutOfBoundsException(value); }
}
