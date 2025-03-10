public class Leetcode2269 {
    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int ans = 0;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int temp = Integer.parseInt(s.substring(i, i + k));
            // 如果是0，则不用判断
            if (temp == 0) {
                continue;
            }
            if (Integer.parseInt(s) % temp == 0) {
                ans++;
            }
        }
        return ans;
    }
}
