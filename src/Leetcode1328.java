public class Leetcode1328 {
    public String breakPalindrome(String palindrome) {
        // 如果字符串长度为1，直接返回空字符串
        if (palindrome.length() == 1) {
            return "";
        }
        // 将字符串转换为字符数组
        char[] chars = palindrome.toCharArray();
        // 遍历字符数组
        for (int i = 0; i < chars.length / 2; i++) {
            // 如果当前字符不是'a'，则替换为'a'
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        // 如果字符都是'a'，则将最后一个字符替换为'b'
        chars[chars.length - 1] = 'b';
        return new String(chars);
    }
}
