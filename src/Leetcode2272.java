import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2272 {
    public int largestVariance(String s) {
        Map<Character, List<Integer>> pos = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            pos.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        for (Map.Entry<Character, List<Integer>> maxCharEntry : pos.entrySet()) {
            for (Map.Entry<Character, List<Integer>> minCharEntry : pos.entrySet()) {
                if (maxCharEntry.getKey().equals(minCharEntry.getKey())) {
                    continue;
                }
                List<Integer> maxCharPos = maxCharEntry.getValue();
                List<Integer> minCharPos = minCharEntry.getValue();
                int i = 0, j = 0;
                int f = 0, g = 0;
                boolean seen = false;
                while (i < maxCharPos.size() || j < minCharPos.size()) {
                    if (j == minCharPos.size() || (i < maxCharPos.size() && maxCharPos.get(i) < minCharPos.get(j))) {
                        f = Math.max(f, 0) + 1;
                        if (seen) {
                            g += 1;
                        }
                        i++;
                    } else {
                        f = Math.max(f, 0) - 1;
                        g = Math.max(f, g - 1);
                        seen = true;
                        j++;
                    }
                    ans = Math.max(ans, g);
                }
            }
        }
        return ans;
    }
}
