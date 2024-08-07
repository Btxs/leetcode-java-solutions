public class leetcode400 {
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

    // Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        // 二叉搜索树的特性：左子树所有节点值都小于根节点，右子树所有节点值都大于根节点
        if (val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}