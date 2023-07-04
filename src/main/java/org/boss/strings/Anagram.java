package org.boss.strings;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "dcab";
        System.out.println(isAnagram4(s, t));
    }

    /*
     * Brute-force approaach
     * Sort both the strings and check if at each position charaters are equal or
     * not
     * 
     * Time Complexity : O(nlogn + n) -> O(nlogn)
     * Space Complexity : O(n)
     */
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        String s3 = new String(sArr);

        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        String s4 = new String(tArr);

        for (int i = 0; i < s3.length(); i++) {
            if (s3.charAt(i) != s4.charAt(i))
                return false;
        }
        return true;
    }

    /*
     * Better Appraoch -
     * Store count of each character in an array
     * Check if count of each character is equal for both the freqency arrays
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq1[ch - 97]++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freq2[ch - 97]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])
                return false;
        }
        return true;
    }

    /*
     * Another Better Appraoch -
     * Make frequency array of size 26
     * Increment count of letter of first string and decrease count of letter of
     * same character from second string
     * 
     * Iterate and check if for any value is not zero, if so return false as if any
     * value if greater than 0 means there must be character which is extra or has
     * different frequency
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqency = new int[26];

        for (int i = 0; i < s.length(); i++) {

            freqency[s.charAt(i) - 97]++;
            freqency[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < freqency.length; i++) {
            if (freqency[i] != 0)
                return false;
        }
        return true;
    }

    static boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int count = freq1.getOrDefault(s.charAt(i), 0);
            freq1.put(s.charAt(i), count++);
        }
        for (int i = 0; i < t.length(); i++) {
            int count = freq2.getOrDefault(t.charAt(i), 0);
            freq2.put(t.charAt(i), count++);
        }

        if (!freq1.equals(freq2))
            return false;
        return true;
    }
}
