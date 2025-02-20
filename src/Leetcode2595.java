public class Leetcode2595 {
    public int[] evenOddBit(int n) {
        int even = 0;
        int odd = 0;
        int index = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n = n >> 1;
            index++;
        }

        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        Leetcode2595 solution = new Leetcode2595();
        System.out.println(java.util.Arrays.toString(solution.evenOddBit(50))); // 输出: [1, 2]
        System.out.println(java.util.Arrays.toString(solution.evenOddBit(2)));  // 输出: [0, 1]
    }
}
