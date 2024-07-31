import java.util.Stack;

public class leetcode2390 {
    // Removing Stars From a String
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '*') {
                // 如果当前字符和栈顶元素都是星号，则移除栈顶元素
                stack.pop();
            } else {
                // 否则，将当前字符压入栈中
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();  // 将结果反转以得到正确的顺序
    }

    public String removeStars2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!stringBuilder.isEmpty() && c == '*') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
