package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        generate(n);
    }

    static void generate(int n) {
        // Every Good Parenthesis starts with '('
        String s = "(";
        // Choice to add '('
        solve(s + '(', n, 2, 0);
        // Choice to add ')'
        solve(s + ')', n, 1, 1);
    }

    static void solve(String s, int n, int oc, int cc) {
        if (oc == n && cc == n) {
            System.out.println(s);
            return;
        }

        if (oc < n)
            solve(s + '(', n, oc + 1, cc);
        if (oc > cc)
            solve(s + ')', n, oc, cc + 1);

    }

    // Return as List<String>
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String s = "(";
        // Choice to add '('
        solve2(s + '(', n, 2, 0, res);
        // Choice to add ')'
        solve2(s + ')', n, 1, 1, res);
        return res;
    }

    public void solve2(String s, int n, int oc, int cc, List<String> res) {
        if (oc == n && cc == n) {
            res.add(s);
            return;
        }
        int last = s.length() - 1;
        if (oc < n)
            solve2(s + '(', n, oc + 1, cc, res);
        if (cc < n && oc > cc)
            solve2(s + ')', n, oc, cc + 1, res);

    }
}
