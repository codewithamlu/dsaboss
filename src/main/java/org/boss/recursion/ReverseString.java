package org.boss.recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(reverse(s));
    }

    static String reverse(String s) {

        return solve(s, 0);
    }

    static String solve(String s, int i) {
        if (i == s.length() - 1)
            return "" + s.charAt(i);
        char ch = s.charAt(i);
        String smallerPart = solve(s, i + 1);
        return smallerPart + ch;

    }

    static String solve2(String s) {
        if (s.length() <= 1 || s == null)
            return s;
        char ch = s.charAt(s.length() - 1);
        String smallerPart = solve2(s.substring(0, s.length() - 1));
        return ch + smallerPart;
    }
}
