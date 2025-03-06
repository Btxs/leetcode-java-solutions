import java.util.HashMap;
import java.util.Map;

public class Leetcode2588 {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> prefixXorCount = new HashMap<>();
        // 初始前缀异或值为 0，出现次数为 1
        prefixXorCount.put(0, 1);
        int prefixXor = 0;
        long result = 0;
        
        for(int num : nums) {
            // 更新当前前缀异或值
            prefixXor ^= num;
            // 如果当前前缀异或值已经在哈希表中，累加结果
            if (prefixXorCount.containsKey(prefixXor)) {
                result += prefixXorCount.get(prefixXor);
            }
            // 更新哈希表中当前异或值的出现次数
            prefixXorCount.put(prefixXor, prefixXorCount.getOrDefault(prefixXor, 0) + 1);
        }

        return result;
    }
}
