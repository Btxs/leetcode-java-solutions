public class leetcode1372 {
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

    int maxPath = 0;
    // Longest ZigZag Path in a Binary Tree
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxPath;
    }

    private void dfs(TreeNode node, boolean isLeftChild, int currentLength) {
        maxPath = Math.max(maxPath, currentLength);
        if (!isLeftChild) {
            if (node.left != null) {
                dfs(node.left, true, currentLength + 1);
            }
            if (node.right != null) {
                dfs(node.right, false, 1);
            }
        } else {
            if (node.right != null) {
                dfs(node.right, false, currentLength + 1);
            }
            if (node.left != null) {
                dfs(node.left, true, 1);
            }
        }
    }
}