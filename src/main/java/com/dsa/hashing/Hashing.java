package com.dsa.hashing;

import java.util.HashMap;
import java.util.Map;

public final class Hashing {
    private Hashing() { }

    public static int[] twoSum(int[] values, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int index = 0; index < values.length; index++) {
            int complement = target - values[index];
            if (seen.containsKey(complement)) return new int[]{seen.get(complement), index};
            seen.put(values[index], index);
        }
        return new int[0];
    }

    public static Map<Integer, Integer> frequencies(int[] values) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int value : values) result.merge(value, 1, Integer::sum);
        return result;
    }

    public static char firstNonRepeating(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char character : text.toCharArray()) counts.merge(character, 1, Integer::sum);
        for (char character : text.toCharArray()) if (counts.get(character) == 1) return character;
        return '\0';
    }
}
