package testing;


import java.util.*;

class Solution {
    public static void main(String[] args) {
        String test1 = "aaabbbaabbcc";
        System.out.println("The expected res is ababc : " + removeDup(test1));
    }

    public static String removeDup(String  s){
        if(s == null ||s.length() == 0)  return "";
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i-1) == s.charAt(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}





