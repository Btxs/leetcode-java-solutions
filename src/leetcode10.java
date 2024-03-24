public class leetcode10 {

    Result[][] result;

    /**
     * Regular Expression Matching
     */
    public boolean isMatch(String s, String p) {
        result = new Result[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    enum Result {
        TRUE, FALSE
    }

    private boolean dp(int i, int j, String text, String pattern) {
        if (result[i][j] != null) {
            return result[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*') {
                ans = (dp(i, j+2, text, pattern) || first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        result[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
}
