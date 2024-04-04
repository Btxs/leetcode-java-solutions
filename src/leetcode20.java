import java.util.Stack;

public class leetcode20 {
    /**
     * Valid Parentheses
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char t;
        for (char c : s.toCharArray()) {
            // If the current character is a opening parenthesis, push it to the stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // If the current character is a cloing parenthesis, and the stack is not empty, pop and check the top element from the stack
                if (!stack.isEmpty()) {
                    t = stack.pop();
                } else {
                    return false;
                }
                if (c == ')' && t != '(' || c == ']' && t != '[' || c == '}' && t != '{') {
                    return false;
                }
            }
        }
        // If the stack is not empty, it means there are more opening parentheses than closing ones, so return false
        return stack.isEmpty();
    }
}
