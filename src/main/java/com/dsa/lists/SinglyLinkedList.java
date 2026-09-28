package com.dsa.lists;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public void addFirst(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public void addLast(T value) {
        if (head == null) addFirst(value);
        else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = new Node<>(value, null);
            size++;
        }
    }

    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("list is empty");
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public void reverse() {
        Node<T> previous = null;
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    @Override public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (Node<T> current = head; current != null; current = current.next) {
            if (result.length() > 1) result.append(", ");
            result.append(current.value);
        }
        return result.append(']').toString();
    }

    private static final class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
