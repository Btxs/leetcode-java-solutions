import java.util.TreeSet;

public class Leetcode2336 {
    
}

class SmallestInfiniteSet {
    private int thres;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        thres = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            int ans = thres;
            thres++;
            return ans;
        } else {
            int ans = set.pollFirst();
            return ans;
        }
    }

    public void addBack(int num) {
        if (num < thres) {
            set.add(num);
        }
    }
}
