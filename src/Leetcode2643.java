public class Leetcode2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        // Initialize variables to track the row with the maximum number of 1s.
        int maxCount = -1;
        int rowIndex = -1;

        // Iterate over each row in the matrix.
        for (int i = 0; i < mat.length; i++) {
            // Count the number of 1s in the current row.
            int countOnes = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    countOnes++;
                }
            }

            // Update the maxCount and rowIndex if a new maximum is found.
            // If there's a tie, choose the row with the smallest index.
            if (countOnes > maxCount || (countOnes == maxCount && i < rowIndex)) {
                maxCount = countOnes;
                rowIndex = i;
            }
        }

        // Return an array containing the row index and the number of 1s in that row.
        return new int[] {rowIndex, maxCount};
    }
}
