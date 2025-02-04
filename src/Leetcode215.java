public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, heapSize, 0);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, heapSize, i);
        }
    }

    private void maxHeapify(int[] nums, int heapSize, int index) {
        int left = index * 2 + 1, right = index * 2 + 2, largest = index;
        if (left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(nums, index, largest);
            maxHeapify(nums, heapSize, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
