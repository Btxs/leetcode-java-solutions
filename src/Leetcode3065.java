public class Leetcode3065 {
    public int minOperations(int[] nums, int k) {
        int count = 0;

        // Iterate through each element in the array
        for (int num : nums) {
            // If the current element is less than k, increment the count
            if (num < k) {
                count++;
            }
        }
        
        // The count represents the minimum number of operations needed
        return count;
    }
}
