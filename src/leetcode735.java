import java.util.Stack;

public class leetcode735 {
    // Asteroid Collision
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (Integer currentAtseroid : asteroids) {
            boolean isAlive = true;
            while (isAlive && !stack.isEmpty() && currentAtseroid < 0 && !(stack.peek() < 0)) {
                isAlive = stack.peek() < -currentAtseroid;
                if (stack.peek() <= -currentAtseroid) {
                    stack.pop();
                }
            }
            if (isAlive) {
                stack.push(currentAtseroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        return result;
    }
}
