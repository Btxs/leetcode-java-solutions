import java.util.*;
import java.util.stream.Collectors;

public class leetcode2215 {
    // Find the Difference of Two Arrays
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(set1.stream().filter(num -> !set2.contains(num)).collect(Collectors.toList()));
        result.add(set2.stream().filter(num -> !set1.contains(num)).collect(Collectors.toList()));
        return result;
    }

    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (set2.contains(value)) {
                iterator.remove();
                set2.remove(value);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(set1));
        result.add(new ArrayList<>(set2));
        return result;
    }
}
