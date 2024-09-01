public class leetcode1493 {
    // Longest Subarray of 1's After Deleting One Element
    public int longestSubarray(int[] nums) {
        if (nums == null || nums.length <= 2) return nums != null && nums.length >= 2 ? nums.length - 1 : 0;
        int maxLen = 0;
        int zeroCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;
            while (zeroCount > 1) {
                if (nums[left++] == 0) zeroCount--;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
