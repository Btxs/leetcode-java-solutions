public class leetcode26 {

    /**
     * Remove Duplicates from Sorted Array
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // Initialize count to keep track of unique elements
        int count = 0;
    
        // Iterate over the input array and check for duplicates
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[count++] = nums[i];
            }
        }
    
        // Return the number of unique elements in the array
        return count;
    }    
}
