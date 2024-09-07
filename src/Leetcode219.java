import java.util.HashMap;
import java.util.Map;

public class Leetcode219 {
    /**
     * Contains Duplicate II
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Use a hashmap to store the number and its index
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i]) && i - numMap.get(nums[i]) <= k) {
                return true;
            }
            numMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode219 solution = new Leetcode219();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.containsNearbyDuplicate(nums1, 3)); // true
        
        int[] nums2 = {1, 0, 1, 1};
        System.out.println(solution.containsNearbyDuplicate(nums2, 1)); // true
        
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        System.out.println(solution.containsNearbyDuplicate(nums3, 2)); // false
    }
}
