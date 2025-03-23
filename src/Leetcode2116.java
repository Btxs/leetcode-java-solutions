public class Leetcode2116 {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        int mx = 0;
        int mn = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                int diff;
                if (s.charAt(i) == '(') {
                    diff = 1;
                } else {
                    diff = -1;
                }
                mx += diff;
                mn = Math.max(mn + diff, (i + 1) % 2);
            } else {
                mx++;
                mn = Math.max(mn - 1, (i + 1) % 2);
            }
            if (mx < mn) {
                return false;
            }
        }
        return mn == 0;
    }
}
