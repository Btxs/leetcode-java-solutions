public class Leetcode1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[n];
        
        for (int j = 0; j < n; j++) {
            int currentCol = j;
            boolean stuck = false;
            for (int i = 0; i < m; i++) {
                int direction = grid[i][currentCol];
                int nextCol = currentCol + direction;
                if (nextCol < 0 || nextCol >= n) {
                    stuck = true;
                    break;
                }
                if (grid[i][nextCol] != direction) {
                    stuck = true;
                    break;
                }
                currentCol = nextCol;
            }
            answer[j] = stuck ? -1 : currentCol;
        }
        
        return answer;
    }
}
