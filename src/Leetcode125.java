public class Leetcode125 {
    /**
     * Valid Palindrome
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        StringBuilder cleared = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleared.append(Character.toLowerCase(c));
            }
        }
        // Compare cleared string with it's reversed string
        // return cleared.toString().equals(cleared.reverse().toString());
        int left = 0;
        int right = cleared.length() - 1;
        while (left < right) {
            if (cleared.charAt(left) != cleared.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));  // true
        System.out.println(isPalindrome("race a car"));  // false
        System.out.println(isPalindrome(""));  // true (empty string is considered a palindrome)
    }
}
