import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int x = nums1[i];
            int y = nums2[j];
            if (x < y) {
                i++;
            } else if (x > y) {
                j++;
            } else {
                list.add(x);
                i++;
                j++;
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}
