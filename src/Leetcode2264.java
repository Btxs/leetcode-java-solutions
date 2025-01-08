public class Leetcode2264 {
    public String largestGoodInteger(String num) {
        for (char ch = '9'; ch >= '0'; ch--) {
            String str = String.valueOf(ch).repeat(3);
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }
}
