import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode56 {
    /**
     * Merge Intervals
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        
        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= currentInterval[1]) {
                // Overlapping intervals, merge them by updating the end of the current interval
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Non-overlapping interval, add the current interval to the result and update currentInterval
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        
        // Add the last interval to the result
        result.add(currentInterval);
        
        return result.toArray(new int[result.size()][]);
    }
}
