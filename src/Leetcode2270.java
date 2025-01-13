public class Leetcode2270 {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            totalSum += num;
        }
        
        long runningSum = 0;
        int validPartitionCount = 0;
        
        // Iterate through the array to find valid partitions
        for (int i = 0; i < n - 1; i++) {
            runningSum += nums[i];
            long remainingSum = totalSum - runningSum;
            
            if (runningSum >= remainingSum) {
                validPartitionCount++;
            }
        }
        
        return validPartitionCount;
    }
}