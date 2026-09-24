package com.dsa.arrays;

public final class Sorting {
    private Sorting() { }

    public static void bubbleSort(int[] values) {
        for (int end = values.length - 1; end > 0; end--) {
            boolean swapped = false;
            for (int index = 0; index < end; index++) {
                if (values[index] > values[index + 1]) {
                    swap(values, index, index + 1);
                    swapped = true;
                }
            }
            if (!swapped) return;
        }
    }

    public static void insertionSort(int[] values) {
        for (int index = 1; index < values.length; index++) {
            int current = values[index];
            int position = index - 1;
            while (position >= 0 && values[position] > current) {
                values[position + 1] = values[position--];
            }
            values[position + 1] = current;
        }
    }

    public static void selectionSort(int[] values) {
        for (int index = 0; index < values.length; index++) {
            int smallest = index;
            for (int candidate = index + 1; candidate < values.length; candidate++) {
                if (values[candidate] < values[smallest]) smallest = candidate;
            }
            swap(values, index, smallest);
        }
    }

    public static void mergeSort(int[] values) {
        mergeSort(values, 0, values.length - 1, new int[values.length]);
    }

    private static void mergeSort(int[] values, int left, int right, int[] buffer) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(values, left, middle, buffer);
        mergeSort(values, middle + 1, right, buffer);
        int first = left, second = middle + 1, write = left;
        while (first <= middle && second <= right) buffer[write++] = values[first] <= values[second] ? values[first++] : values[second++];
        while (first <= middle) buffer[write++] = values[first++];
        while (second <= right) buffer[write++] = values[second++];
        for (int index = left; index <= right; index++) values[index] = buffer[index];
    }

    public static void quickSort(int[] values) { quickSort(values, 0, values.length - 1); }

    public static void heapSort(int[] values) {
        for (int index = values.length / 2 - 1; index >= 0; index--) siftDown(values, index, values.length);
        for (int end = values.length - 1; end > 0; end--) {
            swap(values, 0, end);
            siftDown(values, 0, end);
        }
    }

    private static void siftDown(int[] values, int root, int length) {
        while (root * 2 + 1 < length) {
            int child = root * 2 + 1;
            if (child + 1 < length && values[child + 1] > values[child]) child++;
            if (values[root] >= values[child]) return;
            swap(values, root, child);
            root = child;
        }
    }

    private static void quickSort(int[] values, int left, int right) {
        if (left >= right) return;
        int pivot = values[right];
        int smaller = left;
        for (int index = left; index < right; index++) if (values[index] <= pivot) swap(values, smaller++, index);
        swap(values, smaller, right);
        quickSort(values, left, smaller - 1);
        quickSort(values, smaller + 1, right);
    }

    private static void swap(int[] values, int first, int second) {
        int temporary = values[first]; values[first] = values[second]; values[second] = temporary;
    }
}
