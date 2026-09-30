package com.dsa.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    private Object[] values = new Object[8];
    private int size;

    public void push(T value) {
        if (size == values.length) values = Arrays.copyOf(values, values.length * 2);
        values[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T value = (T) values[--size];
        values[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();
        return (T) values[size - 1];
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }
}
