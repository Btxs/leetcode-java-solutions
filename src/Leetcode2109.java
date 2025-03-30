public class Leetcode2109 {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder(s.length() + spaces.length);
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                stringBuilder.append(" ");
                j++;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}