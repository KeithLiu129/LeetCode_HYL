package LeetCode;

//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/

public class LC151_Reverse_Words_In_A_String {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");

        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                if(sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(array[i]);
            }

        }
        return sb.toString();
    }
}
