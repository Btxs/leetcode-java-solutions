import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, target, candidates, ans, path);
        return ans;
    }

    private void dfs(int i, int left, int[] candidates, List<List<Integer>> ans, List<Integer> path) {
        if (left == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i == candidates.length) {
            return;
        }
        int x = candidates[i];
        if (left < x) {
            return;
        }

        path.add(x);
        dfs(i + 1, left - x, candidates, ans, path);
        path.remove(path.size() - 1);

        i++;
        while (i < candidates.length &&candidates[i] == x) {
            i++;
        }
        dfs(i, left, candidates, ans, path);
    }
}
