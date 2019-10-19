package LeetCode;

//186. Reverse Words in a String II
//https://leetcode.com/problems/reverse-words-in-a-string-ii/

public class LC186_Reverse_Words_In_A_String_II {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) return;

        reverseArr(s);
        reverseWord(s);
    }

    private void reverseWord(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') {
                int j = i + 1;
                while (j < s.length && s[j] != ' ') {
                    j++;
                }
                int left = i, right = j - 1;

                while (left < right) {
                    swap(s, left++, right--);
                }
                i = j;
            }

        }
    }

    private void reverseArr(char[] s) {
        int left = 0, right = s.length - 1;

        while (left < right) {
            swap(s, left++, right--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
