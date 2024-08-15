import java.util.*;

public class Leetcode1466 {
    // Reorder Routes to Make All Paths Lead to the City Zero
    public int minReorder(int n, int[][] connections) {
        // Create an adjacency list for both directions of the roads.
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            forward.get(u).add(v);
            backward.get(v).add(u);
        }

        // Use a queue to perform BFS, starting from city 0.
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.offer(0);
        int count = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            for (int v : forward.get(u)) {
                if (!visited[v]) {
                    q.offer(v);
                    ++count; // Increment the count for each road that needs to be reversed.
                }
            }
            for (int v : backward.get(u)) {
                if (!visited[v]) {
                    q.offer(v); // No need to reverse roads in this direction, just visit the city.
                }
            }
        }

        return count;
    }
}
