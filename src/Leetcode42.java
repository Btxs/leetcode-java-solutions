public class Leetcode42 {
    /**
     * Trapping Rain Water
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]) {
                water += leftMax - height[left];
                left++;
                continue;
            } else {
                water += rightMax - height[right];
                right--;
                continue;
            }
        }
        return water;
    }
}
