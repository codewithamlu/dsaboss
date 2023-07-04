package org.boss.recursion;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String s = "aaabbbcddee";
        System.out.println(removeDup(s));
    }

    static String removeDup(String s) {
        return solve(s, 0);
    }

    static String solve(String s, int i) {
        if (i == s.length() - 1)
            return "" + s.charAt(i);

        char ch = s.charAt(i);
        String smallerPart = solve(s, i + 1);
        if (ch == smallerPart.charAt(0))
            return smallerPart;
        else
            return ch + smallerPart;
    }
}
