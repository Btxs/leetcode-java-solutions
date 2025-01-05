import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, k, n, 1, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> result, int k, int target, int start, List<Integer> currentCombination) {
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        if (k <= 0 || target < 0) {
            return;
        }

        for (int i = start; i <= 9; i++) {
            currentCombination.add(i);
            backtrack(result, k-1, target-i, i+1, currentCombination);
            // BackTrack: Remove the last added element
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
