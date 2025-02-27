public class Leetcode2296 {
    private StringBuilder left;
    private StringBuilder right;

    public Leetcode2296() {
        left = new StringBuilder();
        right = new StringBuilder();
    }

    public void addText(String text) {
        left.append(text);
    }

    public int deleteText(int k) {
        int deleteLength = Math.min(k, left.length());
        left.setLength(left.length() - deleteLength);
        return deleteLength;
    }

    public String cursorLeft(int k) {
        int moveLength = Math.min(k, left.length());
        for (int i = 0; i < moveLength; i++) {
            right.append(left.charAt(left.length() - 1));
            left.deleteCharAt(left.length() - 1);
        }
        return left.substring(Math.max(0, left.length() - 10));
    }

    public String cursorRight(int k) {
        int moveLength = Math.min(k, right.length());
        for (int i = 0; i < moveLength; i++) {
            left.append(right.charAt(right.length() - 1));
            right.deleteCharAt(right.length() - 1);
        }
        return left.substring(Math.max(0, left.length() - 10));
    }
}
