import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode841 {
    // Keys and Rooms
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.size() == 1) return true;
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(int roomIndex, List<List<Integer>> rooms, Set<Integer> visited) {
        if (visited.contains(roomIndex)) {
            return ;
        }
        visited.add(roomIndex);
        for (int key : rooms.get(roomIndex)) {
            dfs(key, rooms, visited);
        }
    }
}
