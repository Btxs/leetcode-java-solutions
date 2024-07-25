import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class leetcode151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        List<String> list = new ArrayList<>();
        for (String word : s.trim().split("\\\\s+")) {
            if (!word.isEmpty()) {
                list.add(word);
            }
        }
        Collections.reverse(list);
        return String.join(" ", list);
    }

    public String reverseWords2(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (stringBuilder.length() != 0 && c == ' ') {
                deque.offerFirst(stringBuilder.toString());
                stringBuilder.setLength(0);
            } else if (c != ' ') {
                stringBuilder.append(c);
            }
            left++;
        }
        deque.offerFirst(stringBuilder.toString());
        return String.join(" ", deque);
    }
}