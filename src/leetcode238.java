public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        // 定义两个变量分别记录当前元素左侧和右侧的乘积结果
        int leftProduct = 1, rightProduct = 1;
        // 定义一个数组用于存储最终结果，长度与输入数组相同
        int[] result = new int[nums.length];
        
        // 遍历数组，计算每个元素左侧所有元素的乘积，并将结果存入result数组中
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        // 再次遍历数组，这次从后往前计算每个元素右侧所有元素的乘积，并与之前左侧乘积相乘
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        
        // 返回结果数组
        return result;
    }
}
