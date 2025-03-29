public class Leetcode2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = -1;
        int curTime = -1;
        int[] visTime = new int[n];
        for (int i = 0; i < n; i++) {
            int x = i;
            int startsTime = curTime;
            while (x != -1 && visTime[x] == 0) {
                visTime[x] = curTime++;
                x = edges[x];
            }
            if (x != -1 && visTime[x] >= startsTime) {
                ans = Math.max(ans, curTime - visTime[x]);
            }
        }
        return ans;
    }
}
