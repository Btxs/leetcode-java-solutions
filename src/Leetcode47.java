import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int lenght = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = Arrays.asList(new Integer[nums.length]);
        boolean[] visited = new boolean[lenght];
        dfs(0, nums, temp, visited, result);
        return result;
    }

    private void dfs(int index, int[] nums, List<Integer> temp, boolean[] visited, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            temp.set(index, nums[i]);
            visited[i] = true;
            dfs(index + 1, nums, temp, visited, result);
            visited[i] = false;
        }
    }
}
