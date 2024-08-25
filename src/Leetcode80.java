public class Leetcode80 {
    /**
     * Remove Duplicates from Sorted Array II
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // Initialize count to keep track of unique elements
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < 2 || nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
