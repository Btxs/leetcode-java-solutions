public class leetcode1004 {
    // Max Consecutive Ones III
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int cntZero = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                ++cntZero;
            }
            while (cntZero > k) {
                if (nums[left] == 0) {
                    --cntZero;
                }
                left++;
            }
            res = Math.max(res, right - left +1);
            ++right;
        }
        return res;
    }
}
