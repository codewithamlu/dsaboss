package org.boss.recursion;

public class Increasing {
    public static void main(String[] args) {
        increasing(5);
    }
    static void increasing(int n){
        if(n==0)
            return;
        increasing(n-1);
        System.out.println(n);
    }
}
