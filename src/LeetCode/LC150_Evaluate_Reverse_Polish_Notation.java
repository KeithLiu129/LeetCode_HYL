package LeetCode;

//150. Evaluate Reverse Polish Notation
//https://leetcode.com/problems/evaluate-reverse-polish-notation/submissions/

import java.util.LinkedList;

public class LC150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        LinkedList<Integer> nums = new LinkedList<>();
        for(String s : tokens) {
            if(isOperand(s)) {
                    nums.offerFirst(operate(s, nums.pollFirst(), nums.pollFirst()));
            }else {
                int num = Integer.parseInt(s);
                nums.offerFirst(num);
            }
        }

        return nums.pollFirst();
    }

    private boolean isOperand(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    private int operate(String s, int i1, int i2) {
        switch (s) {
            case "+" : return i2 + i1;
            case "-" : return i2 - i1;
            case "*" : return i2 * i1;
            case "/" : return i2 / i1;
        }
        return 0;
    }
}
