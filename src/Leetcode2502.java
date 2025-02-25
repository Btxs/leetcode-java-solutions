import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode2502 {
    private int[] memory;
    private Map<Integer, List<int[]>> allocateBlocks;

    public Leetcode2502(int n) {
        memory = new int[n];
        allocateBlocks = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        int start = 0;
        while (start <= memory.length - size) {
            if (memory[start] == 0) {
                boolean canAllocate = true;
                for (int i = start; i < start + size; i++) {
                    if (memory[i] != 0) {
                        canAllocate = false;
                        start = i;
                        break;
                    }
                }
                if (canAllocate) {
                    for (int i = start; i <= start + size - 1; i++) {
                        memory[i] = mID;
                    }
                    allocateBlocks.computeIfAbsent(mID, k -> new ArrayList<>()).add(new int[]{start, start + size - 1});
                    return start;
                }
            }
            start++;
        }
        return -1;
    }

    public int freeMemory(int mID) {
        if (!allocateBlocks.containsKey(mID)) {
            return 0;
        }
        int freed = 0;
        List<int[]> blocks = allocateBlocks.get(mID);
        for (int[] block : blocks) {
            int start = block[0];
            int end = block[1];
            for (int i = start; i <= end; i++) {
                if (memory[i] == mID) {
                    memory[i] = 0;
                    freed++;
                }
            }
        }
        allocateBlocks.remove(mID);
        return freed;
    }
}
