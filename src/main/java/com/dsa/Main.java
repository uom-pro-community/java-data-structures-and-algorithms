package com.dsa;

import com.dsa.arrays.Searching;
import com.dsa.arrays.Sorting;
import com.dsa.dp.DynamicProgramming;
import com.dsa.graph.Graph;
import com.dsa.hashing.Hashing;
import com.dsa.lists.SinglyLinkedList;
import com.dsa.recursion.Backtracking;
import com.dsa.recursion.Recursion;
import com.dsa.trees.BinarySearchTree;
import java.util.Arrays;

public final class Main {
    private Main() { }

    public static void main(String[] args) {
        int[] values = {7, 2, 9, 1, 5, 3};
        Sorting.mergeSort(values);
        System.out.println("sorted: " + Arrays.toString(values));
        System.out.println("binary search 5: " + Searching.binarySearch(values, 5));

        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.reverse();
        System.out.println("linked list: " + list);

        BinarySearchTree tree = new BinarySearchTree();
        for (int value : new int[]{8, 3, 10, 1, 6, 14}) tree.insert(value);
        System.out.println("tree inorder: " + tree.inOrder());

        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 4, 5);
        System.out.println("graph BFS: " + graph.bfs(0));
        System.out.println("Dijkstra from 0: " + Arrays.toString(graph.dijkstra(0)));

        System.out.println("two sum: " + Arrays.toString(Hashing.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("factorial 5: " + Recursion.factorial(5));
        System.out.println("subsets of [1, 2]: " + Backtracking.subsets(new int[]{1, 2}));
        System.out.println("LCS: " + DynamicProgramming.longestCommonSubsequence("abcde", "ace"));
    }
}
