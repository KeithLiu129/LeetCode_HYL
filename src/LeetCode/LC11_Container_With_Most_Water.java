package LeetCode;

public class LC11_Container_With_Most_Water {
    public int maxArea(int[] height){
        if (height == null || height.length == 0) return 0;
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int area = (end - start) * Math.min(height[start], height[end]);
            maxArea = Math.max(maxArea, area);
            if (height[start] > height[end]) {
                end--;
            }else {
                start++;
            }
        }

        return maxArea;
    }
}
