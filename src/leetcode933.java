import java.util.Deque;
import java.util.LinkedList;

public class leetcode933 {
    // Number of Recent Calls
    private Deque<Integer> deque = new LinkedList<>();

    public leetcode933() {

    }

    public int ping(int t) {
        // 将当前时间加入队列，并移除队列中所有超过3000ms的元素
        deque.add(t);
        while (deque.peekFirst() < t - 3000) {
            deque.pollFirst();
        }
        return deque.size();
    }
}
