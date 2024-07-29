import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode1657 {
    // Determine if Two Strings Are Close
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (Arrays.equals(sort(word1.toCharArray()), sort(word2.toCharArray()))) {
            return true;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (map1.keySet().equals(map2.keySet()) && 
            Arrays.equals(sort(map1.values().stream().mapToInt(Integer::intValue).toArray()), 
            sort(map2.values().stream().mapToInt(Integer::intValue).toArray()))) {
                return true;
        }
        return false;
    }

    private char[] sort (char[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    private int[] sort (int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    public boolean closeStrings2(String word1, String word2) {
        int[] wordCounter1 = new int[26], wordCounter2 = new int[26];
        for (char c : word1.toCharArray()) {
            wordCounter1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            wordCounter2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCounter1[i] > 0 && wordCounter2[i] == 0 || wordCounter1[i] == 0 && wordCounter2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(wordCounter1);
        Arrays.sort(wordCounter2);
        return Arrays.equals(wordCounter1, wordCounter2);
    }
}
