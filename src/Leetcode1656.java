import java.util.ArrayList;
import java.util.List;

public class Leetcode1656 {
    private String[] stream;
    private int ptr;

    public Leetcode1656(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        stream[idKey] = value;
        List<String> result = new ArrayList<>();

        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr]);
            ptr++;
        }

        return result;
    }
}
