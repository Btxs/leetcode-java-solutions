public class Leetcode162 {
    /**
     * Find Peak Element
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // If the middle element is greater than its next neighbor
                // then the peak must be on the left side of the middle
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
