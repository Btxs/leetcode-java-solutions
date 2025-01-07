public class Leetcode3019 {
    public int countKeyChanges(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int count = 0;
        s = s.toLowerCase();
        char previousChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar != previousChar) {
                count++;
            }
            previousChar = currentChar;
        }
        return count;
    }
}
