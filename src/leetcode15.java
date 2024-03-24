import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.AbstractList;

public class leetcode15 {
    /**
     * 3Sum
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        result.addAll(s);
        return result;
    }


    private List<List<Integer>> res;
    /**
     * faster solution
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2List(int[] nums) {
        return new AbstractList<List<Integer>> () {
            @Override
            public int size() {
                init();
                return res.size();
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            private void init() {
                if (res != null) {
                    return;
                }
                Arrays.sort(nums);

                long partialSum;
                Set < List < Integer >> output = new HashSet<> ();
                for (int i = 0; i < nums.length - 2; i++) {
                    if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                    }
                    partialSum = nums[i];
                    int begin = i + 1;
                    int end = nums.length - 1;
                    while (begin < end) {
                        long partial = partialSum + nums[begin] + nums[end];
                        if (partial == 0) {
                            //add to solution
                            output.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                        }
                        if (partialSum + nums[begin] + nums[end] > 0) {
                            end--;
                            while (nums[end] == nums[end + 1] && begin < end) {
                                end--;
                            }
                        } else {
                            begin++;
                            while (nums[begin] == nums[begin - 1] && begin < end) {
                                begin++;
                            }
                        }
                    }
                }
                res = new ArrayList<>(output);
            }
        };
    }
}
