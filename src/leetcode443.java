public class leetcode443 {
    // String Compression
    public int compress(char[] chars) {
        if (chars != null && chars.length < 1) {
            return 0;
        }

        int i = 0, j = 0;
        while (i < chars.length) {
            int count = 1;
            char currentChar = chars[i];
            while (i + 1 < chars.length && currentChar == chars[i + 1]) {
                count++;
                i++;
            }
            chars[j++] = currentChar;

            if (count > 1) {
                for(char digit : Integer.toString(count).toCharArray()) {
                    chars[j++] = digit;
                }
            }
            i++;
        }
        return j;
    }
}
