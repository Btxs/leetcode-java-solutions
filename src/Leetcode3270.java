public class Leetcode3270 {
    public int generateKey(int num1, int num2, int num3) {
        // Array to hold the result digits
        int[] result = new int[4];

        // Loop through each digit position (units to thousands)
        for (int i = 0; i < 4; i++) {
            // Extract the current digit from each number
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
            int digit3 = num3 % 10;

            // Find the minimum of these digits
            result[3 - i] = Math.min(digit1, Math.min(digit2, digit3));

            // Remove the last digit from each number (integer division by 10)
            num1 /= 10;
            num2 /= 10;
            num3 /= 10;
        }

        // Construct the final number from the result array
        int key = 0;
        for (int i = 0; i < 4; i++) {
            key = key * 10 + result[i];
        }

        return key;
    }

    public static void main(String[] args) {
        Leetcode3270 leetcode3270 = new Leetcode3270();
        System.out.println(leetcode3270.generateKey(1, 10, 1000)); // Output: 0
        System.out.println(leetcode3270.generateKey(987, 879, 798)); // Output: 777
        System.out.println(leetcode3270.generateKey(1, 2, 3)); // Output: 1
    }
}
