package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public final class Backtracking {
    private Backtracking() { }

    public static List<List<Integer>> subsets(int[] values) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(values, 0, new ArrayList<>(), result);
        return result;
    }

    public static List<List<Integer>> permutations(int[] values) {
        List<List<Integer>> result = new ArrayList<>();
        permutations(values, 0, result);
        return result;
    }

    public static List<List<String>> nQueens(int size) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[size][size];
        for (char[] row : board) java.util.Arrays.fill(row, '.');
        placeQueen(0, board, result);
        return result;
    }

    private static void subsets(int[] values, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == values.length) { result.add(new ArrayList<>(current)); return; }
        subsets(values, index + 1, current, result);
        current.add(values[index]); subsets(values, index + 1, current, result); current.remove(current.size() - 1);
    }

    private static void permutations(int[] values, int index, List<List<Integer>> result) {
        if (index == values.length) { List<Integer> item = new ArrayList<>(); for (int value : values) item.add(value); result.add(item); return; }
        for (int next = index; next < values.length; next++) { swap(values, index, next); permutations(values, index + 1, result); swap(values, index, next); }
    }

    private static void placeQueen(int row, char[][] board, List<List<String>> result) {
        if (row == board.length) { List<String> solution = new ArrayList<>(); for (char[] line : board) solution.add(new String(line)); result.add(solution); return; }
        for (int column = 0; column < board.length; column++) if (isSafe(board, row, column)) { board[row][column] = 'Q'; placeQueen(row + 1, board, result); board[row][column] = '.'; }
    }

    private static boolean isSafe(char[][] board, int row, int column) {
        for (int previous = 0; previous < row; previous++) for (int delta = -1; delta <= 1; delta++) { int candidate = column + delta * (row - previous); if (candidate >= 0 && candidate < board.length && board[previous][candidate] == 'Q') return false; }
        return true;
    }

    private static void swap(int[] values, int first, int second) { int temporary = values[first]; values[first] = values[second]; values[second] = temporary; }
}
