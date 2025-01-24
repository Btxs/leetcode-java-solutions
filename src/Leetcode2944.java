import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode2944 {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Deque<int[]> qDeque = new ArrayDeque<>();
        qDeque.addLast(new int[]{n + 1, 0});
        for (int i = n; i > 0; i--) {
            while (qDeque.peekLast()[0] > i * 2 + 1) {
                qDeque.pollLast();
            }
            int f = prices[i -1] + qDeque.peekLast()[1];
            while (f <= qDeque.peekFirst()[1]) {
                qDeque.pollFirst();
            }
            qDeque.addFirst(new int[]{i, f});
        }
        return qDeque.peekFirst()[1];
    }
}
