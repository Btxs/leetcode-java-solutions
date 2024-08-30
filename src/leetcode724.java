public class leetcode724 {
    // Find Pivot Index
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (leftSum == totalSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
            totalSum -= nums[i];
        }
        return -1;
    }
}
