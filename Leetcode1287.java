public class Leetcode1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int threshold = n / 4;

        for (int i = 0; i < n; i += threshold + 1) {
            int target = arr[i];
            int left = findFirstOccurrence(arr, target);
            int right = findLastOccurrence(arr, target);
            if (right - left + 1 > threshold) {
                return target;
            }
        }

        return -1;
    }

    private int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Leetcode1287 solution = new Leetcode1287();
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(solution.findSpecialInteger(arr)); // Output: 6
    }
}
