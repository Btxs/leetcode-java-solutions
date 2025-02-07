public class Leetcode59 {
    public int[][] generateMatrix(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        
        // 初始化方向，右 -> 下 -> 左 -> 上
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        int directionIndex = 0;
        int row = 0, column = 0;
    
        while (curNum <= maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            
            // 计算下一个位置
            int nextRow = row + directionX[directionIndex];
            int nextColumn = column + directionY[directionIndex];
            
            // 检查边界和已访问情况
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                // 如果无法前进，旋转方向
                directionIndex = (directionIndex + 1) % 4;
            }
            
            // 更新当前的行和列
            row = row + directionX[directionIndex];
            column = column + directionY[directionIndex];
        }
    
        return matrix;
    }
}
