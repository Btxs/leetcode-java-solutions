import java.util.Arrays;

public class Leetcode3375 {
    public int minOperations(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        if (k > min) {
            return -1;
        }
        int distinctCount = (int) Arrays.stream(nums).distinct().count();
        return distinctCount - (k == min ? 1 : 0);
    }
}
