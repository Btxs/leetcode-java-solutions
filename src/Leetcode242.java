import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode242 {
    /**
     * Valid Anagram
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        return Arrays.equals(sArray, tArray);
    }

    /**
     * Use HashMap solve this problem
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0) - 1;
            if (count < 0) return false;
            map.put(c, count);
        }
        
        return true;
    }

    public static void main(String[] args) {
        Leetcode242 solution = new Leetcode242();
    
        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car")); // false

        System.out.println(solution.isAnagram2("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram2("rat", "car")); // false
    }
}
