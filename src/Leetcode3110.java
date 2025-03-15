public class Leetcode3110 {
    public int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int amt = 0;
        for (int i = 1; i <= chars.length -1; i++) {
            amt += Math.abs(chars[i - 1] - chars[i]);
        }
        return amt;
    }
}
