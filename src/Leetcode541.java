public class Leetcode541 {
    public String reverseStr(String s, int k) {
        char[] t = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += k * 2) {
            reverse(t, i, Math.min(i + k, n) - 1);
        }
        return new String(t);
    }

    private void reverse(char[] t, int left, int right) {
        while (left < right) {
            char tmp = t[left];
            t[left] = t[right];
            t[right] = tmp;
            ++left;
            --right;
        }
    }
}
