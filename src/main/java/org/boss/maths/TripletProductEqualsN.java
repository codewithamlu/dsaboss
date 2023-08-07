package org.boss.maths;

public class TripletProductEqualsN {
    public static void main(String[] args) {
        int n = 244;
        findTriplet(n);
    }
    static void findTriplet(int n){
       int a = 1, b = 1, c = 2;
       for(int i = 2; i * i < n;i++){
           if(n % i == 0){
               a = i;
               break;
           }
       }
       n = n / a;
       for(int i = 2;i * i < n;  i++){
           if(n % i == 0){
              if(i != a){
                  b = Math.min(b, i);
              }
              if(n / i != i){
                  if(n / i != a){
                      b = Math.min(b, n / i);
                  }
              }
           }
       }
       c = n / b;
       if(a !=b && b !=c && c!= 1){
           System.out.println(a+" "+b+" "+c);
       }else
           System.out.println("No combination exist");
    }
}
