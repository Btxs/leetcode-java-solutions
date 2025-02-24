import java.util.Random;

public class Leetcode1206 {
    private static final int MAX_LEVEL = 16; // 最大层数
    private static final double P = 0.5; // 每个节点被提升到上一层的概率
    private final Node head; // 头节点
    private int level; // 当前跳表的层数
    private final Random random; // 随机数生成器

    public Leetcode1206() {
        this.level = 0;
        this.head = new Node(-1, MAX_LEVEL);
        this.random = new Random();
    }

    // 查找目标值是否存在于跳表中
    public boolean search(int target) {
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    // 插入一个元素到跳表
    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];

        // 允许插入重复值
        int lvl = randomLevel();
        if (lvl > level) {
            for (int i = level + 1; i <= lvl; i++) {
                update[i] = head;
            }
            level = lvl;
        }
        Node newNode = new Node(num, lvl);
        for (int i = 0; i <= lvl; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    // 在跳表中删除一个值
    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }
        curr = curr.forward[0];

        if (curr != null && curr.val == num) {
            for (int i = 0; i <= level; i++) {
                if (update[i].forward[i] != curr) {
                    break;
                }
                update[i].forward[i] = curr.forward[i];
            }
            // 降低跳表层数
            while (level > 0 && head.forward[level] == null) {
                level--;
            }
            return true;
        }
        return false;
    }

    // 随机生成节点的层数
    private int randomLevel() {
        int lvl = 0;
        while (random.nextDouble() < P && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }

    // 跳表的节点类
    private static class Node {
        int val;
        Node[] forward;

        public Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level + 1];
        }
    }

    // 测试代码
    public static void main(String[] args) {
        Leetcode1206 skiplist = new Leetcode1206();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0)); // 返回 false
        skiplist.add(4);
        System.out.println(skiplist.search(1)); // 返回 true
        System.out.println(skiplist.erase(0)); // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(1)); // 返回 true
        System.out.println(skiplist.search(1)); // 返回 false，1 已被擦除
    }
}
