public class Leetcode2241 {
    private int[] banknotes;
    private int[] denominations = {20, 50, 100, 200, 500};

    public Leetcode2241() {
        // Initialize with all zeros, representing initial count of each denomination
        banknotes = new int[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotes.length; i++) {
            this.banknotes[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] result = new int[5];
        if (amount <= 0) {
            return new int[] {-1};
        }
        // Sort denominations in descending order to prioritize larger bills
        for (int i = denominations.length - 1; i >= 0; i--) {
            result[i] = (int) Math.min(banknotes[i], amount / denominations[i]);
            amount -= result[i] * denominations[i];
        }
        // If the full amount could not be withdrawn, return -1 for all denominations
        if (amount != 0) {
            for (int i = 0; i < result.length; i ++) {
                banknotes[i] += result[i];
            }
            return new int[] {-1};
        }
        for (int i = 0; i < result.length; i ++) {
            banknotes[i] -= result[i];
        }
        return result;
    }
}
