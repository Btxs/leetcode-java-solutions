import java.util.LinkedList;
import java.util.Queue;

public class leetcode649 {
    // Dota2 Senate
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rad = radiant.poll();
            int dir = dire.poll();
            if (rad < dir) {
                radiant.offer(rad + senate.length());
            } else {
                dire.offer(dir + senate.length());
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
