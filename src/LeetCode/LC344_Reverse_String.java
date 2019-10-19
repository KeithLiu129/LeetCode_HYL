package LeetCode;

//344. Reverse String
//https://leetcode.com/problems/reverse-string/

public class LC344_Reverse_String {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            swap(s, start++, end--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
