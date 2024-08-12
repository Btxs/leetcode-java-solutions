import java.util.LinkedList;
import java.util.Queue;

public class leetcode1161 {
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

    // Maximum Level Sum of a Binary Tree
    public int maxLevelSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int result = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

            if(sum > maxSum){
                maxSum = sum;
                result = level;
            }

            level++;
        }

        return result;
    }
}
