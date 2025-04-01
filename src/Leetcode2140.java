public class Leetcode2140 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] f = new long[n + 1];
        for (int i = 0; i < n; i++) {
            f[i + 1] = Math.max(f[i + 1], f[i]);
            int[] q = questions[i];
            // 计算可以参加的问题的结束位置
            int j = Math.min(i + q[1] + 1, n);
            f[j] = Math.max(f[j], f[i] + q[0]);
        }
        return f[n];
    }
}
