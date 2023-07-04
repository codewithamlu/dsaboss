package org.boss.recursionchoices;

import java.util.ArrayList;
import java.util.List;

public class PathsFromStair {
    public static void main(String[] args) {

    }

    static List<List<Integer>> paths(int n) {
        if (n == 1) {
            List<List<Integer>> baseRes = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            baseRes.add(tmp);
            return baseRes;
        }
        if (n <= 0) {
            return new ArrayList<>();
        }

        // P(n) = P(n - 1) + P(n - 2) + P(n - 3)
        List<List<Integer>> n1 = paths(n - 1);
        List<List<Integer>> n2 = paths(n - 2);
        List<List<Integer>> n3 = paths(n - 3);

        List<List<Integer>> res = new ArrayList<>();

        // add 1
        for (List<Integer> list : n1) {
            list.add(0, 1);
            res.add(list);
        }
        // add 2
        for (List<Integer> list : n1) {
            list.add(0, 2);
            res.add(list);
        }
        // add 3
        for (List<Integer> list : n1) {
            list.add(0, 3);
            res.add(list);
        }

        return res;
    }
}
