public class leetcode6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int diff = (numRows -1) * 2;
        int n = s.length();
        int diagonalDiff = diff;
        int index = 0;
        int secondIndex;
        for (int i = 0; i < numRows; i++) {
            index = i;
            while (index < n) {
                stringBuilder.append(s.charAt(index));
                if (i != 0 && i != numRows - 1) {
                    diagonalDiff = diff - 2 * i;
                    secondIndex = index + diagonalDiff;
                    if (secondIndex < n) {
                        stringBuilder.append(s.charAt(secondIndex));
                    }
                }
                index = index + diff;
            }
        }
        return stringBuilder.toString();
    }
}
