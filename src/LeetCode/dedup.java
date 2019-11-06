package LeetCode;

public class dedup {
    public static String dedupWithZeroLeft(String s) {
        if (s == null || s.length() <= 1) return s;

        char[] array = s.toCharArray();
        int slow = 0;
        boolean flag = false;

        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[fast - 1]) {
                if (flag == true) {
                    array[slow] = array[fast];
                    flag = false;
                }else {
                    slow++;
                }
            }else {
                flag = true;
            }
        }
        if (flag == true) slow--;
        return new String(array, 0, slow + 1);
    }

    public static void main(String[] args) {
        String s1 = new String("baavada");
        String sol1 = dedup.dedupWithZeroLeft(s1);

        System.out.println(sol1);


    }

}
