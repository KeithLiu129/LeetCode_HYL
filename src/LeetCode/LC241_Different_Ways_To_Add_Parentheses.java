package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 *
 * Given a string of numbers and operators, return all possible results from
 * computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 */
public class LC241_Different_Ways_To_Add_Parentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) throw new IllegalArgumentException();
        return dfs(input, 0, input.length());
    }

    private List<Integer> dfs(String s, int start, int end){
        List<Integer> res = new ArrayList<>();
        boolean isSingleNum = true;
        for (int i = 0; i < end; i++) {
            char c = s.charAt(i);
            if (isOperator(c)) {
                List<Integer> left = dfs(s, start, i - 1);
                List<Integer> right = dfs(s, i + 1, end);
                res.add(calculate(left, right, c));
                isSingleNum = false;
            }
        }
        if (isSingleNum) res.add(Integer.valueOf(s));
        return res;
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*') return true;
        return false;
    }

    private int calculate (List<Integer> a, List<Integer> b, char c) {
        switch (c) {
            case '+':
                return a.get(0) + b.get(0);
            case '-':
                return a.get(0) - b.get(0);
            case '*':
                return a.get(0) * b.get(0);
        }
        return 0;
    }
}
