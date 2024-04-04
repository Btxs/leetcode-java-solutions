import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode18 {
    /**
     * 4Sum
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                long sum = (long) target - (long) nums[i] - (long) nums[j];
                int l = j + 1;
                int m = nums.length - 1;
                while (l < m) {
                    long temp = nums[l] + nums[m];
                    if (temp == sum) {
                        List<Integer> al = new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[l]);
                        al.add(nums[m]);
                        ans.add(al);
                        int low = nums[l];
                        int high = nums[m];
                        l++;
                        m--;

                        while (l < m && nums[l] == low)
                            l++;
                        while (l < m && nums[m] == high)
                            m--;
                    } else if (temp > sum)
                        m--;
                    else
                        l++;
                }
            }
        }
        return ans;
    }


    /**
     * 4Sum another faster solution
     */
    private List<List<Integer>> res;
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        return new AbstractList<List<Integer>> () {
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }
            
            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null) return;
                Arrays.sort(nums);
                ArrayList<List<Integer>> ans = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    if (i>0 && nums[i] == nums[i-1]) {
                        continue;
                    }
                    for (int j = i+1; j < nums.length; j++) {
                        if (j > i+1 && nums[j] == nums[j-1]) {
                            continue;
                        }
                        twoSum(i, j, ans);
                    }
                }
                res = ans;
            }

            private void twoSum(int i, int j, ArrayList<List<Integer>> ans) {
                //System.out.println("target: " + target);
                long t = (long)target - nums[i] - nums[j];
                int left = j+1, right = nums.length-1;
                while (left < right) {
                    if (j+1 < left && nums[left-1] == nums[left]) {
                        left++;
                        continue;
                    }
                    long sum = nums[left] + nums[right];
                    //System.out.println(sum +  " " + t);
                    if (sum > t) {
                        right--;
                    } else if (sum < t) {
                        left++;
                    } else {
                        //System.out.println("left: " + left + " right: " + right);
                        ArrayList<Integer> al = new ArrayList<>(4);
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        ans.add(al);
                        left++;
                    }
                } 
            }
        };
    }
}
