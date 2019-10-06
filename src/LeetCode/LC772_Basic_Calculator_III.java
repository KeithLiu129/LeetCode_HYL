package LeetCode;

import java.util.LinkedList;

//772. Basic Calculator III
//https://leetcode.com/problems/basic-calculator-iii/submissions/

public class LC772_Basic_Calculator_III {
    public int calculator(String s) {
        if(s == null || s.length() == 0) return 0;

        LinkedList<Integer> nums = new LinkedList<>();
        LinkedList<Character> ops = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') continue;

            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = 10 * num + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.offerFirst(num);
            }else if(isOperand(c)) {
                if(nums.isEmpty()) nums.offerFirst(0);
                while(!ops.isEmpty() && hasPriority(c, ops.peekFirst())) {
                    nums.offerFirst(operate(ops.pollFirst(), nums.pollFirst(), nums.pollFirst()));
                }
                ops.offerFirst(c);
            }else if(c == '(') {
                if(s.charAt(i + 1) == '-') nums.offerFirst(0);
                ops.offerFirst(c);
            }else if(c == ')') {
                while(!ops.isEmpty() && ops.peekFirst() != '(') { //??? TODO
                    nums.offerFirst(operate(ops.pollFirst(), nums.pollFirst(), nums.pollFirst()));
                }
                ops.pollFirst();
            }
        }
        while(!ops.isEmpty()) {
            nums.offerFirst(operate(ops.pollFirst(), nums.pollFirst(), nums.pollFirst()));
        }

        return nums.pollFirst();
    }

    private boolean isOperand(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private boolean hasPriority(char c1, char c2) {
        if(c2 == '(' || c2 == ')') return false;
        return !((c1 == '*' || c1 == '/') && (c2 == '+' || c2 == '-'));
    }

    private int operate(char c, int i1, int i2) {
        switch(c) {
            case '+' : return i2 + i1;
            case '-' : return i2 - i1;
            case '*' : return i2 * i1;
            case '/' : return i2 / i1;
        }
        return 0;
        //TODO recursion
    }
}
