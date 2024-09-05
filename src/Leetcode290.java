import java.util.Map;
import java.util.HashMap;

public class Leetcode290 {
    /**
     * Word Pattern
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) return false;
        
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (!map1.containsKey(c) && !map2.containsKey(word)) {
                map1.put(c, word);
                map2.put(word, c);
            } else if (map1.get(c) != null && map1.get(c).equals(word) 
                       && map2.get(word) != null && map2.get(word).equals(c)) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        Leetcode290 solution = new Leetcode290();
        
        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // false
    }
}
