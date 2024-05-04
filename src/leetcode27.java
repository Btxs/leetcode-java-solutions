public class leetcode27 {
    /**
     * Remove Element
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // Initialize count to keep track of the current index in the array where we should start inserting the next unique element
        int count = 0;
    
        // Iterate over the input array and for each element, check if it is equal to val
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                // If the current element is not equal to val, then insert it at index count
                nums[count++] = nums[i];
            }
        }
    
        // Return the number of elements in nums which are not equal to val
        return count;
    }
}
