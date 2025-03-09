import java.util.Arrays;

public class Leetcode2070 {
    public int[] maxiumBeauty(int[][] items, int[] queries) {
        // 根据价格排序
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        // 预处理最大的美丽值
        int n = items.length;
        int[] prefixMax = new int[n + 1];
        prefixMax[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], items[i - 1][1]);
        }

        // 使用二分查找查询
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            // 寻找价格小于或等于query的值
            int left = 0, right = n - 1;
            int idx = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= query) {
                    idx = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (idx == -1) {
                answers[i] = 0;
            } else {
                answers[i] = prefixMax[idx + 1];
            }
        }
        return answers;
    }
}
