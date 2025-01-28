import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    private static final List<Integer>[] result = new List[34];

    static {
        result[0] = List.of(1);
        for (int i = 1; i < result.length; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i ; j++) {
                row.add(result[i - 1].get(j - 1) + result[i - 1].get(j));
            }
            row.add(1);
            result[i] = row;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        return result[rowIndex];
    }
}
