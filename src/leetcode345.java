import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode345 {
    // Reverse Vowels of a String
    public String reverseVowels(String s) {
        char str[] = s.toCharArray();
        String lowerCaseS = s.toLowerCase();
        Set<Character> vowelsSet = new HashSet<Character>();
        vowelsSet.add('a');
        vowelsSet.add('e');
        vowelsSet.add('i');
        vowelsSet.add('o');
        vowelsSet.add('u');
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !vowelsSet.contains(lowerCaseS.charAt(start))) {
                start++;
            }
            while (end > 0 && !vowelsSet.contains(lowerCaseS.charAt(end))) {
                end--;
            }
            //temp value
            if (start < end) {
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                start++;
                end--;
            }
        }
        return new String(str);
    }

    public String reverseVowels2(String s) {
        if(s.length() == 1){
            return s;
        }
        // 先统计出所有元音字母的下标
        char[] chArr = s.toCharArray();
        List<Integer> idxList = new ArrayList<>();
        for(int i=0;i<chArr.length;i++){
            if(chArr[i]== 'a' || chArr[i]=='A' || chArr[i]== 'e' || chArr[i]=='E' ||chArr[i]== 'i' || chArr[i]=='I' || chArr[i]== 'o' || chArr[i]=='O' || chArr[i]== 'u' || chArr[i]=='U'){
                idxList.add(i);
            }
        }
        // 双指针交换字母
        int left = 0;
        int right = idxList.size()-1;
        while(left < right){
            int leftIdx = idxList.get(left);
            int rightIdx = idxList.get(right);
            char tmp = chArr[leftIdx];
            chArr[leftIdx] = chArr[rightIdx];
            chArr[rightIdx] = tmp;
            left++;
            right--;
        }
        return new String(chArr);
    }
}