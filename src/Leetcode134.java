public class Leetcode134 {
    /**
     * Gas Station
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;

        int start = 0, curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                // 当前起始点无法到达下一个点，更新起始点为下一个点，并将当前sum清零
                start = i + 1;
                curSum = 0;
            }
        }

        return start;
    }
}
