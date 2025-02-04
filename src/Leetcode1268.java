import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1268 {
    class TrieNode {
        public static final int num = 26;
        TrieNode[] next;
        boolean isEnd;
        PriorityQueue<String> queue;

        public TrieNode() {
            next = new TrieNode[num];
            queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        }
    }

    private static final int size = 3;
    private TrieNode root;
    private List<List<String>> ans;

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.next[index] == null) {
                node.next[index] = new TrieNode();
            }
            node = node.next[index];
            node.queue.offer(word);
            if (node.queue.size() > size) {
                node.queue.poll();
            }
        }
        node.isEnd = true;
    }

    public void startsWith(String word) {
        TrieNode node = root;
        boolean exist = true;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (!exist || node.next[index] == null) {
                exist = false;
                ans.add(new ArrayList<>());
                continue;
            }
            node = node.next[index];
            List<String> tmp = new ArrayList<>();
            while (!node.queue.isEmpty()) {
                tmp.add(node.queue.poll());
            }
            Collections.reverse(tmp);
            ans.add(tmp);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        ans = new ArrayList<>();
        root = new TrieNode();
        for (String product : products) {
            insert(product);
        }
        startsWith(searchWord);
        return ans;
    }
}
