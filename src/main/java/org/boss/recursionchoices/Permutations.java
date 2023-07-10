package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String s = "abc";
        permute4(s);
        countPermute4(s);
    }

    static void permute(String s) {
        solve(new StringBuilder(s), 0);
    }

    static void solve(StringBuilder s, int i) {
        if (i == s.length()) {
            System.out.println(s);
            return;
        }
        int j = i;
        while (j < s.length()) {
            char first = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, first);

            solve(s, i + 1);

            first = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, first);

            j++;
        }

    }

    static void permute2(String s) {
        solve2("", s);
    }

    static void solve2(String pS, String upS) {
        if (upS.isEmpty()) {
            System.out.println(pS);
            return;
        }

        char ch = upS.charAt(0);

        // Pick a char
        for (int i = 0; i <= pS.length(); i++) {
            String f = pS.substring(0, i);
            String s = pS.substring(i, pS.length());
            solve2(f + ch + s, upS.substring(1));
        }

    }

    static void permute3(String s) {
        List<String> ans = solve3("", s);
        System.out.println(ans);
    }

    static List<String> solve3(String pS, String upS) {
        if (upS.isEmpty()) {
            List<String> list = new ArrayList<>();
            list.add(pS);
            return list;
        }

        char ch = upS.charAt(0);

        List<String> ans = new ArrayList<>();

        // Pick a char
        for (int i = 0; i <= pS.length(); i++) {
            String f = pS.substring(0, i);
            String s = pS.substring(i, pS.length());
            ans.addAll(solve3(f + ch + s, upS.substring(1)));
        }

        return ans;

    }

    static void permute4(String s) {
        List<String> ans = new ArrayList<>();
        solve4("", s, ans);
        System.out.println(ans);
    }

    static void solve4(String pS, String upS, List<String> ans) {
        if (upS.isEmpty()) {
            ans.add(pS);
            return;
        }

        char ch = upS.charAt(0);

        for (int i = 0; i <= pS.length(); i++) {
            String f = pS.substring(0, i);
            String s = pS.substring(i, pS.length());
            solve4(f + ch + s, upS.substring(1), ans);
        }

    }

    static void countPermute4(String s) {
        int count = solve5("", s);
        System.out.println(count);
    }

    static int solve5(String pS, String upS) {
        if (upS.isEmpty()) {
            return 1;
        }

        char ch = upS.charAt(0);
        int count = 0;

        for (int i = 0; i <= pS.length(); i++) {
            String f = pS.substring(0, i);
            String s = pS.substring(i, pS.length());
            count += solve5(f + ch + s, upS.substring(1));
        }
        return count;
    }
}
