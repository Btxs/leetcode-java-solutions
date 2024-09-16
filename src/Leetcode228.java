import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        
        List<String> result = new ArrayList<>();
        int i = 0, n = nums.length;
        
        while (i < n) {
            int start = i;
            // 向后查找连续的元素
            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            
            if (start != i) { // 如果有区间，则添加范围
                result.add(nums[start] + "->" + nums[i]);
            } else { // 只有单个数字的情况
                result.add(String.valueOf(nums[start]));
            }
            
            i++;
        }
        
        return result;
    }
}
