package org.boss.recursion;

public class MoveAllXtoEnd {
    public static void main(String[] args) {
        String s = "abxcdxjnxxsa";
        System.out.println(moveX(s));
    }

    static String moveX(String s) {
        return solve(s, 0);
    }

    static String solve(String s, int i) {
        if (i == s.length() - 1)
            return "" + s.charAt(i);
        char ch = s.charAt(i);
        String smallerPart = solve(s, i + 1);
        if (ch == 'x')
            return smallerPart + ch;
        else
            return ch + smallerPart;

    }
}
