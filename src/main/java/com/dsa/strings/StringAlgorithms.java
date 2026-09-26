package com.dsa.strings;

import java.util.Arrays;

public final class StringAlgorithms {
    private StringAlgorithms() { }

    public static boolean isPalindrome(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) if (text.charAt(left++) != text.charAt(right--)) return false;
        return true;
    }

    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) return false;
        char[] firstChars = first.toCharArray(), secondChars = second.toCharArray();
        Arrays.sort(firstChars); Arrays.sort(secondChars);
        return Arrays.equals(firstChars, secondChars);
    }

    public static int countOccurrences(String text, String pattern) {
        if (pattern.isEmpty()) return 0;
        int count = 0;
        for (int start = 0; start + pattern.length() <= text.length(); start++) if (text.startsWith(pattern, start)) count++;
        return count;
    }
}
