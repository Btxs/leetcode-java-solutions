import java.util.HashSet;
import java.util.Set;

public class Leetcode2614 {
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        Set<Integer> primes = new HashSet<>();

        // Check each element to see if it's on any diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = nums[i][j];

                // Check if the number is on a primary diagonal (i == j)
                if (i == j) {
                    primes.add(val);
                }

                // Check if the number is on a secondary diagonal (i + j == n - 1)
                if (i + j == n - 1) {
                    primes.add(val);
                }
            }
        }

        int maxPrime = 0;
        for (int prime : primes) {
            // Check if the number is a prime
            if (isPrime(prime)) {
                maxPrime = Math.max(maxPrime, prime);
            }
        }

        return maxPrime;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
