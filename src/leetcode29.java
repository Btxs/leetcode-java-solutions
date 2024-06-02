public class leetcode29 {
    /**
     * Divide Two Integers
     * 
     * This solution uses a bit manipulation approach to divide two integers without using multiplication, division, and mod operator.
     * Here's how it works:
     * We first handle the special case where dividend is Integer.MIN_VALUE and divisor is -1. In this case, we return Integer.MAX_VALUE.
     * Then, we calculate the sign of the result by checking if both dividend and divisor are negative or not. If they have different signs, we make the sign negative; otherwise, we keep it positive.
     * We then convert both dividend and divisor to their absolute values and store them in d and di, respectively.
     * Next, we use a loop that iterates from the most significant bit (31) down to the least significant bit (0). In each iteration, we check if shifting di left by i bits and subtracting it from d would result in a value less than or equal to 0. If so, we add 1L << i to the result (res) and subtract di << i from d.
     * Finally, we return the sign multiplied by the absolute value of the result (Math.toIntExact(res)) as the final answer.
     * This solution has a time complexity of O(log(dividend)) where dividend is the input integer. This is because in the worst case, we need to shift and subtract di from d 31 times (for each bit position).
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        long d = Math.abs((long) dividend);
        long di = Math.abs((long) divisor);

        long res = 0;
        for(int i = 31; i >= 0; --i){
            if (((di << i) <= d)) {
                res |= (1L << i);
                d -= di << i;
            }
        }

        // return sign * Math.toIntExact(res);
        return (int) (sign * res);
    }
}
