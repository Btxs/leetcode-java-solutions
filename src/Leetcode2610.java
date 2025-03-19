import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = map.getOrDefault(nums[i], 0);
            if (res.size() < index + 1) {
                res.add(new ArrayList<>());
            }
            res.get(index).add(nums[i]);
            map.put(nums[i], index + 1);
        }
        return res;
    }
}
