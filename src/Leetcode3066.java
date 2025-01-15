import java.util.PriorityQueue;

public class Leetcode3066 {
    public int minOperations(int[] nums, int k) {
        // Initialize a priority queue (min-heap)
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        // Add all elements to the priority queue
        for (long num : nums) {
            pq.offer(num);
        }
        
        int operations = 0;
        
        // Perform operations until the largest element is at least k
        while (pq.size() > 1 && pq.peek() < k) {
            // Extract two smallest elements
            long x = pq.poll();
            long y = pq.poll();
            
            // Calculate new value and add it back to the heap
            long newValue = Math.min(x, y) * 2 + Math.max(x, y);
            pq.offer(newValue);
            
            // Increment operation count
            operations++;
        }
        
        return operations;
    }
}
