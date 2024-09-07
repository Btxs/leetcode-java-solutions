import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    /**
     * Happy Number
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        // We use a Set to keep track of the numbers we've seen so far. This is used to detect cycles.
        Set<Integer> seen = new HashSet<>();
        // In each iteration, we calculate the sum of squares of the digits of the current number using the getSumOfSquares method.
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int sumOfSquares = getSumOfSquares(n);
            n = sumOfSquares;
        }
        // If the current number is 1, we return true (happy number).
        return n == 1;
    }

    private int getSumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Leetcode202 solution = new Leetcode202();
        
        System.out.println(solution.isHappy(19)); // true
        System.out.println(solution.isHappy(2));  // false
    }
}
