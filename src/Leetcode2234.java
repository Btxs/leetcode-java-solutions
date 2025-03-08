import java.util.Arrays;

public class Leetcode2234 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        int n = flowers.length;
    
        // 1. 将花朵数量限制在目标值以内，并排序
        for (int i = 0; i < n; i++) {
            flowers[i] = Math.min(flowers[i], target); // 确保花朵数量不超过目标值
        }
        Arrays.sort(flowers); // 升序排序
        reverse(flowers); // 反转数组，变为降序排序
    
        // 2. 计算所有花朵的总和
        long sum = 0;
        for (int flower : flowers) {
            sum += flower;
        }
    
        // 3. 如果所有花园都可以达到目标值，则直接返回最大美丽值
        long ans = 0;
        if ((long) target * n - sum <= newFlowers) {
            ans = (long) full * n; // 所有花园都达到目标值，美丽值为 full * n
        }
    
        // 4. 遍历花园，尝试将部分花园提升到目标值，并计算剩余花园的最大最小值
        long pre = 0; // 记录前 i 个花园的总和
        int ptr = 0; // 指针，用于计算剩余花园的最小值
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                pre += flowers[i - 1]; // 更新前 i 个花园的总和
            }
            if (flowers[i] == target) {
                continue; // 如果当前花园已经达到目标值，跳过
            }
    
            // 计算将前 i 个花园提升到目标值所需的额外花朵
            long rest = newFlowers - ((long) target * i - pre);
            if (rest < 0) {
                break; // 如果剩余花朵不足，退出循环
            }
    
            // 调整指针 ptr，使得剩余花园的最小值最大化
            while (!(ptr >= i && (long) flowers[ptr] * (n - ptr) - sum <= rest)) {
                sum -= flowers[ptr]; // 更新剩余花园的总和
                ptr++; // 移动指针
            }
    
            // 计算剩余花园的最小值
            rest -= (long) flowers[ptr] * (n - ptr) - sum;
            long minFlowers = Math.min(flowers[ptr] + rest / (n - ptr), (long) target - 1);
    
            // 更新最大美丽值
            ans = Math.max(ans, (long) full * i + (long) partial * minFlowers);
        }
    
        return ans;
    }
    
    // 辅助方法：反转数组
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
