import java.util.Arrays;

public class Leetcode169 {
    /**
     * Majority Element
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
