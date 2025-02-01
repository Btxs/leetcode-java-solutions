public class Leetcode1318 {
    public int minFlips(int a, int b, int c) {
        int len = 30;
        int ans = 0;
        while (len > 0) {
            int a1 = a & 1;
            int b1 = b & 1;
            int c1 = c & 1;
            if (c1 == 1) {
                if (a1 == 0 && b1 == 0) {
                    ans++;
                }
            } else {
                ans += (a1 + b1);
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
            len--;
        }
        return ans;
    }
}
