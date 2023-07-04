package org.boss.recursion;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "abcdcbassd";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        return solve(s, 0, s.length() - 1);
    }

    static boolean solve(String s, int start, int end) {
        // when all corresponding char match
        if (start > end)
            return true;
        if (s.charAt(start) != s.charAt(end))
            return false;
        else
            return solve(s, start + 1, end - 1);

    }
}
