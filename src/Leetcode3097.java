public class Leetcode3097 {
    public int minimumSuarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int rightOr = 0;
        int bottom = 0;
        
        for (int right = 0; right < nums.length; right++) {
            rightOr |= nums[right];
            while (left <= right && (nums[left] | rightOr) >= k) {
                ans = Math.min(ans, right - left + 1);
                left++;
                if (bottom < left) {
                    for (int i = right - 1; i >= left; i--) {
                        nums[i] |= nums[i+1];
                    }
                    bottom = right;
                    rightOr = 0;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
