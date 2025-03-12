import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode3305 {
    public int countAtLeast(String word, int k) {
        int length = word.length();

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int result = 0;
        int consonants = 0;
        int j = 0;
        Map<Character, Integer> occur = new HashMap<>();
        for (int i = 0; i < length - 4; i++) {
            while(j < length && (consonants < k || occur.size() < 5)) {
                char ch = word.charAt(j);
                if (vowels.contains(ch)) {
                    occur.put(ch, occur.getOrDefault(ch, 0) + 1);
                } else {
                    consonants++;
                }
                j++;
            }
            if (consonants >= k && occur.size() == 5) {
                result += length - j + 1;
            }
            char left = word.charAt(i);
            if (vowels.contains(left)) {
                occur.put(left, occur.get(left) - 1);
                if (occur.get(left) == 0) {
                    occur.remove(left);
                }
            } else {
                consonants--;
            }
        }
        return result;
    }

    public int countOfSubstrings(String word, int k) {
        // 调用 count_at_least_k(k) 和 count_at_least_k(k+1)，计算它们的差值，得到恰好包含 k 个辅音字母的子字符串数目。
        return countAtLeast(word, k) - countAtLeast(word, k + 1);
    }
}
