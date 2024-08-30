import java.util.*;

public class Leetcode380 {
    
}

class RandomizedSet {
    // Insert Delete GetRandom O(1)

    // 列表存储数据
    List<Integer> list;
    // 哈希表存储下标
    HashMap<Integer, Integer> map;
    int count = 0;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int length = list.size() - 1;
            int index = map.get(val);
            int last = list.get(length);
            if (index != length) {
                list.set(index, last);
                map.put(last, index);
            }
            list.remove(length);
            map.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}