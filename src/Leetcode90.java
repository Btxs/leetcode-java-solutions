import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, nums, ans, path);
        return ans;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans, List<Integer> path) {
        int length = nums.length;
        if (i == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        int x = nums[i];
        path.add(x);
        dfs(i + 1, nums, ans, path);
        path.remove(path.size() - 1);
        i++;
        while (i < length && nums[i] == x) {
            i++;
        }
        dfs(i, nums, ans, path);
    }
}
