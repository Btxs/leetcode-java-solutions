public class Leetcode3340 {
    public boolean isBalanced(String num) {
        int evenSum = 0; // 偶数下标处的数字之和
        int oddSum = 0;  // 奇数下标处的数字之和

        for (int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            if (i % 2 == 0) {
                evenSum += digit; // 偶数下标
            } else {
                oddSum += digit;  // 奇数下标
            }
        }

        return evenSum == oddSum;
    }
}
