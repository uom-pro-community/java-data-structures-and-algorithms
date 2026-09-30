package com.dsa.queues;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private final Object[] values;
    private int front;
    private int size;

    public CircularQueue(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("capacity must be positive");
        values = new Object[capacity];
    }

    public void offer(T value) {
        if (size == values.length) throw new IllegalStateException("queue is full");
        values[(front + size) % values.length] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty");
        T value = (T) values[front];
        values[front] = null;
        front = (front + 1) % values.length;
        size--;
        return value;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
}
