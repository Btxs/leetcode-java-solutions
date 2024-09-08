import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {
    /**
     * Longest Consecutive Sequence
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        // Add all elements from the input array into the set
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        // Iterate over each number in the set
        for (Integer num :numSet) {
            // Check start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
