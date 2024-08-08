public class leetcode437 {
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

    int count = 0;

    // Path Sum III
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        dfs(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    private void dfs(TreeNode node, long targetSum) {
        if (node == null) return;

        // check current node
        if (targetSum - node.val == 0)
            count++;

        dfs(node.left, targetSum - node.val);
        dfs(node.right, targetSum - node.val);
    }

    Map<Long, Integer> prefixSumCount = new HashMap<>();

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Initialize the map with a dummy key for easier calculations.
        prefixSumCount.put(0L, 1);

        dfs(root, targetSum, 0);
        
        return count;
    }

    private void dfs(TreeNode node, int targetSum, long currentSum) {
        if (node == null) return;

        // Calculate the new sum and check for the required path.
        long newSum = currentSum + node.val;
        count += prefixSumCount.getOrDefault(newSum - targetSum, 0);

        // Update the map with the new sum.
        prefixSumCount.put(newSum, prefixSumCount.getOrDefault(newSum, 0) + 1);
        
        dfs(node.left, targetSum, newSum);
        dfs(node.right, targetSum, newSum);
        
        // Remove the current node's sum from the map to avoid counting paths that include this node twice.
        prefixSumCount.put(newSum, prefixSumCount.get(newSum) - 1);
    }
}