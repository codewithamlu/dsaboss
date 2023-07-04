package org.boss.strings;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    static int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;

        // Odd length string
        for (int i = 0; i < s.length(); i++) {
            count += getNoOfPalindrome(s, i, i);
        }

        // Even length string
        for (int i = 0; i < s.length(); i++) {
            count += getNoOfPalindrome(s, i, i + 1);
        }

        return count;
    }

    static int getNoOfPalindrome(String s, int cent, int end) {

        int count = 0;
        while (cent >= 0 && end < s.length()) {
            if (s.charAt(cent) == s.charAt(end))
                count++;
            else
                break;
            cent--;
            end++;
        }
        return count;
    }

    static int countSubstrings2(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sb = s.substring(i, j + 1);
                if (isPalindrome(sb))
                    count++;
            }
        }
        return count;
    }

    static boolean isPalindrome(String s) {
        if (s.isEmpty())
            return false;

        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
