public class Leetcode136 {
    // Single Number
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // perform XOR operation on every element of the array.
        }
        return result;
    }
}
