public class leetcode1768 {
    // Merge Strings Alternately, time complexity O(M + N)
    public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        StringBuilder result = new StringBuilder();
        // Use two pointers
        int i = 0, j = 0;
        while (i < word1Length || j < word2Length) {
            if (i < word1Length) {
                result.append(word1.charAt(i++));
            }
            if (j < word2Length) {
                result.append(word2.charAt(j++));
            }
        }
        return result.toString();
    }

    // A better solution, time complexity O(N)
    public String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        // Use one pointers
        if (word1.length()<=word2.length()) {
            for (int i = 0; i <= word1.length()-1; i++) {
                result.append(word1.charAt(i));
                result.append(word2.charAt(i));
            }
            result.append(word2.substring(word1.length(),word2.length()));
        }
        else {
            for (int i = 0; i <= word2.length()-1; i++) {
                result.append(word1.charAt(i));
                result.append(word2.charAt(i));
            }
            result.append(word1.substring(word2.length(), word1.length()));
        }
        return result.toString();
    }
}
