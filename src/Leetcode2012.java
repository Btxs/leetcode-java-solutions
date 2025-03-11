public class Leetcode2012 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        // 寻找最大值和最小值
        int rightMin = nums[n - 1];
        int leftMax = nums[0];

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        // 顺序遍历数组寻找左侧的最大值
        for (int i = 1; i <= n - 2; i++) {
            leftMax = Math.max(leftMax, nums[i - 1]);
            prefix[i] = nums[i] - leftMax;
        }
        // 逆序遍历数组寻找右侧的最小值
        for (int i = n - 2; i >= 1; i--) {
            rightMin = Math.min(rightMin, nums[i + 1]);
            suffix[i] = rightMin - nums[i];
        }
        int ans = 0;
        for (int i = 1; i <= n - 2; ++i) {
            if (prefix[i] > 0 && suffix[i] > 0) {
                ans += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}