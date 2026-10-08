/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = root.val;

        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode node, int[] res) {
        if(node == null) return 0;

        int leftMax = Math.max(0, dfs(node.left, res));
        int rightMax = Math.max(0, dfs(node.right, res));

        // Compute max path with split
        res[0] = Math.max(res[0], node.val + leftMax + rightMax);

        // Compute max path without split
        return node.val + Math.max(leftMax, rightMax);
    }
}
