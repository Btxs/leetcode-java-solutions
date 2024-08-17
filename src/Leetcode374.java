public class Leetcode374 {
    /** 
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
    *               otherwise return 0
    * int guess(int num);
    */
    int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2; // Prevents possible overflow

            if (guess((int)mid) == 0) {
                return (int)mid; // Found the number
            } else if (guess((int)mid) < 0) {
                right = mid - 1; // The number is lower than mid
            } else {
                left = mid + 1; // The number is higher than mid
            }
        }

        return -1; // Should never reach here if input constraints are satisfied
    }
}
