package org.boss.strings;

public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome4(s));
    }

    /*
     * Brute-force approaach
     * Reverse the string and check if both are equal or not
     *
     * 
     * Time Complexity : O(n^2 + n) -> O(n^2)
     * Space Complexity : O(n)
     */
    static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        String ns = s.replaceAll(
                "[^a-zA-Z0-9]", "");
        ns = ns.toLowerCase();

        String rev = "";
        int n = ns.length() - 1;
        for (int i = n; i >= 0; i--) {
            rev += ns.charAt(i);
        }
        return ns.equals(rev);
    }

    /*
     * Another approaach
     * Check for i (th) and n - i (th) position char is same or not where n is
     * s.length() - 1 using for loop
     *
     * 
     * Time Complexity : O(n^2 + n) -> O(n^2)
     * Space Complexity : O(n)
     */
    static boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return false;
        }
        String ns = s.replaceAll(
                "[^a-zA-Z0-9]", "");
        ns = ns.toLowerCase();

        int n = ns.length() - 1;
        for (int i = 0; i <= n / 2; i++) {
            if (ns.charAt(i) != ns.charAt(n - i)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Optimal approaach
     * Take two pointers start = 0 and end = n - 1 where n is s.length()
     * Check if char at start and last are equal if so then it is palindrome
     * otherwise it is not palindrome
     *
     * 
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    static boolean isPalindrome3(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char firstLet = s.charAt(start);
            char lastLet = s.charAt(end);
            if (!Character.isLetterOrDigit(firstLet))
                start++;
            else if (!Character.isLetterOrDigit(lastLet))
                end--;
            else {
                if (Character.toLowerCase(firstLet) != Character.toLowerCase(lastLet)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    static boolean isPalindrome4(String s) {
        if (s.isEmpty())
            return false;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }

        int start = 0, end = sb.length() - 1;
        while (start < end) {
            if (sb.charAt(start) != sb.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
