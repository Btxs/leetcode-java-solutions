import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    /**
     * Isomorphic Strings
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (!map.containsKey(c1)) {
                // If the character in string s is not mapped yet
                if (map.containsValue(c2)) return false;
                map.put(c1, c2); // Map the character to its corresponding value
            } else if (map.get(c1) != c2) {
                // If the character in string s has been mapped before and it's different from the current mapping
                return false;
            }
        }

        return true; // If we have checked all characters and haven't returned false, then they are isomorphic
    }

    public static void main(String[] args) {
        Leetcode205 solution = new Leetcode205();
        System.out.println(solution.isIsomorphic("egg", "add"));  // Expected output: true
        System.out.println(solution.isIsomorphic("foo", "bar"));  // Expected output: false
        System.out.println(solution.isIsomorphic("paper", "title"));  // Expected output: true
    }
}
