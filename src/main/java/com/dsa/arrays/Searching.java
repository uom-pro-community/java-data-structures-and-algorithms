package com.dsa.arrays;

public final class Searching {
    private Searching() { }

    public static int linearSearch(int[] values, int target) {
        for (int index = 0; index < values.length; index++) {
            if (values[index] == target) return index;
        }
        return -1;
    }

    public static int binarySearch(int[] sortedValues, int target) {
        int left = 0;
        int right = sortedValues.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sortedValues[middle] == target) return middle;
            if (sortedValues[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    public static int firstOccurrence(int[] sortedValues, int target) {
        int answer = -1;
        int left = 0;
        int right = sortedValues.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (sortedValues[middle] >= target) {
                if (sortedValues[middle] == target) answer = middle;
                right = middle - 1;
            } else left = middle + 1;
        }
        return answer;
    }

    public static int maxSubarraySum(int[] values) {
        if (values.length == 0) throw new IllegalArgumentException("array cannot be empty");
        int best = values[0];
        int current = values[0];
        for (int index = 1; index < values.length; index++) {
            current = Math.max(values[index], current + values[index]);
            best = Math.max(best, current);
        }
        return best;
    }

    public static int[] twoSumSorted(int[] sortedValues, int target) {
        int left = 0, right = sortedValues.length - 1;
        while (left < right) {
            int sum = sortedValues[left] + sortedValues[right];
            if (sum == target) return new int[]{sortedValues[left], sortedValues[right]};
            if (sum < target) left++;
            else right--;
        }
        return new int[0];
    }
}
