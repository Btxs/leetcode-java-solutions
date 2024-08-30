public class leetcode283 {
    // Move Zeroes
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0; // 记录非零元素的位置

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }

        while (nonZeroIndex < nums.length) { // 将剩余位置填充为零
            nums[nonZeroIndex++] = 0;
        }
    }
}
