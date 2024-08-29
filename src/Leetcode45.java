public class Leetcode45 {
    /**
     * Jump Game II
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int maxPos = 0;
        int step = 0;
        int currentEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == currentEnd) {
                step++;
                currentEnd = maxPos;
                if (currentEnd >= nums.length - 1) break;
            }
        }
        return step;
    }
}
