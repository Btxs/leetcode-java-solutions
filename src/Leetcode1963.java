public class Leetcode1963 {
    public int minSwaps(String s) {
        int unmatched = 0;
        int swaps = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                unmatched++;
            } else {
                if (unmatched > 0) {
                    unmatched--;
                } else {
                    swaps++;
                }
            }
        }
        return (swaps + 1) / 2;
    }
}
