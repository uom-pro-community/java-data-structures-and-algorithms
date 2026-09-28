package com.dsa.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MinHeap {
    private final List<Integer> values = new ArrayList<>();

    public void add(int value) {
        values.add(value);
        siftUp(values.size() - 1);
    }

    public int peek() {
        if (values.isEmpty()) throw new NoSuchElementException("heap is empty");
        return values.get(0);
    }

    public int remove() {
        int result = peek();
        int last = values.remove(values.size() - 1);
        if (!values.isEmpty()) { values.set(0, last); siftDown(0); }
        return result;
    }

    public boolean isEmpty() { return values.isEmpty(); }
    public int size() { return values.size(); }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (values.get(parent) <= values.get(index)) break;
            swap(parent, index); index = parent;
        }
    }

    private void siftDown(int index) {
        while (true) {
            int left = index * 2 + 1, right = left + 1, smallest = index;
            if (left < values.size() && values.get(left) < values.get(smallest)) smallest = left;
            if (right < values.size() && values.get(right) < values.get(smallest)) smallest = right;
            if (smallest == index) return;
            swap(index, smallest); index = smallest;
        }
    }

    private void swap(int first, int second) {
        int temporary = values.get(first); values.set(first, values.get(second)); values.set(second, temporary);
    }
}
