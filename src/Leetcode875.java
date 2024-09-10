public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            // Check Koko can eat all bananas within h hours using canEatAll method
            if (canEatAll(piles, mid, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // find the minimum integer k that allows Koko to eat all bananas within h hours.
    private boolean canEatAll(int[] piles, int k, int h) {
        long totalBananas = 0;
        for (int pile : piles) {
            totalBananas += Math.ceil((double) pile / k);
        }
        return totalBananas <= h;
    }

    public static void main(String[] args) {
        Leetcode875 solution = new Leetcode875();

        int[] piles1 = {3, 6, 7, 11};
        System.out.println(solution.minEatingSpeed(piles1, 8)); // Output: 4

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println(solution.minEatingSpeed(piles2, 5)); // Output: 30
    }
}
