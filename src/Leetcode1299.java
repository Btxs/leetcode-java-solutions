public class Leetcode1299 {
    public int[] replaceElements(int[] arr) {
        int mx = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int x = arr[i];
            arr[i] = mx;
            mx = Math.max(mx, x);
        }
        return arr;
    }
}
