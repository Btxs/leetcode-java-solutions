import java.util.Arrays;

public class Leetcode2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        // Sort the special floors
        Arrays.sort(special);

        // Initialize the result with the distance from bottom to the first special floor
        int res = special[0] - bottom;
        
        // Calculate the maxium consecutive non-special floors between each pair of special floors
        for (int i = 1; i < special.length; i++){
            res = Math.max(res, special[i] - special[i-1] - 1);
        }

        // Consider the distance from the last special floor to the top
        res = Math.max(res, top - special[special.length-1]);

        return res;
    }
}
