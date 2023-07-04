package org.boss.strings;

public class RemoveSpaces {
    public static void main(String[] args) {
        String str = "abcd     ass  as a";
        System.out.println(removeSpaces2(str));
    }

    /*
     * Iterate over string and check for non-space character and add it to result
     * String
     * 
     * Time Complexity : O(n^2)
     * Space Complexity : O(1)
     */
    static String removeSpaces(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                ans += str.charAt(i);
            }
        }
        return ans;
    }

    /*
     * Iterate over string and check for non-space character and add it to result
     * StringBuilder
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static String removeSpaces2(String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                ans.append(str.charAt(i));
            }
        }
        return ans.toString();
    }
}
