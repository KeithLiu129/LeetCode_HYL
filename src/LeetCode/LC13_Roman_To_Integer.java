package LeetCode;

//13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/

public class LC13_Roman_To_Integer {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = toInt(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            res += toInt(chars[i]);
            if (toInt(chars[i - 1]) < toInt(chars[i])) {
                res -= toInt(chars[i - 1]) * 2;
            }
        }
        return res;
    }

    private int toInt(char c) {
        switch (c) {
            case ('I') : return 1;

            case ('V') : return 5;

            case ('X') : return 10;

            case ('L') : return 50;

            case ('C') : return 100;

            case ('D') : return 500;

            case ('M') : return 1000;
        }
        return 0;
    }
}
