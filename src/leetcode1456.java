import java.util.HashMap;
import java.util.Map;

public class leetcode1456 {
    // Maximum Number of Vowels in a Substring of Given Length
    // this is better solution, moving the window, time complexity O(n), space complexity O(1) 
    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i))!= -1) {
                count++;
            }
        }
        int res = count;
        for (int i = 0; i < s.length() - k; i++) {
            if ("aeiou".indexOf(s.charAt(i))!= -1) {
                count--;
            }
            if ("aeiou".indexOf(s.charAt(i + k))!= -1) {
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    // use static type, it will be faster
    public int maxVowels2(String s, int k) {
        Map<Character, Integer> vowelsMap = new HashMap<>();
        vowelsMap.put('a', 1);
        vowelsMap.put('e', 1);
        vowelsMap.put('i', 1);
        vowelsMap.put('o', 1);
        vowelsMap.put('u', 1);
        int n = s.length();
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (vowelsMap.containsKey(s.charAt(i))) {
                cnt += vowelsMap.get(s.charAt(i));
            }
            if (i >= k) {
                if (vowelsMap.containsKey(s.charAt(i - k))) {
                    cnt -= vowelsMap.get(s.charAt(i - k));
                }
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
