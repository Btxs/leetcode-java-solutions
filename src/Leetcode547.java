public class Leetcode547 {
    // Number of Provinces
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;
        for(int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[node][i] == 1) {
                dfs(isConnected, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Leetcode547 solution = new Leetcode547();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution.findCircleNum(isConnected)); // Output: 2
    }
}
