package org.boss.recursionchoices;

public class PrintSubsequences {
    public static void main(String[] args) {
        String s = "abc";
        print(s);
        System.out.println("---------------------");
        print2(s);
    }

    static void print(String s) {
        solve(s, 0, "");
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

    static void print2(String s) {
        solve2("", s);
    }

    static void solve2(String pS, String upS) {
        if (upS.isEmpty()) {
            System.out.println(pS);
            return;
        }

        char ch = upS.charAt(0);
        // Pick char
        solve2(pS + ch, upS.substring(1));

        // Not to pick
        solve2(pS, upS.substring(1));
    }
}
