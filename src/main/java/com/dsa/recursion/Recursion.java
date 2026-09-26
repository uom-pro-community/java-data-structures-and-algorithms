package com.dsa.recursion;

public final class Recursion {
    private Recursion() { }

    public static long factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("number cannot be negative");
        return number <= 1 ? 1 : number * factorial(number - 1);
    }

    public static long fibonacci(int number) {
        if (number < 0) throw new IllegalArgumentException("number cannot be negative");
        if (number <= 1) return number;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static int gcd(int first, int second) {
        first = Math.abs(first); second = Math.abs(second);
        return second == 0 ? first : gcd(second, first % second);
    }

    public static boolean isPalindrome(String text) { return isPalindrome(text, 0, text.length() - 1); }

    private static boolean isPalindrome(String text, int left, int right) {
        return left >= right || text.charAt(left) == text.charAt(right) && isPalindrome(text, left + 1, right - 1);
    }
}
