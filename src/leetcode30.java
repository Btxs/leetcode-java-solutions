import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode30 {
    /**
     * Substring with Concatenation of All Words
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words.length == 0 || words[0] == null || words[0].isEmpty()) return result;

        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> map = new HashMap<>();
            boolean flag = true;

            for (int j = 0; j < words.length; j++) {
                int k = i + j * wordLength;
                String temp = s.substring(k, k + wordLength);

                if (!map.containsKey(temp)) map.put(temp, 1);
                else map.put(temp, map.get(temp) + 1);

                if (map.get(temp) > 1) flag = false;
            }

            if (flag) {
                result.add(i);
            }
        }

        return result;
    }
}
