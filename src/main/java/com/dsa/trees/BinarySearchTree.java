package com.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private Node root;

    public void insert(int value) { root = insert(root, value); }
    public boolean contains(int value) { return contains(root, value); }
    public List<Integer> inOrder() { List<Integer> result = new ArrayList<>(); inOrder(root, result); return result; }
    public int height() { return height(root); }
    public boolean isBalanced() { return balanceHeight(root) >= 0; }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value) node.left = insert(node.left, value);
        else if (value > node.value) node.right = insert(node.right, value);
        return node;
    }

    private boolean contains(Node node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        return value < node.value ? contains(node.left, value) : contains(node.right, value);
    }

    private void inOrder(Node node, List<Integer> result) {
        if (node == null) return;
        inOrder(node.left, result); result.add(node.value); inOrder(node.right, result);
    }

    private int height(Node node) { return node == null ? 0 : 1 + Math.max(height(node.left), height(node.right)); }

    private int balanceHeight(Node node) {
        if (node == null) return 0;
        int left = balanceHeight(node.left), right = balanceHeight(node.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }

    private static final class Node {
        private final int value;
        private Node left;
        private Node right;
        private Node(int value) { this.value = value; }
    }
}
