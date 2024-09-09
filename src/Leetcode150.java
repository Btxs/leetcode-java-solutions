import java.util.Stack;

public class Leetcode150 {
    /**
     * Evaluate Reverse Polish Notation
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop two operands from the stack
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                // Perform the operation and push the result back into stack
                switch(token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        // Truncate towards zero
                        stack.push(operand1 / operand2);
                        break;
                }
            } else {
                // Push result onto stack
                stack.push(Integer.parseInt(token));
            }
        }
        // The final result is the only element in stack
        return stack.pop();
    }
}
