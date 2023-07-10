package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        String inp = "";
        List<String> ans = letterCombinations(inp);
        System.out.println(ans);
    }

    static List<String> letterCombinations(String digits) {
        String[] options = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> ans = new ArrayList<>();
        solve(digits, "", 0, options, ans);
        return ans;
    }

    static void solve(String s, String out, int i, String[] options, List<String> ans) {
        if (s.isEmpty())
            return;
        if (i == s.length()) {
            ans.add(out);
            return;
        }
        int pos = s.charAt(i) - 48;
        String letters = options[pos];
        for (int j = 0; j < letters.length(); j++) {
            String comb = out + letters.charAt(j);
            solve(s, comb, i + 1, options, ans);
        }
    }
}
