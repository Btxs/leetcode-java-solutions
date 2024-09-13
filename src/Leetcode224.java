import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode224 {
    /**
     * Basic Calculator
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();

        // 去掉字符串的所有空格
        s = s.replaceAll(" ", "");

        // 为了防止第一个数为负数，先往 nums 加个 0
        // 例如 -1 + 2 情况
        numStack.push(0);

        /*
         * 遍历字符串(分情况讨论):
         * 1. 如果取到 ( , 直接加入 opStack 中，等待与之匹配的 )
         * 2. 如果取到 ) , 使用现有的 numStack 和 opStack 进行计算，
         * 再弹出左括号(也就是和当前右括号相匹配的左括号)
         * 3. 如果取到一个数字, 从当前位置开始继续往后取, 将整一个连续数字整体取出, 加入 numStack
         * 4. 如果取到运算符, 说明之前已经是一个完整的计算表达式, 使用现有的 numStack 和 opStack 进行计算,
         * 直到没有操作或者遇到左括号，计算结果放到 numStack, 相到于得到了当前运算符的左操作数，最后放入当前运算符
         */
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                // 如果运算符栈顶不是 (，说明括号内有运算，直接进行计算，在弹出左括号
                // 否则说明括号内没有运算，直接弹出左括号
                if (opStack.peek() != '(') {
                    cal(numStack, opStack);
                    opStack.pop();
                } else {
                    opStack.pop();
                }
            } else if (Character.isDigit(c)) {
                // 将从 i 位置开始后面的连续数字整体取出，加入 numStack
                int number = 0;
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    number = number * 10 + (s.charAt(j) - '0');
                    j++;
                }
                numStack.push(number);
                // 此时的j位置是第一个不为数字的位置，将遍历的位置调整到j-1
                i = j - 1;
            } else {
                // 为防止 () 内出现的首个字符为运算符，将 (- 替换为 (0-，(+ 替换为 (0+
                if (i > 0 && (s.charAt(i - 1) == '('))
                    numStack.push(0);
                // 使用现有的 numStack 和 opStack 计算表达式
                // 运算符栈不为空而且前一个是运算符不是括号才可以计算
                if (!opStack.isEmpty() && opStack.peek() != '(')
                    cal(numStack, opStack);
                // 操作符入栈
                opStack.push(c);
            }
        }
        if (!opStack.isEmpty())
            cal(numStack, opStack);
        return numStack.peek();
    }

    // 使用现有的 num栈 和 op栈 进行表达式计算
    public void cal(Deque<Integer> numStack, Deque<Character> opStack) {
        // 取出两个数和一个运算符进行计算
        int num2 = numStack.pop(), num1 = numStack.pop();
        char op = opStack.pop();
        if (op == '+')
            numStack.push(num1 + num2);
        else if (op == '-')
            numStack.push(num1 - num2);
    }

    public static void main(String[] args) {
        Leetcode224 solution = new Leetcode224();
        System.out.println(solution.calculate("1 + 1")); // Output: 2
        System.out.println(solution.calculate(" 2-1 + 2 ")); // Output: 3
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
        System.out.println(solution.calculate("2147483647")); // Output: 2147483647
        System.out.println(solution.calculate("1-(     -2)")); // Output: 2147483647
    }
}
