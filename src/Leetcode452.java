import java.util.Arrays;
import java.util.Comparator;

public class Leetcode452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        
        int count = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        
        return count;
    }
}
