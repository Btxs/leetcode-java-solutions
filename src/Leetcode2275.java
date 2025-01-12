import java.util.ArrayList;
import java.util.List;

public class Leetcode2275 {
    public int largestCombination(int[] candidates) {
        int maxLength = 0;
        
        // Iterate over each bit position from 0 to 26
        for (int bit = 0; bit < 27; bit++) {
            int count = 0;
            
            // Count how many numbers have the current bit set
            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }
            
            // If there are any numbers with this bit set, update maxLength
            if (count > 0) {
                maxLength = Math.max(maxLength, count);
            }
        }
        
        return maxLength;
    }
}
