import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode17 {
    private static final Map<Character, String> DIGIT_MAP = new HashMap<>();
    static {
        DIGIT_MAP.put('2', "abc");
        DIGIT_MAP.put('3', "def");
        DIGIT_MAP.put('4', "ghi");
        DIGIT_MAP.put('5', "jkl");
        DIGIT_MAP.put('6', "mno");
        DIGIT_MAP.put('7', "pqrs");
        DIGIT_MAP.put('8', "tuv");
        DIGIT_MAP.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, String currentCombination, int index) {
        if (index == digits.length()) {
            combinations.add(currentCombination);
            return;
        }
        char digit = digits.charAt(index);
        String lettersForDigit = DIGIT_MAP.get(digit);
        for (int i = 0; i < lettersForDigit.length(); i++) {
            backtrack(combinations, digits, currentCombination + lettersForDigit.charAt(i), index + 1);
        }
    }
    
}
