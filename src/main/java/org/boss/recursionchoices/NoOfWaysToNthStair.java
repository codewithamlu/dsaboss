package org.boss.recursionchoices;

public class NoOfWaysToNthStair {
    public static void main(String[] args) {

    }

    public long nthStair(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        long n1 = nthStair(n - 1);
        long n2 = nthStair(n - 2);

        return n1 + n2;
    }
}
