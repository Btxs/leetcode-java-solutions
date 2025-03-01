import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        // 如果已经处理到字符串末尾，将当前路径加入结果集
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 尝试从当前索引开始，逐步增加子串的长度
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            // 如果子串是回文串，则继续递归处理剩余的字符串
            if (isPalindrome(substring)) {
                path.add(substring);
                backtrack(s, end, path, result);
                path.remove(path.size() - 1); // 回溯，移除当前子串
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
