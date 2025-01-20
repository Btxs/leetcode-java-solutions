public class Leetcode2239 {
    public int findClosestNumber(int[] nums) {
        // Initialize closest with a large number
        int closest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (Math.abs(num) < Math.abs(closest) || Math.abs(num) == Math.abs(closest) && num > 0) {
                closest = num;
            }
        }
        return closest;
    }

    public int findClosestNumber2(int[] nums) {
        // Initialize closest with a large number and minDistance to a very high value
        int closest = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;

        for (int num : nums) {
            int distance = Math.abs(num);
            if (distance < minDistance) {
                closest = num;
                minDistance = distance;
            } else if (distance == minDistance) {
                // If the distance is equal, choose the number with a larger value
                closest = Math.max(closest, num);
            }
        }

        return closest;
    }
}
