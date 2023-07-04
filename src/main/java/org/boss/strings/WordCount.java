package org.boss.strings;

public class WordCount {
    public static void main(String[] args) {
        String str = "  Hey I'm The Coder          get     in    here please   ";
        // System.out.println(getWordCountSingle(str));
        // System.out.println(getWordCountMultiple(str));
        // System.out.println(getWordCountUsingSplit(str));
        // System.out.println(getWordCountBack(str));
        System.out.println(getWordCountFront(str));
    }

    /*
     * No trailing and forward spaces are allowed
     * Only Single spaces allowed
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static int getWordCountSingle(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                count++;
        }
        return ++count;
    }

    /*
     * No trailing and forward spaces are allowed
     * Multiple spaces allowed between words
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static int getWordCountMultiple(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ')
                count++;
        }
        return ++count;
    }

    /*
     * Trailing and forward spaces are allowed
     * Multiple spaces allowed between words
     * 
     * Iterate over string and check if any letter has space next to it,
     * If so increment count
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static int getWordCountBack(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                // Check if we are at last index and it is a letter , if so increment count
                if (i == str.length() - 1) {
                    count++;
                } else {
                    if (str.charAt(i + 1) == ' ') {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    /*
     * Trailing and forward spaces are allowed
     * Multiple spaces allowed between words
     * 
     * Iterate over string and check if any letter has space before to it,
     * If so increment count
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static int getWordCountFront(String str) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                // Check if we are at 0 th index and it is a letter , if so increment count
                if (i == 0) {
                    count++;
                } else {
                    if (str.charAt(i - 1) == ' ') {
                        count++;
                    }
                }
            }
        }

        return count;
    }


    /*
     * Using split method of String
     * 
     * Time Complexity : O(n)
     * Space Compexity : O(1)
     */
    static int getWordCountUsingSplit(String str) {
        int count = 0;

        String[] strArr = str.split(" ");
        for (String s : strArr) {
            if (s.length() > 0) {
                count++;
            }
        }

        return count;
    }
}
