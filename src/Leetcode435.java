import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length ==0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        // At least need one interval
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= end) {
                // Can be used to erase the interval
                count++;
                end = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
