public class Leetcode58 {
    /**
     * Length of Last Word
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        int maxLength = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                break;
            }
        }
        return Math.max(length, maxLength);
    }
}
