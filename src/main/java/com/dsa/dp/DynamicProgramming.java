package com.dsa.dp;

public final class DynamicProgramming {
    private DynamicProgramming() { }

    public static int climbStairs(int steps) {
        if (steps < 0) throw new IllegalArgumentException("steps cannot be negative");
        int previous = 1, current = 1;
        for (int step = 0; step < steps; step++) { int next = previous + current; previous = current; current = next; }
        return previous;
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        if (weights.length != values.length || capacity < 0) throw new IllegalArgumentException("invalid input");
        int[] best = new int[capacity + 1];
        for (int item = 0; item < weights.length; item++) for (int remaining = capacity; remaining >= weights[item]; remaining--) best[remaining] = Math.max(best[remaining], best[remaining - weights[item]] + values[item]);
        return best[capacity];
    }

    public static int longestCommonSubsequence(String first, String second) {
        int[][] lengths = new int[first.length() + 1][second.length() + 1];
        for (int row = 1; row <= first.length(); row++) for (int column = 1; column <= second.length(); column++) lengths[row][column] = first.charAt(row - 1) == second.charAt(column - 1) ? lengths[row - 1][column - 1] + 1 : Math.max(lengths[row - 1][column], lengths[row][column - 1]);
        return lengths[first.length()][second.length()];
    }
}
