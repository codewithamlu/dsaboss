package org.boss.recursionchoices;

public class PrintSubsets {
    public static void main(String[] args) {
        String s = "abc";
        print(s, "");
    }

    static void print(String s, String out) {
        solve(s, 0, out);
    }

    static void solve(String s, int i, String out) {
        if (i == s.length()) {
            System.out.println(out);
            return;
        }

        // Pick char
        solve(s, i + 1, out + s.charAt(i));

        // Not to pick
        solve(s, i + 1, out);
    }
}
