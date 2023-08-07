package org.boss.maths;

public class GCD {
    public static void main(String[] args) {
        int a = 16, b = 80;
        System.out.println(gcd2(a, b));
    }

    static int gcd(int a, int b) {
        int ans = 1;
        int i = 1;
        while (i <= Math.min(a,b)) {
            if (a % i == 0 && b % i == 0) {
                ans = i;
            }
            i++;
        }
        return ans;
    }
    static int gcd2(int a, int b){
        System.out.println(Math.floorMod(-8,7));
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        while(a != b){
            if(a >b){
                a = a- b;
            }else{
                b = b - a;
            }
        }
        return a;
    }
    static int gcdIterative(int a, int b) {
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    static int gcdRecursive(int a, int b) {
        if(b == 0)
            return a;
        return gcdRecursive(b, a % b);
    }
}
