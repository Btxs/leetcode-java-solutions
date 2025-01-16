public class Leetcode3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;

        // Iterate over all possible starting points of subarrays
        for (int start = 0; start < n; start++) {
            int currentOr = 0;

            // Iterate over all possible ending points of subarrays
            for (int end = start; end < n; end++) {
                // Update the OR value with the current element
                currentOr |= nums[end];

                // Check if the current OR value is at least k
                if (currentOr >= k) {
                    // Calculate the length of the current subarray
                    int length = end - start + 1;
                    // Update minLength if a shorter special subarray is found
                    minLength = Math.min(minLength, length);
                }
            }
        }

        // If no valid subarray was found, return -1; otherwise, return the minimum length found
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }
}
