public class leetcode11 {
     public int maxArea(int [] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            max = Math.max(min * (right - left), max);
            while (left < right && min >= height[left]) {
                left++;
            }
            while (left < right && min >= height[right]) {
                right--;
            }
        }
        return max;
     }
}
