public class leetcode1732 {
    // Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int currentHeight = 0;
        int maxHeight = 0;
        for (int i : gain) {
            currentHeight += i;
            maxHeight = Math.max(maxHeight, currentHeight);
        }
        return maxHeight;
    }
}
