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

class TreePair{
    int height;
    int diameter;

    TreePair(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        TreePair pair = diameterHelper(root);

        return pair.diameter;
    }

    public TreePair diameterHelper(TreeNode node){
        if(node == null) return new TreePair(0, 0);

        TreePair leftPair = diameterHelper(node.left);
        TreePair rightPair = diameterHelper(node.right);

        int height = Math.max(leftPair.height, rightPair.height) + 1;
        int diameter = Math.max(leftPair.diameter, Math.max(rightPair.diameter, leftPair.height + rightPair.height));
        return new TreePair(height, diameter);
    }
    
}
