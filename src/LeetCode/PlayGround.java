package testing;

public class PlayGround {
    public static void main(String[] args) {
        /*int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int[] arr1 = Arrays.copyOf(arr, 6);
        int[] arr2 = arr.clone();

        arr[0] = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i]);
        }


        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
        */
        Solution sol = new Solution();
        String s = " 6-4 / 2 ";
        int x = sol.calculate(s);
        System.out.println(x);

    }
}
