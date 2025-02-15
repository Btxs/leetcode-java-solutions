import java.util.Arrays;

public class Leetcode1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canPlaceBalls(int[] position, int m, int minDistance) {
        int count = 1;
        int lastPosition = position[0];
        
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minDistance) {
                count++;
                lastPosition = position[i];
                if (count == m) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Leetcode1552 solution = new Leetcode1552();
        int[] position1 = {1, 2, 3, 4, 7};
        int m1 = 3;
        System.out.println(solution.maxDistance(position1, m1));
        
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println(solution.maxDistance(position2, m2));
    }
}
