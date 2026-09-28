package com.dsa.trees;

public class Trie {
    private final Node root = new Node();

    public void insert(String word) {
        Node current = root;
        for (char character : word.toLowerCase().toCharArray()) {
            if (character < 'a' || character > 'z') throw new IllegalArgumentException("trie supports a-z only");
            int index = character - 'a';
            if (current.children[index] == null) current.children[index] = new Node();
            current = current.children[index];
        }
        current.word = true;
    }

    public boolean contains(String word) { Node node = nodeFor(word); return node != null && node.word; }
    public boolean startsWith(String prefix) { return nodeFor(prefix) != null; }

    private Node nodeFor(String text) {
        Node current = root;
        for (char character : text.toLowerCase().toCharArray()) {
            if (character < 'a' || character > 'z') return null;
            current = current.children[character - 'a'];
            if (current == null) return null;
        }
        return current;
    }

    private static final class Node {
        private final Node[] children = new Node[26];
        private boolean word;
    }
}
