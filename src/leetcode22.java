import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    /**
     * Generate Parentheses
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", 0, 0, result, n);
        return result;
    }

    private void backtrack(String current, int left, int right, List<String> result, int n) {
        if (current.length() == 2*n) {
            result.add(current);
            return;
        }
        if (left < n) {
            backtrack(current + '(', left + 1, right, result, n);
        }
        if (right < left) {
            backtrack(current + ')', left, right + 1, result, n);
        }
    }
}
