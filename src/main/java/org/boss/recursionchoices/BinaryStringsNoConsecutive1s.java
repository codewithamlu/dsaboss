package org.boss.recursionchoices;

public class BinaryStringsNoConsecutive1s {
    public static void main(String[] args) {
        int k = 4;
        print(k);
    }

    static void print(int k) {
        solve(k);
    }

    static void solve(int k) {
        // Two Choices
        // Binary strings starting with 0
        String s0 = "0";
        helper(s0, k - 1);

        // Binary strings starting with 1
        String s1 = "1";
        helper(s1, k - 1);
    }

    static void helper(String s, int k) {
        if (k == 0) {
            System.out.println(s);
            return;
        }
        int last = s.length() - 1;
        if (s.charAt(last) == '0') {
            helper(s + '0', k - 1);
            helper(s + '1', k - 1);
        }
        if (s.charAt(last) == '1') {
            helper(s + '0', k - 1);
        }
    }
}
