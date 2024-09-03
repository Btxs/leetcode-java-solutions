public class leetcode605 {
    // Can place flowers
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // if current flowerbed is empty, check left and right is empty, notice left and right maybe override
            if (flowerbed[i] == 0) {
                boolean isLeftEmptyPlot = (i == 0) || (flowerbed[i-1] == 0);
                boolean isRightEmptyPlot = (i == flowerbed.length - 1) || (flowerbed[i+1] == 0);
                if (isLeftEmptyPlot && isRightEmptyPlot) {
                    flowerbed[i] = 1;
                    sum++;
                }
                if (sum >= n) {
                    return true;
                }
            }
        }
        return sum >= n;
    }
}
