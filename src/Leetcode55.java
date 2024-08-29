public class Leetcode55 {
    /**
     * Jump Game
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0;i < nums.length - 1 ; i++) {
            max = Math.max(max, i + nums[i]);
            if (max <= i) return false;
        }
        return true;
    }
}
