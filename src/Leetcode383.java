import java.util.HashMap;
import java.util.Map;

public class Leetcode383 {
    /**
     * Ransom Note
     * @param ransomNote the string that needs to be formed
     * @param magazine the string from which characters will be borrowed
     * @return true if the characters in ransomNote can be formed using the letters of magazine, false otherwise
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        // Populate the hash map with the frequency of each character in magazine
        for (char c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        // Check if each character in ransomNote can be formed using the characters in magazine
        for (char c : ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c) || magazineMap.get(c) == 0) {
                return false;
            } else {
                magazineMap.put(c, magazineMap.get(c) - 1);
            }
        }
        // If we've made it through all characters without returning false, then ransomNote can be formed using magazine
        return true;
    }

    public static void main(String[] args) {
        Leetcode383 leetcode383 = new Leetcode383();
        System.out.println(leetcode383.canConstruct("a", "b")); // false
        System.out.println(leetcode383.canConstruct("aa", "ab")); // false
        System.out.println(leetcode383.canConstruct("aa", "aab")); // true
    }
}
