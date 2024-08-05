public class leetcode1448 {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans;
    // Count Good Nodes in Binary Tree
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return;
        }
        maxVal = Math.max(maxVal, node.val);
        ans += (maxVal <= node.val) ? 1 : 0;
        dfs(node.left, maxVal);
        dfs(node.right, maxVal);
    }
}
