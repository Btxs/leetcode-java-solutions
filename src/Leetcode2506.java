import java.util.HashMap;
import java.util.Map;

public class Leetcode2506 {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            map.put(mask, map.getOrDefault(mask, 0) + 1);
        }
        
        int result = 0;
        for (int count : map.values()) {
            if (count >= 2) {
                result += count * (count - 1) / 2;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Leetcode2506 solution = new Leetcode2506();
        String[] words = {"aba","aabb","abcd","bac","aabc"};
        System.out.println(solution.similarPairs(words));
    }
}
