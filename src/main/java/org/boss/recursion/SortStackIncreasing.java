package org.boss.recursion;
import java.util.Stack;

public class SortStackIncreasing {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(2);
        s.push(8);
        s.push(4);

        sort(s);

        while(s.size() > 0){
            System.out.println(s.pop());
        }

    }

    static Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;
    }

    static void sortStack(Stack<Integer> s) {
        if (s.size() == 0)
            return;
        int top = s.pop();
        sort(s);
        insert(s, top);
    }

    static void insert(Stack<Integer> s, int ele) {
        Stack<Integer> tmp = new Stack<>();
        while (s.size() > 0 && s.peek() < ele) {
            tmp.push(s.pop());
        }

        s.push(ele);

        while (tmp.size() > 0) {
            s.push(tmp.pop());
        }
    }
}
