import java.util.Stack;

public class leetcode394 {
    // Decode String
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> results = new Stack<>();
        StringBuilder currentResult = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                counts.push(count);
                results.push(currentResult);
                currentResult = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder temp = currentResult;
                currentResult = results.pop();
                int times = counts.pop();
                for (int i = 0; i < times; i++) {
                    currentResult.append(temp);
                }
            } else {
                currentResult.append(c);
            }
        }
        return currentResult.toString();
    }
}
