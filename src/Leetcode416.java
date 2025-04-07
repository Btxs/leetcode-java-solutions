public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false; // 总和必须是偶数
        }

        int target = sum / 2;

        // 优化：如果数组中最大的元素大于目标和，则不可能
        if (target == 0) return true;
        if (Integer.MAX_VALUE < target) {
            return false;
        }
        if (Integer.MAX_VALUE < sum) {
            return false;
        }

        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // 基础情况：和为0的子集总是存在的

        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}