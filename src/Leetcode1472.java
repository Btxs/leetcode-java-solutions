import java.util.ArrayList;
import java.util.List;

public class Leetcode1472 {
    private List<String> history;
    private int currentIndex;

    public Leetcode1472(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }
    
    public void visit(String url) {
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        currentIndex++;
    }
    
    public String back(int steps) {
        currentIndex = Math.max(currentIndex - steps, 0);
        return history.get(currentIndex);
    }
    
    public String forward(int steps) {
        currentIndex = Math.min(currentIndex + steps, history.size() - 1);
        return history.get(currentIndex);
    }
}
