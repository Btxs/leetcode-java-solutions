public class leetcode392 {
    // Is Subsequence
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        // 特殊情况处理：如果s为空串，则其必定是任何非空字符串的子序列
        if (lenS == 0) return true;
        // 如果t为空，则s不可能是t的子序列，返回false
        if (lenT == 0) return false;
        int i = 0, j = 0;
        while(j < lenT) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
            if (i == lenS) return true;
        }
        return false;
    }
}
