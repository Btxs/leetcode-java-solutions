import java.util.Stack;

public class Leetcode155 {
    /**
     * Min Stack
     * We define a Node class to store both the value and its minimum at each step.
     * In the push method, we first check if the stack is empty. If it's not empty, we compare the new value with the current minimum. If the new value is less than or equal to the current minimum, we push a new node with the new value as both its value and minimum. Otherwise, we push a new node with the new value as its value and the current minimum as its minimum.
     * In the pop method, we simply pop from the stack.
     * The top and getMin methods return the top element's value and minimum, respectively.
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public Leetcode155() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int currentMin = minStack.peek();
            if (val <= currentMin) {
                minStack.push(val);
            } else {
                minStack.push(currentMin);
            }
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
