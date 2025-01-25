public class Leetcode2412 {
    public long minimumMoney(int[][] transactions) {
        long maxCost = 0;
        long totalLose = 0;
        
        for (int[] transaction : transactions) {
            totalLose += Math.max(transaction[0] - transaction[1], 0);
            maxCost = Math.max(maxCost, Math.min(transaction[0], transaction[1]));
        }
        
        // The minimum initial money required is the maximum net loss encountered
        return maxCost + totalLose;
    }
}
