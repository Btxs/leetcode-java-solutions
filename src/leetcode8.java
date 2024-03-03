public class leetcode8 {
    public int myAtoi(String s) {
        s = s.trim();
        if (checkInput(s)) {
            return 0;
        }

        int i = 0;
        long num = 0;
        boolean sign = true;

        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i++) == '-') ? false : true;
        }

        // Process digits
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i++) - '0';
            // Check overflow
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
            }
            num = num * 10 + digit;
        }
        return (int) (convertSign(sign) * num);
    }

    private boolean checkInput(String s) {
        if (s.length() == 0) {
            return true;
        }
        return false;
    }

    private int convertSign(boolean sign) {
        return sign ? 1 : -1;
    }
}
