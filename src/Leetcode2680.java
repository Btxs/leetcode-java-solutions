public class Leetcode2680 {
    public long maximumOr(int[] nums, int k) {
        long orSum = 0, multiBits = 0;
        for (int num : nums) {
            multiBits |= num & orSum;
            orSum |= num;
        }
        long res = 0;
        for (int num : nums) {
            res = Math.max(res, (orSum ^ num) | ((long) num << k) | multiBits);
        }
        return res;
    }
}
