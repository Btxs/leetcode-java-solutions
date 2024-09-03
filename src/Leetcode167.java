public class Leetcode167 {
    /**
     * Two Sum II - Input Array Is Sorted
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        // Use two pointers
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else {
                // the array is sorted, so you can check target value and move pointer
                if (numbers[left] + numbers[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
