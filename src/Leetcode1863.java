public class Leetcode1863 {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int x : nums) {
            or |= x;
        }
        return or << (nums.length - 1);
    }
}
