package org.boss.arrays2;

public class CountPairsAiGreaterTwiceAjTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {6,13,21,25};
        int[] b = { 1,2,3,4,4,5,9,11,13};
        System.out.println(countPairs(a,b));
    }
    // Find pairs such that we can form pair from 1st array to 2nd array -> A[i] > 2 * A[j]
    static int countPairs(int[] a, int[] b){
        int cnt = 0;
        int ri = 0;
        for(int li = 0; li < a.length; li++){
            while(ri < b.length){
                if(a[li] > 2 * b[ri])
                    ri++;
                else
                    break;
            }
            cnt += ri;
        }
        return cnt;
    }
}
