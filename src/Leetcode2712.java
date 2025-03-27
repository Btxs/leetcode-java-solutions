public class Leetcode2712 {
    public long minimumCost(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i - 1] != chars[i]) {
                ans += Math.min(i, n - i);
            }
        }
        return ans;
    }
}
