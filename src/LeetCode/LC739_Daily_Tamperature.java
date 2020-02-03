package LeetCode;

import java.util.Stack;

public class LC739_Daily_Tamperature {
    public int[] dailyTemperature(int[] T) {
    int[] res = new int[T.length];
    Stack<Integer> stack = new Stack<>();
        for (int i= 0; i < T.length; i++) {
        int cur = T[i];
        while(!stack.isEmpty() && T[stack.peek()] < cur) {
            res[stack.peek()] = i - stack.peek();
            stack.pop();
        }
        stack.push(i);
    }

        return res;
    }
}
