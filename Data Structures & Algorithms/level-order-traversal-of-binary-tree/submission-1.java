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

class Tuple{
    TreeNode node;
    int parentLevel;
    Tuple(TreeNode node, int parentLevel){
        this.node = node;
        this.parentLevel = parentLevel;
    }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0 ; i< levelSize; i++){
                TreeNode top = queue.poll();
                curr.add(top.val);

                if(top.left!= null){
                    queue.offer(top.left);
                }
                if(top.right!= null){
                    queue.offer(top.right);
                }
            }
            result.add(curr);
        }
        return result;
    }

    public List<List<Integer>> levelOrderI(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<Tuple> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        queue.offer(new Tuple(root, -1));
        int lastLevel = -1;

        while(!queue.isEmpty()){
            Tuple temp = queue.poll();

            TreeNode currNode = temp.node;
            int parentLevel = temp.parentLevel;

            if(parentLevel != lastLevel){
                if(!curr.isEmpty()){
                    result.add(curr);
                }
                lastLevel = parentLevel;
                curr = new ArrayList<>();
            }

            curr.add(temp.node.val);

            if(currNode.left != null)
                queue.offer(new Tuple(currNode.left, parentLevel+1));
            if(currNode.right != null)
                queue.offer(new Tuple(currNode.right, parentLevel+1));
        }

        result.add(curr);

        return result;
    }
}
