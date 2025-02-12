public class Leetcode1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int left = 0;
        int right = mx;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int maxOperations, int mid) {
        long cnt = 0;
        for (int x : nums) {
            cnt += (x - 1) / mid;
        }
        return cnt <= maxOperations;
    }
}
