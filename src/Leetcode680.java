public class Leetcode680 {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char c1 = s.charAt(left), c2 = s.charAt(right);
            if (c1 == c2) {
                left++;
                right--;
            } else {
                return validPalindrome(s, left, right - 1) || validPalindrome(s, left + 1, right);
            }
        }
        return true;
    }

    private boolean validPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; ++i, --j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}
