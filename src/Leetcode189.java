public class Leetcode189 {
    /**
     * Rotate Array
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int t = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, t - 1);
        swap(nums, t, nums.length - 1);
    }

    public void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
