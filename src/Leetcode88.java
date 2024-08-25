public class Leetcode88 {
    // Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int current;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                current = nums2[p2--];
            } else if (p2 == -1) {
                current = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                current = nums1[p1--];
            } else {
                current = nums2[p2--];
            }
            nums1[tail--] = current;
        }
    }
}
