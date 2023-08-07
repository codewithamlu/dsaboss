package org.boss.maths;

public class Power {
    public static void main(String[] args) {
        int a = 5, b = 8;
        System.out.println(pow(a, b));
    }

    static int pow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) { // b % 2 != 1
                res = res * a;
            }
            a = a * a;
            b = b >> 1; // b / 2

        }
        return res;
    }


}
