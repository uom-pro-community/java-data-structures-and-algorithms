package com.dsa.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public final class MonotonicStack {
    private MonotonicStack() { }

    public static int[] nextGreaterElements(int[] values) {
        int[] result = new int[values.length];
        Arrays.fill(result, -1);
        Deque<Integer> pending = new ArrayDeque<>();
        for (int index = 0; index < values.length; index++) {
            while (!pending.isEmpty() && values[pending.peek()] < values[index]) result[pending.pop()] = values[index];
            pending.push(index);
        }
        return result;
    }
}
