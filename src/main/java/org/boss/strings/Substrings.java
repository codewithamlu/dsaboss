package org.boss.strings;

public class Substrings {
    public static void main(String[] args) {
        String str = "abcd";
        subStrings(str);
    }

    /*
     * For each character make a substring with each subsequent character starting
     * from length 1 to n
     * 
     * Time Complexity :  O(n^2)
     * Space Complexity : O(1)
     */
    static void subStrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                System.out.println(str.substring(i, j + 1));
            }
        }
    }
}
