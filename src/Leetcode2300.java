import java.util.Arrays;

public class Leetcode2300 {
    /**
     * Successful Pairs of Spells and Potions
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int spellStrength = spells[i];
            // Binary search to find the first potion that makes a successful pair
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // note success is long integer
                if ((long) potions[mid] * spellStrength >= success) {
                    // If the product is greater than or equal to success, all potions with higher than strength
                    result[i] = m - mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;
        Leetcode2300 solution = new Leetcode2300();
        int[] result = solution.successfulPairs(spells, potions, success);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
