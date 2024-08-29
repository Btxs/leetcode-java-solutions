public class Leetcode134 {
    /**
     * Gas Station
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startPosition = -1;
        for (int i = 0; i <= gas.length - 1; ++i) {
            totalSum += gas[i] - cost[i];
            if (maxSum < totalSum) {
                maxSum = totalSum;
                startPosition = i;
            }
        }
        return (totalSum >= 0) ? startPosition : -1;
    }
}
