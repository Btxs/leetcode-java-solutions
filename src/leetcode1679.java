import java.util.HashMap;
import java.util.Map;

public class leetcode1679 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int operationsCount = 0;
        for (int num : nums) {
            if(countMap.containsKey(k - num) && countMap.get(k - num) > 0) {
                // 如果k-num和num不同，且两者都出现过，则可以进行一次操作
                if (num != k - num && countMap.get(num) > 0) {
                    operationsCount++;
                    countMap.put(k - num, countMap.get(k - num) - 1);
                    countMap.put(num, countMap.get(num) - 1);
                } else if (num == k - num && countMap.get(num) > 1) {
                    operationsCount++;
                    countMap.put(num, countMap.get(num) - 2);
                }
                else {
                    // 未出现过的不进行操作
                    countMap.put(k - num, countMap.get(k - num) - 1);
                }
            }
        }
        return operationsCount;
    }

    // 使用自定义的Hash表
    public int maxOperationsUseOwnHash(int[] nums, int k) {
        Hash hash = new Hash(nums.length);
        for (int num : nums) {
            hash.add(num);
        }
        int res = 0;
        for (Node node : hash.nodes) {
            Node cur = node;
            while (cur != null) {
                int x = cur.key, y = k - x;
                if (y > 0) {
                    res += Math.min(cur.value, hash.get(y));
                }
                cur = cur.next;
            }
        }
        return res / 2;
    }

    static class Hash {
        Node[] nodes;
        int n;

        public Hash(int n) {
            this.n = n;
            nodes = new Node[n];
        }

        public int hash(int key) {
            return key % n;
        }

        public int get(int key) {
            int hash = hash(key);
            Node cur = nodes[hash];
            while (cur != null) {
                if (cur.key == key) {
                    return cur.value;
                }
                cur = cur.next;
            }
            return 0;
        }

        public void add(int key) {
            int hash = hash(key);
            Node cur = nodes[hash];
            while (cur != null) {
                if (cur.key == key) {
                    cur.value++;
                    break;
                }
                cur = cur.next;
            }
            if (cur == null) {
                Node head = new Node(key, 1);
                head.next = nodes[hash];
                nodes[hash] = head;
            }
        }
    }

    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
